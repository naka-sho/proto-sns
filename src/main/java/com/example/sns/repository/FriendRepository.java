package com.example.sns.repository;

import com.example.sns.model.Friend;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FriendRepository {

    @Select("SELECT * FROM friends WHERE user_id = #{userId} AND friend_id = #{friendId}")
    Friend findByUserIdAndFriendId(int userId, int friendId);

    @Select("SELECT * FROM friends WHERE user_id = #{userId}")
    List<Friend> findByUserId(int userId);

    @Insert("INSERT INTO friends(user_id, friend_id, status, created_at) VALUES(#{userId}, #{friendId}, #{status}, #{createdAt})")
    void save(Friend friend);

    @Update("UPDATE friends SET status = #{status} WHERE user_id = #{userId} AND friend_id = #{friendId}")
    void update(Friend friend);

    @Delete("DELETE FROM friends WHERE user_id = #{userId} AND friend_id = #{friendId}")
    void delete(int userId, int friendId);
}
