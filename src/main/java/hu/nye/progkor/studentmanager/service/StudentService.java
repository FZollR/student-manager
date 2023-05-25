package hu.nye.progkor.studentmanager.service;

import hu.nye.progkor.studentmanager.data.model.Student;

import java.util.List;
import java.util.Optional;

/**
 * Interface for the DefaultStudentService class.
 */
public interface StudentService {

         Student createStudent(Student student);

         Optional<Student> retrieveStudentById(Long id);

         List<Student> retrieveAllStudents();

        Student updateStudent(Student student);

        void deleteStudentById(Long id);

    }

