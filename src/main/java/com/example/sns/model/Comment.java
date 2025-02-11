package com.example.sns.model;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

import java.sql.Timestamp;

@Mapper
public interface CommentMapper {

    @Select("SELECT * FROM comments WHERE id = #{id}")
    Comment findById(int id);

    @Select("SELECT * FROM comments WHERE post_id = #{postId}")
    List<Comment> findByPostId(int postId);

    @Insert("INSERT INTO comments(post_id, user_id, content, created_at) VALUES(#{postId}, #{userId}, #{content}, #{createdAt})")
    void save(Comment comment);

    @Update("UPDATE comments SET content = #{content} WHERE id = #{id}")
    void update(Comment comment);

    @Delete("DELETE FROM comments WHERE id = #{id}")
    void delete(int id);
}

public class Comment {
    private int id;
    private int postId;
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

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
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
