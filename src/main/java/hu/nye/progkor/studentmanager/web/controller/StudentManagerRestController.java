package hu.nye.progkor.studentmanager.web.controller;

import hu.nye.progkor.studentmanager.data.model.Student;
import hu.nye.progkor.studentmanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Rest controller for Crud operations
 */
@RestController
@RequestMapping("/api/v1/student")
public class StudentManagerRestController {

    private final StudentService studentService;

    @Autowired
    public StudentManagerRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id)
    {
        return studentService.retrieveStudentById(id);
    }

    @GetMapping()
    public List<Student> getAllStudents()
    {
        return studentService.retrieveAllStudents();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student)
    {
        return studentService.createStudent(student);
    }

    @PutMapping
    public Student updateStudent(@RequestBody Student student)
    {
        return studentService.updateStudent(student);
    }
    @DeleteMapping
    public void deleteStudentById(@PathVariable Long id)
    {
       studentService.deleteStudentById(id);
    }

}
