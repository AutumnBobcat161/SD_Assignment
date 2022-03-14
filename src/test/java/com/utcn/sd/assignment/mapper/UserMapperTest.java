package com.utcn.sd.assignment.mapper;

import com.utcn.sd.assignment.util.MapperUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserMapperTest {
    @Test
    void whenMapToDto_thenGetExpected() {
        assertEquals(MapperUtil.userDtoExpected, UserMapper.toDto(MapperUtil.user));
    }

    @Test
    void whenMapToEntity_thenGetExpected() {
        assertEquals(MapperUtil.userExpected, UserMapper.toEntity(MapperUtil.userDto));
    }
}
