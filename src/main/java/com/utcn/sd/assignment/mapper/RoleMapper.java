package com.utcn.sd.assignment.mapper;

import com.utcn.sd.assignment.dto.RoleDto;
import com.utcn.sd.assignment.model.Role;

public class RoleMapper {
    
    public static Role toEntity(RoleDto roleDto) {
        return new Role.RoleBuilder()
                .idRole(roleDto.getIdRole())
                .name(roleDto.getName())
                .build();
    }

    public static RoleDto toDto(Role role) {
        return new RoleDto.RoleBuilder()
                .idRole(role.getIdRole())
                .name(role.getName())
                .build();
    }
}
