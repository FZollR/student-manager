package hu.nye.progkor.studentmanager.web.controller;

import hu.nye.progkor.studentmanager.data.model.Student;
import hu.nye.progkor.studentmanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

/**
 * controller for Crud operations
 */
@Controller
@RequestMapping("/student-manager")
public class StudentManagerController {

    private final StudentService studentService;

    @Autowired
    public StudentManagerController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public String getStudentById(Model model, @PathVariable Long id)
    {
        Optional<Student> optionalStudent = studentService.retrieveStudentById(id);
        return optionalStudent.map(student -> {
            model.addAttribute("student", student);
            return "student-manager/edit";
        }).orElseGet(() -> {
            model.addAttribute("requestUri", "student-manager/" + id);
            return "student-manager/notFound";
        });
    }

    @GetMapping()
    public String getAllStudents(Model model)
    {
        List<Student> allStudents = studentService.retrieveAllStudents();
        model.addAttribute("students", allStudents);
        return "student-manager/list";
    }

    @GetMapping("/create")
    public String createStudent(Model model)
    {
        return "student-manager/create";
    }
    @PostMapping("/create")
    public String createStudent(Model model, Student student)
    {
        Student newStudent = studentService.createStudent(student);
        model.addAttribute("student", newStudent);
        return "student-manager/edit";
    }

    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateStudent(Model model, Student student)
    {
        Student updatedStudent= studentService.updateStudent(student);
        model.addAttribute("student", updatedStudent);
        return "student-manager/edit";
    }

    @GetMapping("/{id}/delete")
    public String deleteStudentById(Model model, @PathVariable Long id)
    {
        studentService.deleteStudentById(id);
        List<Student> allStudent = studentService.retrieveAllStudents();
        model.addAttribute("students", allStudent);
        return "student-manager/list";
    }

}
