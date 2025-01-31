package com.logrex.student.controller;


import com.logrex.student.Response.StudentDTO;
import com.logrex.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student/api")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/{id}")
    public StudentDTO getStudents(@PathVariable long id) {

        return  studentService.getById(id);
    }


}
