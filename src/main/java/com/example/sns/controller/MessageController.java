package com.example.sns.controller;

import com.example.sns.model.Message;
import com.example.sns.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @PostMapping
    public String sendMessage(@RequestBody Message message) {
        messageRepository.save(message);
        return "Message sent successfully!";
    }

    @GetMapping
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }
}
