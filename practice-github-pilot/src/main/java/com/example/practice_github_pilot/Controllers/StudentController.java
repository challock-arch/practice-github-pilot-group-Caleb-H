package com.example.practice_github_pilot.Controllers;


import com.example.practice_github_pilot.Models.Student;
import com.example.practice_github_pilot.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping ("")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();

    }

    @GetMapping ("/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return studentRepository.findById(id).orElse(null);

    }

    @PostMapping ("")
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);

    }

    @PutMapping ("/{id}")
    public Student updateStudent(@PathVariable Integer id, @RequestBody Student studentDetails) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            student.setName(studentDetails.getName());
            student.setAge(studentDetails.getAge());
            return studentRepository.save(student);
        } else {
            return null;

        }

    }

    @DeleteMapping ("/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentRepository.deleteById(id);

    }

}
