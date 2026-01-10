package com.krakedev.inventario.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.inventario.entity.message;

//@RestController
//@RequestMapping("/api/messages")
public class messageController {
    
    private List<message> messages = new ArrayList<>();
    
    private messageController() {
        messages.add(new message(1, "KrakeDev Programming School"));
        messages.add(new message(2, "Spring Boot"));
    }

    //@GetMapping
    public List<message> listMessages() {
        return messages;
    }

    //@GetMapping("/{id}")
    public message getMessageById(@PathVariable int id) {
        java.util.Optional<message> message = messages.stream().filter(m -> m.getId() == id).findFirst();
        return message.orElse(null);
    }

    //@PostMapping
    public message createMessage(@RequestBody message newMessage) {
        messages.add(newMessage);
        return newMessage;
    }

    //@DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable int id) {
        messages.removeIf(m -> m.getId() == id);
    }
}
