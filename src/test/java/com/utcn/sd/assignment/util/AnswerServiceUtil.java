package com.utcn.sd.assignment.util;

import com.utcn.sd.assignment.dto.AnswerDto;
import com.utcn.sd.assignment.model.Answer;

import java.util.List;

public class AnswerServiceUtil {

    public static Answer answer = new Answer.AnswerBuilder()
            .idAnswer(1)
            .idQuestion(1)
            .likeCount(1)
            .text("text")
            .build();

    public static Answer answerWithId2 = new Answer.AnswerBuilder()
            .idAnswer(2)
            .idQuestion(3)
            .likeCount(4)
            .text("teee")
            .build();

    public static AnswerDto answerDto = new AnswerDto.AnswerBuilder()
            .idAnswer(1)
            .idQuestion(1)
            .likeCount(1)
            .text("text")
            .build();

    public static AnswerDto answerDtoWithId2 = new AnswerDto.AnswerBuilder()
            .idAnswer(2)
            .idQuestion(3)
            .likeCount(4)
            .text("teee")
            .build();

    public static List<AnswerDto> answerDtoListResponse = List.of(answerDto, answerDtoWithId2);

}
