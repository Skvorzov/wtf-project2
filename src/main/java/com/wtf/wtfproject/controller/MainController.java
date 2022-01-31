package com.wtf.wtfproject.controller;

import com.wtf.wtfproject.entity.Student;
import com.wtf.wtfproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String home(Model model) {
        return "use https://wtf-project2.herokuapp.com/ping to get pong";
    }

    @GetMapping("/ping")
    public String ping(){
        Student student = new Student();
        student.setName("Petro");
        userRepository.save(student);
        return "pong";
    }

    @GetMapping("/students")
    public List<Student> showAllStudents() {
        return userRepository.findAll();
    }
}