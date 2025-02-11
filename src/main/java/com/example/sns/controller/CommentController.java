package com.example.sns.controller;

import com.example.sns.model.Comment;
import com.example.sns.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts/{postId}/comments")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @PostMapping
    public String addComment(@PathVariable int postId, @RequestBody Comment comment) {
        comment.setPostId(postId);
        commentRepository.save(comment);
        return "Comment added successfully!";
    }

    @GetMapping
    public List<Comment> getCommentsByPostId(@PathVariable int postId) {
        return commentRepository.findByPostId(postId);
    }
}
