package com.example.sns.repository;

import com.example.sns.model.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentRepository {

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
