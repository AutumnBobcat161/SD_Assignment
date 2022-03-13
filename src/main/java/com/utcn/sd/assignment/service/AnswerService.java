package com.utcn.sd.assignment.service;

import com.utcn.sd.assignment.model.Answer;
import com.utcn.sd.assignment.model.AnswerResponse;

import java.util.List;

public interface AnswerService {

    AnswerResponse getAnswerById(int id);

    Answer createAnswer(Answer Answer);

    void deleteAnswerById(int id);

    List<AnswerResponse> getAllAnswers();
}
