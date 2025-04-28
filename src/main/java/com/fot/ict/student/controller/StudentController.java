package com.fot.ict.student.controller;

import com.fot.ict.student.entity.Student;
import com.fot.ict.student.service.StudentService;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/student")
@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public @ResponseBody Iterable<Student> getAllStudent() {
        return studentService.findAllStudent();
    }

    @PostMapping
    public @ResponseBody Student addStudent(@RequestBody Student student) {
        Student newStudent = studentService.saveStudent(student);
        return studentService.saveStudent(newStudent);
    }

    @PutMapping
    public @ResponseBody Student updateStudent(@RequestParam int id, @RequestBody Student student) {
        Student oldStudent = studentService.findStudentById(id);

        if (oldStudent != null) {
            oldStudent.setName(student.getName());
            oldStudent.setAge(student.getAge());

            return studentService.saveStudent(student);
        }
        return null;
    }

    @DeleteMapping
    public @ResponseBody String deleteStudent(@RequestParam int id) {
        studentService.deleteStudentById(id);
        return "Student Deleted";
    }
}
