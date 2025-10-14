package Controllers;


import Models.Student;
import Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping ("/students")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();

    }

    @GetMapping ("/students/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return studentRepository.findById(id).orElse(null);

    }

    @PostMapping ("/students")
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);

    }

    @PutMapping ("/students/{id}")
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

    @DeleteMapping ("/students/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentRepository.deleteById(id);

    }

}
