package com.utcn.sd.assignment.service;

import com.utcn.sd.assignment.model.Answer;
import com.utcn.sd.assignment.model.AnswerResponse;
import com.utcn.sd.assignment.repository.AnswerRepository;
import com.utcn.sd.assignment.repository.UserLikeAnswerRepository;
import com.utcn.sd.assignment.util.AnswerServiceUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class AnswerServiceTest {

    @Mock
    private AnswerRepository answerRepository;

    @Mock
    private UserLikeAnswerRepository userLikeanswerRepository;

    @InjectMocks
    private AnswerServiceImpl answerService;

    @BeforeEach
    void setup() {
        answerRepository = Mockito.mock(AnswerRepository.class);
        userLikeanswerRepository = Mockito.mock(UserLikeAnswerRepository.class);
        openMocks(this);
        answerService = new AnswerServiceImpl(answerRepository, userLikeanswerRepository);
    }

    @Test
    public void whenGetAllAnswer_thenReturnAllAnswers() {
        when(answerRepository.findAll()).thenReturn(AnswerServiceUtil.answerDtoListResponse);
        when(userLikeanswerRepository.findAll()).thenReturn(new ArrayList<>());

        List<AnswerResponse> answerResponseList = answerService.getAllAnswers();

        assertEquals(answerResponseList.get(0).getAnswer(), AnswerServiceUtil.answerWithId2);
        assertEquals(answerResponseList.get(1).getAnswer(), AnswerServiceUtil.answer);
    }

    @Test
    public void whenGetById_thenShouldReturnOneIdTwo() {
        when(answerRepository.getById(2)).thenReturn(AnswerServiceUtil.answerDtoWithId2);
        when(userLikeanswerRepository.findAll()).thenReturn(new ArrayList<>());

        AnswerResponse answerResponse  = answerService.getAnswerById(2);

        assertEquals(answerResponse.getAnswer(), AnswerServiceUtil.answerWithId2);
    }

    @Test
    public void whenCreateAnswer_thenReturnAnswer() {
        when(answerRepository.save(AnswerServiceUtil.answerDto)).thenReturn(AnswerServiceUtil.answerDto);

        Answer answer = answerService.createAnswer(AnswerServiceUtil.answer);

        assertEquals(answer, AnswerServiceUtil.answer);
    }
}
