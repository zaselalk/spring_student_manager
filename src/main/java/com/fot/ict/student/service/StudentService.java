package com.fot.ict.student.service;

import com.fot.ict.student.entity.Student;
import com.fot.ict.student.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<Student> findAllStudent() {
        return repo.findAll();
    }

    public Student findStudentById(int id) {
        return repo.findById(id).get();
    }

    public Student saveStudent(Student student) {
        return repo.save(student);
    }

    public void deleteStudentById(int id) {
        repo.deleteById(id);
    }

}
