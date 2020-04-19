package com.haotian.consumer.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginC {
    @GetMapping("/index.html")
    public String login(HttpSession httpSession){
        httpSession.setAttribute("user","user");

        return "index.html";
    }
}
