package com.utcn.sd.assignment.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "User")
@Table(name = "user")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class UserDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user")
    private int idUser;

    @Column(name = "id_role")
    private int idRole;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "is_banned")
    private Boolean isBanned;

    @Column(name = "score")
    private int score;

    public UserDto(int idUser, int idRole, String username, String password, String email, Boolean isBanned, int score) {
        this.idUser = idUser;
        this.idRole = idRole;
        this.username = username;
        this.password = password;
        this.email = email;
        this.isBanned = isBanned;
        this.score = score;
    }

    public UserDto(int idRole, String username, String password, String email, Boolean isBanned, int score) {
        this.idRole = idRole;
        this.username = username;
        this.password = password;
        this.email = email;
        this.isBanned = isBanned;
        this.score = score;
    }

    public UserDto() {
    }

    public UserDto(UserBuilder builder) {
        this.idUser = builder.idUser;
        this.idRole = builder.idRole;
        this.username = builder.username;
        this.password = builder.password;
        this.email = builder.email;
        this.isBanned = builder.isBanned;
        this.score = builder.score;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getBanned() {
        return isBanned;
    }

    public void setBanned(Boolean banned) {
        isBanned = banned;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return idUser == userDto.idUser && idRole == userDto.idRole && score == userDto.score && Objects.equals(username, userDto.username) && Objects.equals(password, userDto.password) && Objects.equals(email, userDto.email) && Objects.equals(isBanned, userDto.isBanned);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, idRole, username, password, email, isBanned, score);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "idUser=" + idUser +
                ", idRole=" + idRole +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", isBanned=" + isBanned +
                ", score=" + score +
                '}';
    }

    public static class UserBuilder {
        private int idUser;
        private int idRole;
        private String username;
        private String password;
        private String email;
        private Boolean isBanned;
        private int score;

        public UserBuilder idUser(int idUser) {
            this.idUser = idUser;
            return this;
        }

        public UserBuilder idRole(int idRole) {
            this.idRole = idRole;
            return this;
        }

        public UserBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder isBanned(Boolean isBanned) {
            this.isBanned = isBanned;
            return this;
        }

        public UserBuilder score(int score) {
            this.score = score;
            return this;
        }

        public UserDto build() {
            return new UserDto(this);
        }
    }
}
