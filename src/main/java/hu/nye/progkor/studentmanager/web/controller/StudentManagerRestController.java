package hu.nye.progkor.studentmanager.web.controller;

import hu.nye.progkor.studentmanager.data.model.Student;
import hu.nye.progkor.studentmanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentService.retrieveStudentById(id);
        return student.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
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

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id)
    {
       studentService.deleteStudentById(id);
    }

}
