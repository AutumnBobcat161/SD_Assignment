package com.utcn.sd.assignment.mapper;

import com.utcn.sd.assignment.dto.UserLikeAnswerDto;
import com.utcn.sd.assignment.model.UserLikeAnswer;

public class UserLikeAnswerMapper {
    
    public static UserLikeAnswer toEntity(UserLikeAnswerDto userLikeAnswerDto) {
        return new UserLikeAnswer.UserLikeAnswerBuilder()
                .idAnswer(userLikeAnswerDto.getIdAnswer())
                .type(userLikeAnswerDto.getType())
                .idUserLike(userLikeAnswerDto.getIdUserLike())
                .idUser(userLikeAnswerDto.getIdUser())
                .build();
    }

    public static UserLikeAnswerDto toDto(UserLikeAnswer userLikeAnswer) {
        return new UserLikeAnswerDto.UserLikeAnswerBuilder()
                .idAnswer(userLikeAnswer.getIdAnswer())
                .type(userLikeAnswer.getType())
                .idUserLike(userLikeAnswer.getIdUserLike())
                .idUser(userLikeAnswer.getIdUser())
                .build();
    }
}
