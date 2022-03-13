package com.utcn.sd.assignment.service;

import com.utcn.sd.assignment.model.Tag;

import java.util.List;

public interface TagService {
    Tag getTagById(int id);

    Tag createTag(Tag tag);

    List<Tag> getAllTags();
}
