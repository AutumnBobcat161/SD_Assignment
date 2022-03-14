package com.utcn.sd.assignment.util;

import com.utcn.sd.assignment.dto.AnswerDto;
import com.utcn.sd.assignment.dto.QuestionDto;
import com.utcn.sd.assignment.dto.UserDto;
import com.utcn.sd.assignment.model.Answer;
import com.utcn.sd.assignment.model.Question;
import com.utcn.sd.assignment.model.User;

import java.time.LocalDateTime;


public class MapperUtil {

    private static final LocalDateTime now = LocalDateTime.now();

    public static Answer answer = new Answer.AnswerBuilder()
            .idAnswer(1)
            .idQuestion(1)
            .likeCount(1)
            .creationDate(now)
            .text("text")
            .build();

    public static Answer answerExpected = new Answer.AnswerBuilder()
            .idAnswer(2)
            .idQuestion(2)
            .likeCount(2)
            .creationDate(now)
            .text("text2")
            .build();


    public static AnswerDto answerDTO = new AnswerDto.AnswerBuilder()
            .idAnswer(2)
            .idQuestion(2)
            .likeCount(2)
            .creationDate(now)
            .text("text2")
            .build();

    public static AnswerDto answerDtoExpected = new AnswerDto.AnswerBuilder()
            .idAnswer(1)
            .idQuestion(1)
            .likeCount(1)
            .creationDate(now)
            .text("text")
            .build();

    public static Question question = new Question.QuestionBuilder()
            .title("title")
            .likeCount(1)
            .idQuestion(1)
            .idUser(1)
            .creationDate(now)
            .build();

    public static Question questionExpected = new Question.QuestionBuilder()
            .title("title2")
            .likeCount(2)
            .idQuestion(2)
            .idUser(2)
            .creationDate(now)
            .build();

    public static QuestionDto questionDto = new QuestionDto.QuestionBuilder()
            .title("title2")
            .likeCount(2)
            .idQuestion(2)
            .idUser(2)
            .creationDate(now)
            .build();

    public static QuestionDto questionDtoExpected = new QuestionDto.QuestionBuilder()
            .title("title")
            .likeCount(1)
            .idQuestion(1)
            .idUser(1)
            .creationDate(now)
            .build();

    public static User user = new User.UserBuilder()
            .idUser(1)
            .idRole(1)
            .isBanned(false)
            .password("a")
            .email("a")
            .username("a")
            .build();

    public static User userExpected = new User.UserBuilder()
            .idUser(2)
            .idRole(2)
            .isBanned(false)
            .password("b")
            .email("b")
            .username("b")
            .build();

    public static UserDto userDtoExpected = new UserDto.UserBuilder()
            .idUser(1)
            .idRole(1)
            .isBanned(false)
            .password("a")
            .email("a")
            .username("a")
            .build();

    public static UserDto userDto = new UserDto.UserBuilder()
            .idUser(2)
            .idRole(2)
            .isBanned(false)
            .password("b")
            .email("b")
            .username("b")
            .build();
}
