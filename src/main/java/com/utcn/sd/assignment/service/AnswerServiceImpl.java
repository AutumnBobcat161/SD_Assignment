package com.utcn.sd.assignment.service;

import com.utcn.sd.assignment.mapper.AnswerMapper;
import com.utcn.sd.assignment.mapper.UserLikeAnswerMapper;
import com.utcn.sd.assignment.model.Answer;
import com.utcn.sd.assignment.model.AnswerResponse;
import com.utcn.sd.assignment.model.SortByVotes;
import com.utcn.sd.assignment.model.UserLikeAnswer;
import com.utcn.sd.assignment.repository.AnswerRepository;
import com.utcn.sd.assignment.repository.UserLikeAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnswerServiceImpl implements AnswerService {

    private AnswerRepository answerRepository;

    private UserLikeAnswerRepository userLikeAnswerRepository;

    public AnswerServiceImpl(AnswerRepository answerRepository, UserLikeAnswerRepository userLikeAnswerRepository) {
        this.answerRepository = answerRepository;
        this.userLikeAnswerRepository = userLikeAnswerRepository;
    }

    @Override
    public AnswerResponse getAnswerById(int id) {
        AnswerResponse response = new AnswerResponse();
        response.setAnswer(AnswerMapper.toEntity(answerRepository.getById(id)));
        return response;
    }

    @Override
    public Answer createAnswer(Answer answer) {
        return AnswerMapper.toEntity(answerRepository.save(AnswerMapper.toDto(answer)));
    }

    @Override
    public void deleteAnswerById(int id) {
        answerRepository.deleteById(id);
    }

    @Override
    public List<AnswerResponse> getAllAnswers() {
        return answerRepository.findAll()
                .stream()
                .map(answerDto -> {
                    AnswerResponse response = new AnswerResponse();
                    Answer answer = AnswerMapper.toEntity(answerDto);
                    response.setUserLikeAnswers(getAllLikesForAnswer(answer.getIdAnswer()));
                    response.setAnswer(answer);
                    return response;
                })
                .sorted(new SortByVotes())
                .collect(Collectors.toList());
    }

    private List<UserLikeAnswer> getAllLikesForAnswer(int idAnswer) {
        return userLikeAnswerRepository.findAll()
                .stream()
                .map(UserLikeAnswerMapper::toEntity)
                .filter(userLikeAnswer -> userLikeAnswer.getIdAnswer() == idAnswer)
                .collect(Collectors.toList());
    }
}
