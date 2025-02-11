package com.example.sns.controller;

import com.example.sns.model.Post;
import com.example.sns.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @PostMapping
    public String createPost(@RequestBody Post post) {
        postRepository.save(post);
        return "Post created successfully!";
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable int id) {
        return postRepository.findById(id);
    }

    @PutMapping("/{id}")
    public String updatePost(@PathVariable int id, @RequestBody Post post) {
        Post existingPost = postRepository.findById(id);
        if (existingPost != null) {
            existingPost.setContent(post.getContent());
            postRepository.update(existingPost);
            return "Post updated successfully!";
        } else {
            return "Post not found!";
        }
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable int id) {
        Post existingPost = postRepository.findById(id);
        if (existingPost != null) {
            postRepository.delete(id);
            return "Post deleted successfully!";
        } else {
            return "Post not found!";
        }
    }
}
