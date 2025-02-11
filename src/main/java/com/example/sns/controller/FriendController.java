package com.example.sns.controller;

import com.example.sns.model.Friend;
import com.example.sns.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/friends")
public class FriendController {

    @Autowired
    private FriendRepository friendRepository;

    @PostMapping("/request")
    public String sendFriendRequest(@RequestBody Friend friend) {
        friend.setStatus("pending");
        friendRepository.save(friend);
        return "Friend request sent successfully!";
    }

    @PostMapping("/accept")
    public String acceptFriendRequest(@RequestBody Friend friend) {
        Friend existingFriend = friendRepository.findByUserIdAndFriendId(friend.getUserId(), friend.getFriendId());
        if (existingFriend != null && "pending".equals(existingFriend.getStatus())) {
            existingFriend.setStatus("accepted");
            friendRepository.update(existingFriend);
            return "Friend request accepted successfully!";
        } else {
            return "Friend request not found or already accepted!";
        }
    }

    @GetMapping
    public List<Friend> getFriendList(@RequestParam int userId) {
        return friendRepository.findByUserId(userId);
    }
}
