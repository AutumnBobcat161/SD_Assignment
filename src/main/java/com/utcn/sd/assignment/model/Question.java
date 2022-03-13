package com.utcn.sd.assignment.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Question {
    private int idQuestion;
    private int idUser;
    private int likeCount;
    private String title;
    private String text;
    private LocalDateTime creationDate;

    public Question(int idQuestion, int idUser, int likeCount, String title, String text, LocalDateTime creationDate) {
        this.idQuestion = idQuestion;
        this.idUser = idUser;
        this.likeCount = likeCount;
        this.title = title;
        this.text = text;
        this.creationDate = creationDate;
    }

    public Question(int idUser, int likeCount, String title, String text, LocalDateTime creationDate) {
        this.idUser = idUser;
        this.likeCount = likeCount;
        this.title = title;
        this.text = text;
        this.creationDate = creationDate;
    }

    public Question() {
    }

    public Question(QuestionBuilder builder) {
        this.idQuestion = builder.idQuestion;
        this.idUser = builder.idUser;
        this.likeCount = builder.likeCount;
        this.text = builder.text;
        this.title = builder.title;
        this.creationDate = builder.creationDate;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return idQuestion == question.idQuestion && idUser == question.idUser && likeCount == question.likeCount && Objects.equals(title, question.title) && Objects.equals(text, question.text) && Objects.equals(creationDate, question.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idQuestion, idUser, likeCount, title, text, creationDate);
    }

    @Override
    public String toString() {
        return "Question{" +
                "idQuestion=" + idQuestion +
                ", idUser=" + idUser +
                ", likeCount=" + likeCount +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }

    public static class QuestionBuilder {
        private int idQuestion;
        private int idUser;
        private int likeCount;
        private String title;
        private String text;
        private LocalDateTime creationDate;

        public QuestionBuilder idQuestion(int idQuestion) {
            this.idQuestion = idQuestion;
            return this;
        }

        public QuestionBuilder idUser(int idUser) {
            this.idUser = idUser;
            return this;
        }

        public QuestionBuilder likeCount(int likeCount) {
            this.likeCount = likeCount;
            return this;
        }

        public QuestionBuilder title(String title) {
            this.title = title;
            return this;
        }

        public QuestionBuilder text(String text) {
            this.text = text;
            return this;
        }

        public QuestionBuilder creationDate(LocalDateTime creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public Question build() {
            return new Question(this);
        }
    }
}
