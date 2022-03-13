package com.utcn.sd.assignment.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Tag")
@Table(name = "tag")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class TagDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_tag")
    private int idTag;

    @Column(name = "name")
    private String name;

    public TagDto(int idTag, String name) {
        this.idTag = idTag;
        this.name = name;
    }

    public TagDto(String name) {
        this.name = name;
    }

    public TagDto() {
    }

    public TagDto(TagBuilder builder) {
        this.idTag = builder.idTag;
        this.name = builder.name;
    }

    public int getIdTag() {
        return idTag;
    }

    public void setIdTag(int idTag) {
        this.idTag = idTag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagDto tagDto = (TagDto) o;
        return idTag == tagDto.idTag && Objects.equals(name, tagDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTag, name);
    }

    @Override
    public String toString() {
        return "Tag{" +
                "idTag=" + idTag +
                ", name='" + name + '\'' +
                '}';
    }

    public static class TagBuilder {
        private int idTag;
        private String name;

        public TagBuilder idTag(int idTag) {
            this.idTag = idTag;
            return this;
        }

        public TagBuilder name(String name) {
            this.name = name;
            return this;
        }

        public TagDto build() {
            return new TagDto(this);
        }
    }
}
