package com.example.sns.repository;

import com.example.sns.model.Message;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MessageRepository {

    @Select("SELECT * FROM messages WHERE id = #{id}")
    Message findById(int id);

    @Select("SELECT * FROM messages")
    List<Message> findAll();

    @Insert("INSERT INTO messages(sender_id, receiver_id, content, created_at) VALUES(#{senderId}, #{receiverId}, #{content}, #{createdAt})")
    void save(Message message);

    @Update("UPDATE messages SET content = #{content} WHERE id = #{id}")
    void update(Message message);

    @Delete("DELETE FROM messages WHERE id = #{id}")
    void delete(int id);
}
