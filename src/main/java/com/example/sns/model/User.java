package com.example.sns.model;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

import java.sql.Timestamp;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM users WHERE id = #{id}")
    User findById(int id);

    @Select("SELECT * FROM users WHERE username = #{username} AND password = #{password}")
    User findByUsernameAndPassword(String username, String password);

    @Insert("INSERT INTO users(username, email, password, profile_picture, created_at) VALUES(#{username}, #{email}, #{password}, #{profilePicture}, #{createdAt})")
    void save(User user);

    @Update("UPDATE users SET username = #{username}, email = #{email}, password = #{password}, profile_picture = #{profilePicture} WHERE id = #{id}")
    void update(User user);

    @Delete("DELETE FROM users WHERE id = #{id}")
    void delete(int id);
}

public class User {
    private int id;
    private String username;
    private String email;
    private String password;
    private String profilePicture;
    private Timestamp createdAt;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
