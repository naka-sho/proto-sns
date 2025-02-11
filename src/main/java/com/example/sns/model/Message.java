package com.example.sns.model;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.sql.Timestamp;

@Mapper
public interface MessageMapper {

    @Select("SELECT * FROM messages WHERE id = #{id}")
    Message findById(int id);

    @Insert("INSERT INTO messages(sender_id, receiver_id, content, created_at) VALUES(#{senderId}, #{receiverId}, #{content}, #{createdAt})")
    void save(Message message);
}

public class Message {
    private int id;
    private int senderId;
    private int receiverId;
    private String content;
    private Timestamp createdAt;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
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
