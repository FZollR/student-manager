package hu.nye.progkor.studentmanager.service;

import hu.nye.progkor.studentmanager.data.model.Student;

import java.util.List;

public interface StudentService {

         Student createStudent(Student student);

         Student retrieveStudentById(Long id);

         List<Student> retrieveAllStudents();

        Student updateStudent(Student student);

        void deleteStudentById(Long id);

    }

