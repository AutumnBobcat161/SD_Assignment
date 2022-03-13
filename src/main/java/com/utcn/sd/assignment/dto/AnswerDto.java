package com.utcn.sd.assignment.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "Answer")
@Table(name = "answer")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class AnswerDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_answer")
    private int idAnswer;

    @Column(name = "id_user")
    private int idUser;

    @Column(name = "id_question")
    private int idQuestion;

    @Column(name = "like_count")
    private int likeCount;

    @Column(name = "text")
    private String text;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    public AnswerDto(int idAnswer, int idUser, int idQuestion, int likeCount, String text, LocalDateTime creationDate) {
        this.idAnswer = idAnswer;
        this.idUser = idUser;
        this.idQuestion = idQuestion;
        this.likeCount = likeCount;
        this.text = text;
        this.creationDate = creationDate;
    }

    public AnswerDto(int idUser, String text, int idQuestion, int likeCount, LocalDateTime creationDate) {
        this.idUser = idUser;
        this.idQuestion = idQuestion;
        this.likeCount = likeCount;
        this.text = text;
        this.creationDate = creationDate;
    }

    public AnswerDto() {
    }

    public AnswerDto(AnswerBuilder builder) {
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
        AnswerDto answerDto = (AnswerDto) o;
        return idAnswer == answerDto.idAnswer && idUser == answerDto.idUser && idQuestion == answerDto.idQuestion && likeCount == answerDto.likeCount && Objects.equals(text, answerDto.text) && Objects.equals(creationDate, answerDto.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnswer, idUser, idQuestion, likeCount, text, creationDate);
    }

    @Override
    public String toString() {
        return "AnswerDto{" +
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

        public AnswerDto build() {
            return new AnswerDto(this);
        }
    }
}
