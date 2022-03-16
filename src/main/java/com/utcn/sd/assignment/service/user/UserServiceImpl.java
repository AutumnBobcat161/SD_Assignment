package com.utcn.sd.assignment.service.user;

import com.utcn.sd.assignment.dto.UserDto;
import com.utcn.sd.assignment.exception.UserNotFoundError;
import com.utcn.sd.assignment.mapper.UserMapper;
import com.utcn.sd.assignment.model.User;
import com.utcn.sd.assignment.model.UserLoginRequest;
import com.utcn.sd.assignment.repository.UserRepository;
import com.utcn.sd.assignment.repository.UserRepositoryAux;
import com.utcn.sd.assignment.service.EmailServiceImpl;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    private UserRepositoryAux repositoryAux;

    public UserServiceImpl(UserRepository repository, UserRepositoryAux repositoryAux) {
        this.repository = repository;
        this.repositoryAux = repositoryAux;
    }

    @Override
    public User getUserById(int id) {
        return UserMapper.toEntity(repository.getById(id));
    }

    @Override
    public User createUser(User user) {
        return UserMapper.toEntity(repository.save(UserMapper.toDto(user)));
    }

    @Override
    public void deleteUserById(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll()
                .stream()
                .map(UserMapper::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public User getUserByEmail(String email) {
        Optional<UserDto> userDtoOptional = repositoryAux.getUserByEmail(email);
        if (userDtoOptional.isEmpty()) {
            throw new UserNotFoundError("User with email " + email + " not found!");
        }
        return UserMapper.toEntity(userDtoOptional.get());
    }

    @Override
    public User getUserByUsername(String username) {
        Optional<UserDto> userDtoOptional = repositoryAux.getUserByUsername(username);
        if (userDtoOptional.isEmpty()) {
            throw new UserNotFoundError("User with username " + username + " not found!");
        }
        return UserMapper.toEntity(userDtoOptional.get());
    }

    @Override
    public String login(UserLoginRequest userLoginRequest) {
        try {
            User user = getUserByUsername(userLoginRequest.getUsername());
            if (Objects.equals(user.getPassword(), userLoginRequest.getPassword())) {
                if (user.getBanned()) {
                    return "The user was banned";
                }
                return "Login successfully";
            }
            return "Wrong password";
        } catch (UserNotFoundError userNotFoundError) {
            return "The user could not be found!";
        }
    }

    @Override
    public void banUser(int id) {
        User user = getUserById(id);
        user.setBanned(true);
        try {
            EmailServiceImpl emailService = new EmailServiceImpl();
            emailService.sendSimpleMessage(user.getEmail(), "Banned account", "Your account was banned!");
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
        createUser(user);
    }

    @Override
    public void unbanUser(int id) {
        User user = getUserById(id);
        user.setBanned(false);
        try {
            EmailServiceImpl emailService = new EmailServiceImpl();
            emailService.sendSimpleMessage(user.getEmail(), "Unbanned account", "Your account is no longer banned!");
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
        createUser(user);
    }

}
