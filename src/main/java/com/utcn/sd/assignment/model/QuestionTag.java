package com.utcn.sd.assignment.model;

import java.util.Objects;

public class QuestionTag {
    private int idQuestionTag;
    private int idQuestion;
    private int idTag;

    public QuestionTag(int idQuestionTag, int idQuestion, int idTag) {
        this.idQuestionTag = idQuestionTag;
        this.idQuestion = idQuestion;
        this.idTag = idTag;
    }

    public QuestionTag(int idQuestion, int idTag) {
        this.idQuestion = idQuestion;
        this.idTag = idTag;
    }

    public QuestionTag() {
    }

    public QuestionTag(QuestionTagBuilder builder) {
        this.idQuestion = builder.idQuestion;
        this.idQuestionTag = builder.idQuestionTag;
        this.idTag = builder.idTag;
    }

    public int getIdQuestionTag() {
        return idQuestionTag;
    }

    public void setIdQuestionTag(int idQuestionTag) {
        this.idQuestionTag = idQuestionTag;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public int getIdTag() {
        return idTag;
    }

    public void setIdTag(int idTag) {
        this.idTag = idTag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionTag that = (QuestionTag) o;
        return idQuestionTag == that.idQuestionTag && idQuestion == that.idQuestion && idTag == that.idTag;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idQuestionTag, idQuestion, idTag);
    }

    @Override
    public String toString() {
        return "QuestionTag{" +
                "idQuestionTag=" + idQuestionTag +
                ", idQuestion=" + idQuestion +
                ", idTag=" + idTag +
                '}';
    }

    public static class QuestionTagBuilder {
        private int idQuestionTag;
        private int idQuestion;
        private int idTag;

        public QuestionTagBuilder idQuestionTag(int idQuestionTag) {
            this.idQuestionTag = idQuestionTag;
            return this;
        }

        public QuestionTagBuilder idQuestion(int idQuestion) {
            this.idQuestion = idQuestion;
            return this;
        }

        public QuestionTagBuilder idTag(int idTag) {
            this.idTag = idTag;
            return this;
        }

        public QuestionTag build() {
            return new QuestionTag(this);
        }
    }
}
