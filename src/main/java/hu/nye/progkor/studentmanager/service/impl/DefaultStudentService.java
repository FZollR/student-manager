package hu.nye.progkor.studentmanager.service.impl;

import hu.nye.progkor.studentmanager.data.model.Student;
import hu.nye.progkor.studentmanager.data.repository.Repository;
import hu.nye.progkor.studentmanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * This is a service class for student-manager.
 */
@Service
public class DefaultStudentService implements StudentService {

    private final Repository<Student, Long> studentRepository;

    @Autowired
    public DefaultStudentService(Repository<Student, Long> studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> retrieveStudentById(Long id) {
        return studentRepository.getById(id);
    }

    @Override
    public List<Student> retrieveAllStudents() {
        return studentRepository.getAll();
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.update(student);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}
