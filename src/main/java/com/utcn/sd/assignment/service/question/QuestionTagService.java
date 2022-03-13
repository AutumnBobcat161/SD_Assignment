package com.utcn.sd.assignment.service.question;

import com.utcn.sd.assignment.model.QuestionTag;

import java.util.List;

public interface QuestionTagService {
    QuestionTag getQuestionTagById(int id);

    QuestionTag createQuestionTag(QuestionTag questionTag);

    List<QuestionTag> getAllQuestionTags();
}
