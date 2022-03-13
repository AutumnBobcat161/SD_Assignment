package com.utcn.sd.assignment.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "Question")
@Table(name = "question")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class QuestionDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_question")
    private int idQuestion;

    @Column(name = "id_user")
    private int idUser;

    @Column(name = "like_count")
    private int likeCount;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    public QuestionDto(int idQuestion, int idUser, int likeCount, String title, String text, LocalDateTime creationDate) {
        this.idQuestion = idQuestion;
        this.idUser = idUser;
        this.likeCount = likeCount;
        this.title = title;
        this.text = text;
        this.creationDate = creationDate;
    }

    public QuestionDto(int idUser, int likeCount, String title, String text, LocalDateTime creationDate) {
        this.idUser = idUser;
        this.likeCount = likeCount;
        this.title = title;
        this.text = text;
        this.creationDate = creationDate;
    }

    public QuestionDto() {
    }

    public QuestionDto(QuestionBuilder builder) {
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
        QuestionDto that = (QuestionDto) o;
        return idQuestion == that.idQuestion && idUser == that.idUser && likeCount == that.likeCount && Objects.equals(title, that.title) && Objects.equals(text, that.text) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idQuestion, idUser, likeCount, title, text, creationDate);
    }

    @Override
    public String toString() {
        return "QuestionDto{" +
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

        public QuestionDto build() {
            return new QuestionDto(this);
        }
    }
}
