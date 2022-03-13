package com.utcn.sd.assignment.service.user.like;

import com.utcn.sd.assignment.mapper.UserLikeAnswerMapper;
import com.utcn.sd.assignment.model.Answer;
import com.utcn.sd.assignment.model.User;
import com.utcn.sd.assignment.model.UserLikeAnswer;
import com.utcn.sd.assignment.repository.UserLikeAnswerRepository;
import com.utcn.sd.assignment.service.AnswerServiceImpl;
import com.utcn.sd.assignment.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserLikeAnswerServiceImpl implements  UserLikeAnswerService {

    @Autowired
    private AnswerServiceImpl answerService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserLikeAnswerRepository userLikeAnswerRepository;

    @Override
    public UserLikeAnswer getUserLikeAnswerById(int id) {
        return UserLikeAnswerMapper.toEntity(userLikeAnswerRepository.getById(id));
    }

    @Override
    public UserLikeAnswer createUserLikeAnswer(UserLikeAnswer likeAnswer) {
        updateScoreForUsers(likeAnswer);
        return UserLikeAnswerMapper.toEntity(userLikeAnswerRepository.save(UserLikeAnswerMapper.toDto(likeAnswer)));
    }

    @Override
    public void deleteUserLikeAnswerById(int id) {
        userLikeAnswerRepository.deleteById(id);
    }

    @Override
    public List<UserLikeAnswer> getAllUserLikeAnswer() {
        return userLikeAnswerRepository.findAll()
                .stream()
                .map(UserLikeAnswerMapper::toEntity)
                .collect(Collectors.toList());
    }


    private Optional<UserLikeAnswer> findLike(UserLikeAnswer userLikeAnswer) {
        return getAllUserLikeAnswer()
                .stream()
                .filter(like -> like.getIdAnswer() == userLikeAnswer.getIdAnswer()
                        && like.getIdUser() == userLikeAnswer.getIdUser())
                .findFirst();
    }

    /**
     This method updates the score for the answer/users depending on the like and if there was another like before
     for the same answer from the same user
     */
    private void updateScoreForUsers(UserLikeAnswer userLikeAnswer) {
        User userLike = userService.getUserById(userLikeAnswer.getIdUser());
        Answer answer = answerService.getAnswerById(userLikeAnswer.getIdAnswer()).getAnswer();
        User userLiked = userService.getUserById(answer.getIdUser());
        Optional<UserLikeAnswer> userLikeAnswer1 = findLike(userLikeAnswer);
        if(userLikeAnswer1.isPresent())
        {
            if(userLikeAnswer1.get().getType() == 0)
            {//If the current like is downvote, then the new one is an upvote
                userLike.setScore(userLike.getScore() + 1);//Gets the point back for liking after dislike
                userLiked.setScore(userLiked.getScore() + 12);//the old like == -2 + 10 => -12 points addition to compensate
                answer.setLikeCount(answer.getLikeCount() + 2);//the vote count had -1 so to get to 1 we have to add 2
            }
            else
            {//otherwise, the new one is an downvote
                userLike.setScore(userLike.getScore() - 1);//the user gets one point deduced because of the dislike
                userLiked.setScore(userLiked.getScore() - 12);//the old like == 10 - 2 => -12 points deduction
                answer.setLikeCount(answer.getLikeCount() - 2);//the vote count had 1 so to get to -1 we have to add -2
            }
            deleteUserLikeAnswerById(userLikeAnswer1.get().getIdUserLike());//delete the old like
        }
        else
        {
            if (userLikeAnswer.getType() == 0) {//Dislike
                userLike.setScore(userLike.getScore() - 1);
                userLiked.setScore(userLiked.getScore() - 2);
                answer.setLikeCount(answer.getLikeCount() - 1);
            } else {//Like
                userLiked.setScore(userLiked.getScore() + 10);
                answer.setLikeCount(answer.getLikeCount() + 1);
            }
        }
        userService.createUser(userLike);
        userService.createUser(userLiked);
        answerService.createAnswer(answer);
    }
}
