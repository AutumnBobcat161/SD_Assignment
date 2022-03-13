package com.utcn.sd.assignment.model;

import java.util.Objects;

public class UserLikeAnswer {
    private int idUserLike;
    private int idUser;
    private int type;
    private int idAnswer;

    public UserLikeAnswer(int idUserLike, int idUser, int type, int idAnswer) {
        this.idUserLike = idUserLike;
        this.idUser = idUser;
        this.type = type;
        this.idAnswer = idAnswer;
    }

    public UserLikeAnswer(int idUser, int type, int idAnswer) {
        this.idUser = idUser;
        this.type = type;
        this.idAnswer = idAnswer;
    }

    public UserLikeAnswer() {
    }

    public UserLikeAnswer(UserLikeAnswerBuilder builder) {
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
        UserLikeAnswer that = (UserLikeAnswer) o;
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

        public UserLikeAnswer build() {
            return new UserLikeAnswer(this);
        }
    }
}
