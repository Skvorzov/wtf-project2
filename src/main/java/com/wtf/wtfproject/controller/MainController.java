package com.wtf.wtfproject.controller;

import com.wtf.wtfproject.entity.Student;
import com.wtf.wtfproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Главная страница");
        return "home use https://wtf-project.herokuapp.com/ping to get pong";
    }

    @GetMapping("/ping")
    public String ping(){
        Student student = new Student();
        student.setName("Petro");
        userRepository.save(student);
        return "pong";
    }
}