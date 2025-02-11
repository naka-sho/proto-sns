package com.example.sns.repository;

import com.example.sns.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserRepository {

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
