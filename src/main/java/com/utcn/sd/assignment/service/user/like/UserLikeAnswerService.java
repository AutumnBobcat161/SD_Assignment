package com.utcn.sd.assignment.service.user.like;

import com.utcn.sd.assignment.model.UserLikeAnswer;

import java.util.List;

public interface UserLikeAnswerService {
    UserLikeAnswer getUserLikeAnswerById(int id);

    UserLikeAnswer createUserLikeAnswer(UserLikeAnswer likeAnswer);

    void deleteUserLikeAnswerById(int id);

    List<UserLikeAnswer> getAllUserLikeAnswer();
}
