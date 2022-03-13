package com.utcn.sd.assignment.mapper;

import com.utcn.sd.assignment.dto.AnswerDto;
import com.utcn.sd.assignment.model.Answer;

public class AnswerMapper {
    
    public static Answer toEntity(AnswerDto answerDto) {
        return new Answer.AnswerBuilder()
                .idAnswer(answerDto.getIdAnswer())
                .idUser(answerDto.getIdUser())
                .idQuestion(answerDto.getIdQuestion())
                .likeCount(answerDto.getLikeCount())
                .text(answerDto.getText())
                .creationDate(answerDto.getCreationDate())
                .build();
    }

    public static AnswerDto toDto(Answer answer) {
        return new AnswerDto.AnswerBuilder()
                .idAnswer(answer.getIdAnswer())
                .idUser(answer.getIdUser())
                .idQuestion(answer.getIdQuestion())
                .likeCount(answer.getLikeCount())
                .text(answer.getText())
                .creationDate(answer.getCreationDate())
                .build();
    }
}
