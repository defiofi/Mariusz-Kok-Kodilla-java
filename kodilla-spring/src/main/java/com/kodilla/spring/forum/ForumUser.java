package com.kodilla.spring.forum;

import org.springframework.stereotype.Component;

@Component
public class ForumUser {
    private String username;
    ForumUser(){
        this.username = "John Smith";
    }

    public String getUsername() {
        return username;
    }
}
