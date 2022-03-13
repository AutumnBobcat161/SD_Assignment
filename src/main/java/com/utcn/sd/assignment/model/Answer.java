package com.utcn.sd.assignment.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Answer {
    private int idAnswer;
    private int idUser;
    private int idQuestion;
    private int likeCount;
    private String text;
    private LocalDateTime creationDate;

    public Answer(int idAnswer, int idUser, int idQuestion, int likeCount, String text, LocalDateTime creationDate) {
        this.idAnswer = idAnswer;
        this.idUser = idUser;
        this.idQuestion = idQuestion;
        this.likeCount = likeCount;
        this.text = text;
        this.creationDate = creationDate;
    }

    public Answer(int idUser, String text, int idQuestion, int likeCount, LocalDateTime creationDate) {
        this.idUser = idUser;
        this.idQuestion = idQuestion;
        this.likeCount = likeCount;
        this.text = text;
        this.creationDate = creationDate;
    }

    public Answer() {
    }

    public Answer(AnswerBuilder builder) {
        this.idAnswer = builder.idAnswer;
        this.idUser = builder.idUser;
        this.idQuestion = builder.idQuestion;
        this.likeCount = builder.likeCount;
        this.text = builder.text;
        this.creationDate = builder.creationDate;
    }

    public int getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(int idAnswer) {
        this.idAnswer = idAnswer;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
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
        Answer answer = (Answer) o;
        return idAnswer == answer.idAnswer && idUser == answer.idUser && idQuestion == answer.idQuestion && likeCount == answer.likeCount && Objects.equals(text, answer.text) && Objects.equals(creationDate, answer.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnswer, idUser, idQuestion, likeCount, text, creationDate);
    }

    @Override
    public String toString() {
        return "Answer{" +
                "idAnswer=" + idAnswer +
                ", idUser=" + idUser +
                ", idQuestion=" + idQuestion +
                ", likeCount=" + likeCount +
                ", text='" + text + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }

    public static class AnswerBuilder {
        private int idAnswer;
        private int idUser;
        private int idQuestion;
        private int likeCount;
        private String text;
        private LocalDateTime creationDate;

        public AnswerBuilder idAnswer(int idAnswer) {
            this.idAnswer = idAnswer;
            return this;
        }

        public AnswerBuilder idUser(int idUser) {
            this.idUser = idUser;
            return this;
        }

        public AnswerBuilder idQuestion(int idQuestion) {
            this.idQuestion = idQuestion;
            return this;
        }

        public AnswerBuilder likeCount(int likeCount) {
            this.likeCount = likeCount;
            return this;
        }


        public AnswerBuilder text(String text) {
            this.text = text;
            return this;
        }

        public AnswerBuilder creationDate(LocalDateTime creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public Answer build() {
            return new Answer(this);
        }
    }
}
