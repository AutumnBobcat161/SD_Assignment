package com.utcn.sd.assignment.model;

import java.util.List;
import java.util.Objects;

public class AnswerResponse {
    private Answer answer;
    private List<UserLikeAnswer> userLikeAnswers;

    public AnswerResponse() {
    }

    public AnswerResponse(Answer answer, List<UserLikeAnswer> userLikeAnswers) {
        this.answer = answer;
        this.userLikeAnswers = userLikeAnswers;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public List<UserLikeAnswer> getUserLikeAnswers() {
        return userLikeAnswers;
    }

    public void setUserLikeAnswers(List<UserLikeAnswer> userLikeAnswers) {
        this.userLikeAnswers = userLikeAnswers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswerResponse that = (AnswerResponse) o;
        return Objects.equals(answer, that.answer) && Objects.equals(userLikeAnswers, that.userLikeAnswers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answer, userLikeAnswers);
    }

    @Override
    public String toString() {
        return "AnswerResponse{" +
                "answer=" + answer +
                ", userLikeAnswers=" + userLikeAnswers +
                '}';
    }
}
