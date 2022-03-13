package com.utcn.sd.assignment.model;

import java.util.Objects;

public class Role {
    private int idRole;
    private String name;

    public Role(int idRole, String name) {
        this.idRole = idRole;
        this.name = name;
    }

    public Role(String name) {
        this.name = name;
    }

    public Role() {
    }

    public Role(RoleBuilder builder) {
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
        Role role = (Role) o;
        return idRole == role.idRole && Objects.equals(name, role.name);
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

        public Role build() {
            return new Role(this);
        }
    }
}
