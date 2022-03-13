package com.utcn.sd.assignment.mapper;

import com.utcn.sd.assignment.dto.TagDto;
import com.utcn.sd.assignment.model.Tag;

public class TagMapper {

    public static Tag toEntity(TagDto tagDto) {
        return new Tag.TagBuilder()
                .idTag(tagDto.getIdTag())
                .name(tagDto.getName())
                .build();
    }

    public static TagDto toDto(Tag tag) {
        return new TagDto.TagBuilder()
                .idTag(tag.getIdTag())
                .name(tag.getName())
                .build();
    }
}
