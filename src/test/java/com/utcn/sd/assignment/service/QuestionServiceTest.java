package com.utcn.sd.assignment.service;

import com.utcn.sd.assignment.dto.QuestionDto;
import com.utcn.sd.assignment.mapper.QuestionMapper;
import com.utcn.sd.assignment.model.*;
import com.utcn.sd.assignment.repository.*;
import com.utcn.sd.assignment.service.question.QuestionServiceImpl;
import com.utcn.sd.assignment.service.question.QuestionTagServiceImpl;
import com.utcn.sd.assignment.util.AnswerServiceUtil;
import com.utcn.sd.assignment.util.MapperUtil;
import com.utcn.sd.assignment.util.QuestionServiceUtil;
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

public class QuestionServiceTest {

    @Mock
    private TagService tagService;

    @Mock
    private QuestionTagServiceImpl questionTagServiceImpl;

    @Mock
    private UserLikeQuestionRepository userLikeQuestionRepository;

    @Mock
    private QuestionRepository questionRepository;

    @Mock
    private AnswerService answerService;

    @InjectMocks
    private QuestionServiceImpl questionService;

    @BeforeEach
    void setup() {
        tagService = Mockito.mock(TagService.class);
        questionTagServiceImpl = Mockito.mock(QuestionTagServiceImpl.class);
        userLikeQuestionRepository = Mockito.mock(UserLikeQuestionRepository.class);
        questionRepository = Mockito.mock(QuestionRepository.class);
        answerService = Mockito.mock(AnswerService.class);
        openMocks(this);
        questionService = new QuestionServiceImpl(tagService, questionTagServiceImpl,
                userLikeQuestionRepository, questionRepository, answerService);
    }

    @Test
    public void whenGetAllQuestion_thenReturnAllQuestions() {
        when(tagService.getAllTags()).thenReturn(new ArrayList<>());
        when(questionTagServiceImpl.getAllQuestionTags()).thenReturn(new ArrayList<>());
        when(userLikeQuestionRepository.findAll()).thenReturn(new ArrayList<>());
        when(questionRepository.findAll()).thenReturn(QuestionServiceUtil.questionDtoList);
        when(answerService.getAllAnswers()).thenReturn(new ArrayList<>());

        List<QuestionResponse> questionResponses = questionService.getAllQuestions();

        assertEquals(questionResponses.get(0).getQuestion(), MapperUtil.questionExpected);
        assertEquals(questionResponses.get(1).getQuestion(), MapperUtil.question);
    }

    @Test
    public void whenGetById_thenShouldReturnOneIdTwo() {
        when(tagService.getAllTags()).thenReturn(new ArrayList<>());
        when(questionTagServiceImpl.getAllQuestionTags()).thenReturn(new ArrayList<>());
        when(userLikeQuestionRepository.findAll()).thenReturn(new ArrayList<>());
        when(questionRepository.getById(2)).thenReturn(MapperUtil.questionDto);
        when(answerService.getAllAnswers()).thenReturn(new ArrayList<>());

        QuestionResponse questionResponse  = questionService.getQuestionById(2);

        assertEquals(questionResponse.getQuestion(), MapperUtil.questionExpected);
    }

    @Test
    public void whenCreateQuestion_thenReturnQuestion() {
        when(questionRepository.save(QuestionMapper.toDto(new QuestionRequest(MapperUtil.question, new ArrayList<>()).getQuestion()))).thenReturn(MapperUtil.questionDtoExpected);

        Question question = questionService.createQuestion(new QuestionRequest(MapperUtil.question, new ArrayList<>()));

        assertEquals(question, MapperUtil.question);
    }
}
