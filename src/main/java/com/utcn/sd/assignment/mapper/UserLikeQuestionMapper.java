package com.utcn.sd.assignment.mapper;

import com.utcn.sd.assignment.dto.UserLikeQuestionDto;
import com.utcn.sd.assignment.model.UserLikeQuestion;

public class UserLikeQuestionMapper {
    
    public static UserLikeQuestion toEntity(UserLikeQuestionDto userLikeQuestionDto) {
        return new UserLikeQuestion.UserLikeQuestionBuilder()
                .idQuestion(userLikeQuestionDto.getIdQuestion())
                .type(userLikeQuestionDto.getType())
                .idUserLike(userLikeQuestionDto.getIdUserLike())
                .idUser(userLikeQuestionDto.getIdUser())
                .build();
    }

    public static UserLikeQuestionDto toDto(UserLikeQuestion userLikeQuestion) {
        return new UserLikeQuestionDto.UserLikeQuestionBuilder()
                .idQuestion(userLikeQuestion.getIdQuestion())
                .type(userLikeQuestion.getType())
                .idUserLike(userLikeQuestion.getIdUserLike())
                .idUser(userLikeQuestion.getIdUser())
                .build();
    }
}
