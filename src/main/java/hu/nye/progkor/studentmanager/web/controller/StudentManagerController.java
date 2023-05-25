package hu.nye.progkor.studentmanager.web.controller;

import hu.nye.progkor.studentmanager.data.model.Student;
import hu.nye.progkor.studentmanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

/**
 * controller for Crud operations.
 */
@Controller
@RequestMapping("/student-manager")
public class StudentManagerController {

    private final StudentService studentService;

    @Autowired
    public StudentManagerController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Shows the student editor screen.
     *
     * @param model the model object to store attributes
     * @param id the id of the student to retrieve
     * @return the name of the edit view to render
     */
    @GetMapping("/{id}")
    public String getStudentById(Model model, @PathVariable Long id) {
        Optional<Student> optionalStudent = studentService.retrieveStudentById(id);
        return optionalStudent.map(student -> {
            model.addAttribute("student", student);
            return "student-manager/edit";
        }).orElseGet(() -> {
            model.addAttribute("requestUri", "student-manager/" + id);
            return "student-manager/notFound";
        });
    }

    /**
     * Shows the student list screen.
     *
     * @param model the model object to store attributes
     * @return the name of the student list view to render
     */
    @GetMapping()
    public String getAllStudents(Model model) {
        List<Student> allStudents = studentService.retrieveAllStudents();
        model.addAttribute("students", allStudents);
        return "student-manager/list";
    }

    /**
     * Shows the student creation screen.
     *
     * @param model the model object to store attributes
     * @return the name of the student creation view to render
     */
    @GetMapping("/create")
    public String createStudent(Model model) {
        return "student-manager/create";
    }

    /**
     * Creates a new student.
     *
     * @param model the model object to store attributes
     * @param student the given student object to create
     * @return the name of the edit view to render
     */
    @PostMapping("/create")
    public String createStudent(Model model, Student student) {
        Student newStudent = studentService.createStudent(student);
        model.addAttribute("student", newStudent);
        return "student-manager/edit";
    }

    /**
     * Updates an existing student, and then navigates back to the editor screen.
     *
     * @param model the model object to store attributes
     * @param student the given student object to update
     * @return the name of the edit view to render
     */
    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateStudent(Model model, Student student) {
        Student updatedStudent = studentService.updateStudent(student);
        model.addAttribute("student", updatedStudent);
        return "student-manager/edit";
    }

    /**
     * Updates an existing student, and then navigates back to the editor screen.

     * @param model the model object to store attributes
     * @param id of the student object to delete
     * @return the name of the student list view to render
     */
    @GetMapping("/{id}/delete")
    public String deleteStudentById(Model model, @PathVariable Long id) {
        studentService.deleteStudentById(id);
        List<Student> allStudent = studentService.retrieveAllStudents();
        model.addAttribute("students", allStudent);
        return "student-manager/list";
    }

}
