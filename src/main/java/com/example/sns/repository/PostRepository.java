package com.example.sns.repository;

import com.example.sns.model.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostRepository {

    @Select("SELECT * FROM posts WHERE id = #{id}")
    Post findById(int id);

    @Select("SELECT * FROM posts")
    List<Post> findAll();

    @Insert("INSERT INTO posts(user_id, content, created_at) VALUES(#{userId}, #{content}, #{createdAt})")
    void save(Post post);

    @Update("UPDATE posts SET content = #{content} WHERE id = #{id}")
    void update(Post post);

    @Delete("DELETE FROM posts WHERE id = #{id}")
    void delete(int id);
}
