package com.utcn.sd.assignment.service.question;

import com.utcn.sd.assignment.mapper.QuestionMapper;
import com.utcn.sd.assignment.mapper.UserLikeQuestionMapper;
import com.utcn.sd.assignment.model.*;
import com.utcn.sd.assignment.repository.QuestionRepository;
import com.utcn.sd.assignment.repository.UserLikeQuestionRepository;
import com.utcn.sd.assignment.service.AnswerService;
import com.utcn.sd.assignment.service.TagService;
import com.utcn.sd.assignment.service.user.like.UserLikeQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService{

    private TagService tagService;

    private QuestionTagServiceImpl questionTagService;

    private UserLikeQuestionRepository userLikeQuestionRepository;

    private QuestionRepository questionRepository;

    private AnswerService answerService;

    public QuestionServiceImpl(TagService tagService, QuestionTagServiceImpl questionTagService,
                               UserLikeQuestionRepository userLikeQuestionRepository, QuestionRepository questionRepository, AnswerService answerService) {
        this.tagService = tagService;
        this.questionTagService = questionTagService;
        this.userLikeQuestionRepository = userLikeQuestionRepository;
        this.questionRepository = questionRepository;
        this.answerService = answerService;
    }

    @Override
    public QuestionResponse getQuestionById(int id) {
        QuestionResponse response = new QuestionResponse();
        Question question = QuestionMapper.toEntity(questionRepository.getById(id));
        response.setQuestion(question);
        response.setTags(getAllTagsForQuestion(question.getIdQuestion()));
        response.setUserLikeQuestions(getAllLikesForQuestion(question.getIdQuestion()));
        response.setAnswers(answerService.getAllAnswers()
                .stream()
                .filter(answerResponse -> answerResponse.getAnswer().getIdQuestion() == id)
                .collect(Collectors.toList()));
        return response;
    }

    @Override
    public Question createQuestion(QuestionRequest question) {
        Question questionAdded = QuestionMapper.toEntity(questionRepository.save(QuestionMapper.toDto(question.getQuestion())));
        question.setQuestion(questionAdded);
        addTags(question);
        return questionAdded;
    }

    @Override
    public void deleteQuestionById(int id) {
        questionRepository.deleteById(id);
    }

    @Override
    public List<QuestionResponse> getAllQuestions() {
        return questionRepository.findAll()
                .stream()
                .map(questionDto -> {
                    QuestionResponse response = new QuestionResponse();
                    Question question = QuestionMapper.toEntity(questionDto);
                    response.setQuestion(question);
                    response.setTags(getAllTagsForQuestion(question.getIdQuestion()));
                    response.setUserLikeQuestions(getAllLikesForQuestion(question.getIdQuestion()));
                    response.setAnswers(answerService.getAllAnswers()
                            .stream()
                            .filter(answerResponse -> answerResponse.getAnswer().getIdQuestion() == question.getIdQuestion())
                            .collect(Collectors.toList()));
                    return response;
                })
                .sorted(new SortByCreationDate())
                .collect(Collectors.toList());
    }

    @Override
    public List<QuestionResponse> searchQuestions(SearchRequest request) {
        List<QuestionResponse> questions = this.getAllQuestions();
        List<QuestionResponse> filteredQuestions = new ArrayList<>();
        for (QuestionResponse question : questions) {
            boolean addToFilteredList = true;
            if (!request.title.isBlank()) {
                if (!question.getQuestion().getTitle().toLowerCase().contains(request.getTitle().toLowerCase())) {
                    addToFilteredList = false;
                }
            }
            if (!request.getTags().isEmpty()) {
                int numberOfTags = 0;
                for (Tag tag : request.getTags()) {
                    if (getAllTags(question.getQuestion().getIdQuestion())
                            .stream()
                            .anyMatch(questionTag -> questionTag.getIdTag() == tag.getIdTag())) {
                        numberOfTags++;
                    }
                }
                if (numberOfTags == 0) {//not even one tag was matched then the question is not displayed
                    addToFilteredList = false;
                }
            }
            if (addToFilteredList) {
                filteredQuestions.add(question);
            }
        }
        return filteredQuestions;
    }

    private void addTags(QuestionRequest question) {
        Question questionResponse = question.getQuestion();
        for (Tag tag : question.getTags()) {
            Optional<Tag> tagQuestion = tagService.getAllTags()
                    .stream()
                    .filter(tag2 -> tag2.getName().equals(tag.getName()))
                    .findFirst();
            if(tagQuestion.isPresent()) {
                boolean isAlreadyAddedAsTag = questionTagService.getAllQuestionTags().stream()
                        .anyMatch(questionTag -> questionTag.getIdTag() == tagQuestion.get().getIdTag()
                                && questionTag.getIdQuestion() == questionResponse.getIdQuestion());
                if(!isAlreadyAddedAsTag) {
                    QuestionTag questionTag = new QuestionTag(questionResponse.getIdQuestion(), tagQuestion.get().getIdTag());
                    questionTagService.createQuestionTag(questionTag);
                }
            } else {
                Tag tag3= tagService.createTag(new Tag(tag.getName()));
                QuestionTag questionTag = new QuestionTag(questionResponse.getIdQuestion(), tag3.getIdTag());
                questionTagService.createQuestionTag(questionTag);
            }
        }
    }

    private List<QuestionTag> getAllTags(int idQuestion) {
        return questionTagService.getAllQuestionTags()
                .stream()
                .filter(tag -> tag.getIdQuestion() == idQuestion)
                .collect(Collectors.toList());
    }

    private List<Tag> getAllTagsForQuestion(int idQuestion) {
        return  questionTagService.getAllQuestionTags()
                .stream()
                .filter(tag -> tag.getIdQuestion() == idQuestion)
                .map(tag -> tagService.getTagById(tag.getIdTag()))
                .collect(Collectors.toList());
    }

    private List<UserLikeQuestion> getAllLikesForQuestion(int idQuestion) {
        return userLikeQuestionRepository.findAll()
                .stream()
                .map(UserLikeQuestionMapper::toEntity)
                .filter(userLikeQuestion -> userLikeQuestion.getIdQuestion() == idQuestion)
                .collect(Collectors.toList());
    }
}
