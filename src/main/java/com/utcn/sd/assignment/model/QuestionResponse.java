package com.utcn.sd.assignment.model;

import java.util.List;
import java.util.Objects;

public class QuestionResponse {
    private Question question;
    private List<Tag> tags;
    private List<UserLikeQuestion> userLikeQuestions;
    private List<AnswerResponse> answers;

    public QuestionResponse(Question question, List<Tag> tags, List<UserLikeQuestion> userLikeQuestions, List<AnswerResponse> answers) {
        this.question = question;
        this.tags = tags;
        this.userLikeQuestions = userLikeQuestions;
        this.answers = answers;
    }

    public QuestionResponse() {

    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<UserLikeQuestion> getUserLikeQuestions() {
        return userLikeQuestions;
    }

    public void setUserLikeQuestions(List<UserLikeQuestion> userLikeQuestions) {
        this.userLikeQuestions = userLikeQuestions;
    }

    public List<AnswerResponse> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerResponse> answers) {
        this.answers = answers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionResponse that = (QuestionResponse) o;
        return Objects.equals(question, that.question) && Objects.equals(tags, that.tags) && Objects.equals(userLikeQuestions, that.userLikeQuestions) && Objects.equals(answers, that.answers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, tags, userLikeQuestions, answers);
    }

    @Override
    public String toString() {
        return "QuestionResponse{" +
                "question=" + question +
                ", tags=" + tags +
                ", userLikeQuestions=" + userLikeQuestions +
                ", answers=" + answers +
                '}';
    }
}
