package com.haotian.consumer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginC {
    @GetMapping("/")
    public String login(){
        return "index.html";
    }
}
