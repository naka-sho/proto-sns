package com.example.sns.model;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

import java.sql.Timestamp;

@Mapper
public interface PostMapper {

    @Select("SELECT * FROM posts WHERE id = #{id}")
    Post findById(int id);

    @Insert("INSERT INTO posts(user_id, content, created_at) VALUES(#{userId}, #{content}, #{createdAt})")
    void save(Post post);

    @Update("UPDATE posts SET content = #{content} WHERE id = #{id}")
    void update(Post post);

    @Delete("DELETE FROM posts WHERE id = #{id}")
    void delete(int id);
}

public class Post {
    private int id;
    private int userId;
    private String content;
    private Timestamp createdAt;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
