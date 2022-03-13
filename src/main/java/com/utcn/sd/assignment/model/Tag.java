package com.utcn.sd.assignment.model;

import java.util.Objects;

public class Tag {
    private int idTag;
    private String name;

    public Tag(int idTag, String name) {
        this.idTag = idTag;
        this.name = name;
    }

    public Tag(String name) {
        this.name = name;
    }

    public Tag() {
    }

    public Tag(TagBuilder builder) {
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
        Tag tag = (Tag) o;
        return idTag == tag.idTag && Objects.equals(name, tag.name);
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

        public Tag build() {
            return new Tag(this);
        }
    }
}
