package com.utcn.sd.assignment.mapper;

import com.utcn.sd.assignment.dto.QuestionDto;
import com.utcn.sd.assignment.model.Question;

public class QuestionMapper {

    public static Question toEntity(QuestionDto questionDto) {
        return new Question.QuestionBuilder()
                .idQuestion(questionDto.getIdQuestion())
                .idUser(questionDto.getIdUser())
                .likeCount(questionDto.getLikeCount())
                .title(questionDto.getTitle())
                .text(questionDto.getText())
                .creationDate(questionDto.getCreationDate())
                .build();
    }

    public static QuestionDto toDto(Question question) {
        return new QuestionDto.QuestionBuilder()
                .idQuestion(question.getIdQuestion())
                .idUser(question.getIdUser())
                .likeCount(question.getLikeCount())
                .title(question.getTitle())
                .text(question.getText())
                .creationDate(question.getCreationDate())
                .build();
    }
}
