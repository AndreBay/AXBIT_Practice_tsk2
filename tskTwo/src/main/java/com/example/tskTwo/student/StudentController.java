package com.example.tskTwo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(Student student){
        studentService.addNewStudent(student);
    }
    @DeleteMapping
    public void deleteStudent(@PathVariable ("StudentId")Long studentId){
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "@{StudentId}")
    public void updateStudents(
        @PathVariable("StudentId") Long StudentId,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String email){
        studentService.updateStudents(StudentId, name, email);

    }
}
