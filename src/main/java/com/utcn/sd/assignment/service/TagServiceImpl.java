package com.utcn.sd.assignment.service;

import com.utcn.sd.assignment.mapper.TagMapper;
import com.utcn.sd.assignment.model.Tag;
import com.utcn.sd.assignment.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public Tag getTagById(int id) {
        return TagMapper.toEntity(tagRepository.getById(id));
    }

    @Override
    public Tag createTag(Tag tag) {
        return TagMapper.toEntity(tagRepository.save(TagMapper.toDto(tag)));
    }

    @Override
    public List<Tag> getAllTags() {
        return tagRepository.findAll()
                .stream()
                .map(TagMapper::toEntity)
                .collect(Collectors.toList());
    }
}
