package com.utcn.sd.assignment.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "QuestionTag")
@Table(name = "question_tag")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class QuestionTagDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_question_tag")
    private int idQuestionTag;

    @Column(name = "id_question")
    private int idQuestion;

    @Column(name = "id_tag")
    private int idTag;

    public QuestionTagDto(int idQuestionTag, int idQuestion, int idTag) {
        this.idQuestionTag = idQuestionTag;
        this.idQuestion = idQuestion;
        this.idTag = idTag;
    }

    public QuestionTagDto(int idQuestion, int idTag) {
        this.idQuestion = idQuestion;
        this.idTag = idTag;
    }

    public QuestionTagDto() {
    }

    public QuestionTagDto(QuestionTagBuilder builder) {
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
        QuestionTagDto that = (QuestionTagDto) o;
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

        public QuestionTagDto build() {
            return new QuestionTagDto(this);
        }
    }
}
