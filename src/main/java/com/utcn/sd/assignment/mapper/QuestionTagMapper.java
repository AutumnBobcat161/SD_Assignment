package com.utcn.sd.assignment.mapper;

import com.utcn.sd.assignment.dto.QuestionTagDto;
import com.utcn.sd.assignment.model.QuestionTag;

public class QuestionTagMapper {

    public static QuestionTag toEntity(QuestionTagDto questionDto) {
        return new QuestionTag.QuestionTagBuilder()
                .idQuestionTag(questionDto.getIdQuestionTag())
                .idQuestion(questionDto.getIdQuestion())
                .idTag(questionDto.getIdTag())
                .build();
    }

    public static QuestionTagDto toDto(QuestionTag question) {
        return new QuestionTagDto.QuestionTagBuilder()
                .idQuestionTag(question.getIdQuestionTag())
                .idQuestion(question.getIdQuestion())
                .idTag(question.getIdTag())
                .build();
    }
}
