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
        return "use https://wtf-project2.herokuapp.com/ping to add Petro to the table " + "_____" + "use https://wtf-project2.herokuapp.com/students to show all students " + "_____" + " use https://wtf-project2.herokuapp.com//create-random-student to create random student";
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

    @GetMapping("/create-random-student")
    public Student createRandomStudent(){
        String[] name = {"Dima", "Evgen", "Sergiy", "Ivan", "Vlad", "Nikita", "Egor", "Roma", "Gleb"};
        int i = (int) (Math.random()*9);
        Student student = new Student();
        student.setName(name[i]);
        return userRepository.save(student);
    }
}