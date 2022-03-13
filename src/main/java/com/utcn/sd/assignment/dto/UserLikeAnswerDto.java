package com.utcn.sd.assignment.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "userLikeAnswer")
@Table(name = "user_like_answer")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class UserLikeAnswerDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user_like_answer")
    private int idUserLike;

    @Column(name = "id_user")
    private int idUser;

    @Column(name = "type")
    private int type;

    @Column(name = "id_answer")
    private int idAnswer;

    public UserLikeAnswerDto(int idUserLike, int idUser, int type, int idAnswer) {
        this.idUserLike = idUserLike;
        this.idUser = idUser;
        this.type = type;
        this.idAnswer = idAnswer;
    }

    public UserLikeAnswerDto(int idUser, int type, int idAnswer) {
        this.idUser = idUser;
        this.type = type;
        this.idAnswer = idAnswer;
    }

    public UserLikeAnswerDto() {
    }

    public UserLikeAnswerDto(UserLikeAnswerBuilder builder) {
        this.idUserLike = builder.idUserLike;
        this.type = builder.type;
        this.idUser = builder.idUser;
        this.idAnswer = builder.idAnswer;
    }

    public int getIdUserLike() {
        return idUserLike;
    }

    public void setIdUserLike(int idUserLike) {
        this.idUserLike = idUserLike;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(int idAnswer) {
        this.idAnswer = idAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLikeAnswerDto that = (UserLikeAnswerDto) o;
        return idUserLike == that.idUserLike && idUser == that.idUser && type == that.type && idAnswer == that.idAnswer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUserLike, idUser, type, idAnswer);
    }

    @Override
    public String toString() {
        return "UserLikeAnswer{" +
                "idUserLike=" + idUserLike +
                ", idUser=" + idUser +
                ", idLike=" + type +
                ", idQuestion=" + idAnswer +
                '}';
    }

    public static class UserLikeAnswerBuilder {
        private int idUserLike;
        private int idUser;
        private int type;
        private int idAnswer;

        public UserLikeAnswerBuilder idUserLike(int idUserLike) {
            this.idUserLike = idUserLike;
            return this;
        }

        public UserLikeAnswerBuilder idUser(int idUser) {
            this.idUser = idUser;
            return this;
        }

        public UserLikeAnswerBuilder type(int type) {
            this.type = type;
            return this;
        }

        public UserLikeAnswerBuilder idAnswer(int idAnswer) {
            this.idAnswer = idAnswer;
            return this;
        }

        public UserLikeAnswerDto build() {
            return new UserLikeAnswerDto(this);
        }
    }
}
