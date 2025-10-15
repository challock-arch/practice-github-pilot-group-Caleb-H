package com.example.practice_github_pilot.Controllers;

import com.example.practice_github_pilot.Models.Teacher;
import com.example.practice_github_pilot.Repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping("")
    public List <Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable Integer id) {
        return teacherRepository.findById(id).orElse(null);
    }

    @PostMapping("")
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @PutMapping("/{id}")
    public Teacher updateTeacher(@PathVariable Integer id, @RequestBody Teacher teacherDetails) {
        Teacher teacher = teacherRepository.findById(id).orElse(null);
        if (teacher != null) {
            teacher.setName(teacherDetails.getName());
            teacher.setSubject(teacherDetails.getSubject());
            return teacherRepository.save(teacher);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Integer id) {
        teacherRepository.deleteById(id);
    }

}
