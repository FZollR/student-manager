package hu.nye.progkor.studentmanager.web.controller;

import hu.nye.progkor.studentmanager.data.model.Student;
import hu.nye.progkor.studentmanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Rest controller for Crud operations.
 */
@RestController
@RequestMapping("/api/v1/student")
public class StudentManagerRestController {

    private final StudentService studentService;

    @Autowired
    public StudentManagerRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Returns a student with the given id.
     *
     * @param id the id of the students to retrieve
     * @return the student object
     */
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentService.retrieveStudentById(id);
        return student.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Returns the list of all the students in the catalog.
     *
     * @return the list of students
     */
    @GetMapping()
    public List<Student> getAllStudents() {
        return studentService.retrieveAllStudents();
    }

    /**
     * Creates a new student and returns it.
     *
     * @param student is the student object to create
     * @return the created student object
     */
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    /**
     * Updates an already existing student and returns it.
     *
     * @param student is the student object to update
     * @return the updated student object
     */
    @PutMapping
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    /**
     * Deletes an already existing student by its id.
     *
     * @param id is the id of the student object to delete
     *
     */
    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id) {
       studentService.deleteStudentById(id);
    }

}
