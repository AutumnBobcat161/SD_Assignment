package com.utcn.sd.assignment.model;

import java.util.Objects;

public class UserLikeQuestion {
    private int idUserLike;
    private int idUser;
    private int type;

    private int idQuestion;

    public UserLikeQuestion(int idUserLike, int idUser, int type, int idQuestion) {
        this.idUserLike = idUserLike;
        this.idUser = idUser;
        this.type = type;
        this.idQuestion = idQuestion;
    }

    public UserLikeQuestion(int idUser, int type, int idQuestion) {
        this.idUser = idUser;
        this.type = type;
        this.idQuestion = idQuestion;
    }

    public UserLikeQuestion() {
    }

    public UserLikeQuestion(UserLikeQuestionBuilder builder) {
        this.idUserLike = builder.idUserLike;
        this.type = builder.type;
        this.idUser = builder.idUser;
        this.idQuestion = builder.idQuestion;
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

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLikeQuestion that = (UserLikeQuestion) o;
        return idUserLike == that.idUserLike && idUser == that.idUser && type == that.type && idQuestion == that.idQuestion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUserLike, idUser, type, idQuestion);
    }

    @Override
    public String toString() {
        return "UserLikeQuestion{" +
                "idUserLike=" + idUserLike +
                ", idUser=" + idUser +
                ", idLike=" + type +
                ", idQuestion=" + idQuestion +
                '}';
    }

    public static class UserLikeQuestionBuilder {
        private int idUserLike;
        private int idUser;
        private int type;
        private int idQuestion;

        public UserLikeQuestionBuilder idUserLike(int idUserLike) {
            this.idUserLike = idUserLike;
            return this;
        }

        public UserLikeQuestionBuilder idUser(int idUser) {
            this.idUser = idUser;
            return this;
        }

        public UserLikeQuestionBuilder type(int type) {
            this.type = type;
            return this;
        }

        public UserLikeQuestionBuilder idQuestion(int idQuestion) {
            this.idQuestion = idQuestion;
            return this;
        }

        public UserLikeQuestion build() {
            return new UserLikeQuestion(this);
        }
    }
}
