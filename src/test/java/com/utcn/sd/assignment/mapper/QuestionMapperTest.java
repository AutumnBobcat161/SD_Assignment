package com.utcn.sd.assignment.mapper;

import com.utcn.sd.assignment.util.MapperUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionMapperTest {

    @Test
    void whenMapToDto_thenGetExpected() {
        assertEquals(MapperUtil.questionDtoExpected, QuestionMapper.toDto(MapperUtil.question));
    }

    @Test
    void whenMapToEntity_thenGetExpected() {
        assertEquals(MapperUtil.questionExpected, QuestionMapper.toEntity(MapperUtil.questionDto));
    }
}
