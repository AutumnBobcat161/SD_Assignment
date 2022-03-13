package com.utcn.sd.assignment.service.user.like;

import com.utcn.sd.assignment.mapper.UserLikeQuestionMapper;
import com.utcn.sd.assignment.model.*;
import com.utcn.sd.assignment.repository.UserLikeQuestionRepository;
import com.utcn.sd.assignment.service.TagServiceImpl;
import com.utcn.sd.assignment.service.question.QuestionServiceImpl;
import com.utcn.sd.assignment.service.question.QuestionTagServiceImpl;
import com.utcn.sd.assignment.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserLikeQuestionServiceImpl implements UserLikeQuestionService {

    @Autowired
    private QuestionServiceImpl questionService;

    @Autowired
    private TagServiceImpl tagService;

    @Autowired
    private QuestionTagServiceImpl questionTagService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserLikeQuestionRepository userLikeQuestionRepository;

    @Override
    public UserLikeQuestion getUserLikeQuestionById(int id) {
        return UserLikeQuestionMapper.toEntity(userLikeQuestionRepository.getById(id));
    }

    @Override
    public UserLikeQuestion createUserLikeQuestion(UserLikeQuestion likeQuestion) {
        updateScoreForUsers(likeQuestion);
        return UserLikeQuestionMapper.toEntity(userLikeQuestionRepository.save(UserLikeQuestionMapper.toDto(likeQuestion)));
    }

    @Override
    public void deleteUserLikeQuestionById(int id) {
        userLikeQuestionRepository.deleteById(id);
    }

    @Override
    public List<UserLikeQuestion> getAllUserLikeQuestion() {
        return userLikeQuestionRepository.findAll()
                .stream()
                .map(UserLikeQuestionMapper::toEntity)
                .collect(Collectors.toList());
    }

    private Optional<UserLikeQuestion> findLike(UserLikeQuestion userLikeQuestion) {
        return getAllUserLikeQuestion()
                .stream()
                .filter(like -> like.getIdQuestion() == userLikeQuestion.getIdQuestion()
                        && like.getIdUser() == userLikeQuestion.getIdUser())
                .findFirst();
    }

    /**
     This method updates the score for the question/users depending on the like and if there was another like before
     for the same answer from the same user
     */
    private void updateScoreForUsers(UserLikeQuestion userLikeQuestion) {
        Question question = questionService.getQuestionById(userLikeQuestion.getIdQuestion()).getQuestion();
        User userLiked = userService.getUserById(question.getIdUser());
        Optional<UserLikeQuestion> userLikeQuestion1 = findLike(userLikeQuestion);

        if(userLikeQuestion1.isPresent())
        {
            if(userLikeQuestion1.get().getType() == 0)
            {//If the current like is downvote, then the new one is an upvote
                userLiked.setScore(userLiked.getScore() + 7);
                question.setLikeCount(question.getLikeCount() + 2);
            }
            else
            {//otherwise, the new one is an downvote
                userLiked.setScore(userLiked.getScore() - 7);
                question.setLikeCount(question.getLikeCount() - 2);
            }
            deleteUserLikeQuestionById(userLikeQuestion1.get().getIdUserLike());//delete the old like
        }
        else
        {
            if (userLikeQuestion.getType() == 0) {//Dislike
                userLiked.setScore(userLiked.getScore() - 2);
                question.setLikeCount(question.getLikeCount() - 1);
            } else {//Like
                userLiked.setScore(userLiked.getScore() + 5);
                question.setLikeCount(question.getLikeCount() + 1);
            }
        }
        userService.createUser(userLiked);
        List<Tag> tags = getAllQuestionTags(question.getIdQuestion())
                .stream()
                .map(tag -> tagService.getTagById(tag.getIdTag())).toList();
        QuestionRequest questionRequest = new QuestionRequest(question, tags);
        questionService.createQuestion(questionRequest);
    }

    private List<QuestionTag> getAllQuestionTags(int idQuestion) {
        return questionTagService.getAllQuestionTags()
                .stream()
                .filter(tag -> tag.getIdQuestion() == idQuestion)
                .collect(Collectors.toList());
    }
}
