package com.utcn.sd.assignment.model;

import java.util.List;
import java.util.Objects;

public class QuestionRequest {

    private Question question;
    private List<Tag> tags;

    public QuestionRequest(Question question, List<Tag> tags) {
        this.question = question;
        this.tags = tags;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionRequest that = (QuestionRequest) o;
        return Objects.equals(question, that.question) && Objects.equals(tags, that.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, tags);
    }

    @Override
    public String toString() {
        return "QuestionResponse{" +
                "question=" + question +
                ", tags=" + tags +
                '}';
    }
}
