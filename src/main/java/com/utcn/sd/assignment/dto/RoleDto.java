package com.utcn.sd.assignment.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Role")
@Table(name = "role")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class RoleDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_role")
    private int idRole;

    @Column(name = "name")
    private String name;

    public RoleDto(int idRole, String name) {
        this.idRole = idRole;
        this.name = name;
    }

    public RoleDto(String name) {
        this.name = name;
    }

    public RoleDto() {
    }

    public RoleDto(RoleBuilder builder) {
        this.idRole = builder.idRole;
        this.name = builder.name;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
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
        RoleDto roleDto = (RoleDto) o;
        return idRole == roleDto.idRole && Objects.equals(name, roleDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRole, name);
    }

    @Override
    public String toString() {
        return "Role{" +
                "idRole=" + idRole +
                ", name='" + name + '\'' +
                '}';
    }

    public static class RoleBuilder {
        private int idRole;
        private String name;

        public RoleBuilder idRole(int idRole) {
            this.idRole = idRole;
            return this;
        }

        public RoleBuilder name(String name) {
            this.name = name;
            return this;
        }

        public RoleDto build() {
            return new RoleDto(this);
        }
    }
}
