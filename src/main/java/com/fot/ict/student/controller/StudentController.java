package com.fot.ict.student.controller;

import com.fot.ict.student.entity.Student;
import com.fot.ict.student.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Student> getAllStudent() {
        return studentService.findAllStudent();
    }


}
