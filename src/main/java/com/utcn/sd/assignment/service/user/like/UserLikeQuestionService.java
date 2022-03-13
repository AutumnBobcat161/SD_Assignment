package com.utcn.sd.assignment.service.user.like;

import com.utcn.sd.assignment.model.UserLikeAnswer;
import com.utcn.sd.assignment.model.UserLikeQuestion;

import java.util.List;

public interface UserLikeQuestionService {

    UserLikeQuestion getUserLikeQuestionById(int id);

    UserLikeQuestion createUserLikeQuestion(UserLikeQuestion likeQuestion);

    void deleteUserLikeQuestionById(int id);

    List<UserLikeQuestion> getAllUserLikeQuestion();
}
