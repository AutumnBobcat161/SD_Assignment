package com.utcn.sd.assignment.model;

import java.util.List;
import java.util.Objects;

public class SearchRequest {
    public String title;
    public List<Tag> tags;

    public SearchRequest() {
    }

    public SearchRequest(String title, List<Tag> tags) {
        this.title = title;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchRequest that = (SearchRequest) o;
        return Objects.equals(title, that.title) && Objects.equals(tags, that.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, tags);
    }

    @Override
    public String toString() {
        return "SearchRequest{" +
                "title='" + title + '\'' +
                ", tags=" + tags +
                '}';
    }
}
