package com.utcn.sd.assignment.service.question;

import com.utcn.sd.assignment.model.Question;
import com.utcn.sd.assignment.model.QuestionRequest;
import com.utcn.sd.assignment.model.QuestionResponse;
import com.utcn.sd.assignment.model.SearchRequest;

import java.util.List;

public interface QuestionService {
    QuestionResponse getQuestionById(int id);

    Question createQuestion(QuestionRequest question);

    void deleteQuestionById(int id);

    List<QuestionResponse> getAllQuestions();

    List<QuestionResponse> searchQuestions(SearchRequest request);
}
