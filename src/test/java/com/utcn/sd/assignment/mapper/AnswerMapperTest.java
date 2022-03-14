package com.utcn.sd.assignment.mapper;

import com.utcn.sd.assignment.util.MapperUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnswerMapperTest {

    @Test
    void whenMapToDto_thenGetExpected() {
        assertEquals(MapperUtil.answerDtoExpected, AnswerMapper.toDto(MapperUtil.answer));
    }

    @Test
    void whenMapToEntity_thenGetExpected() {
        assertEquals(MapperUtil.answerExpected, AnswerMapper.toEntity(MapperUtil.answerDTO));
    }
}
