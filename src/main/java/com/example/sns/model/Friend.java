package com.example.sns.model;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

import java.sql.Timestamp;

@Mapper
public interface FriendMapper {

    @Select("SELECT * FROM friends WHERE user_id = #{userId} AND friend_id = #{friendId}")
    Friend findByUserIdAndFriendId(int userId, int friendId);

    @Insert("INSERT INTO friends(user_id, friend_id, status, created_at) VALUES(#{userId}, #{friendId}, #{status}, #{createdAt})")
    void save(Friend friend);

    @Update("UPDATE friends SET status = #{status} WHERE user_id = #{userId} AND friend_id = #{friendId}")
    void update(Friend friend);

    @Delete("DELETE FROM friends WHERE user_id = #{userId} AND friend_id = #{friendId}")
    void delete(int userId, int friendId);
}

public class Friend {
    private int userId;
    private int friendId;
    private String status;
    private Timestamp createdAt;

    // Getters and Setters

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
