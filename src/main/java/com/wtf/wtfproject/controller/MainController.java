package com.wtf.wtfproject.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Главная страница");
        return "home        use https://wtf-project.herokuapp.com/ping to get pong";
    }

    @GetMapping("/ping")
    public String ping(){
        return "pong";
    }
}