package hu.nye.progkor.studentmanager.data.repository.impl;

import hu.nye.progkor.studentmanager.data.model.Student;
import hu.nye.progkor.studentmanager.data.repository.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation for Crud operations
 */
@org.springframework.stereotype.Repository
public class InMemoryStudentRepository implements Repository<Student, Long> {

    private static final Map<Long, Student> STORAGE = new HashMap<>();
    @Override
    public Student save(Student student) {
        Long id = STORAGE.size() + 1L;
        student.setId(id);
        STORAGE.put(id, student);
        return STORAGE.get(id);
    }

    @Override
    public Student getById(Long id) {
        return STORAGE.get(id);
    }

    @Override
    public List<Student> getAll() {
        return STORAGE.values().stream().toList();
    }

    @Override
    public Student update(Student student) {
        Long id = student.getId();
        STORAGE.put(id, student);
        return STORAGE.get(id);
    }

    @Override
    public void deleteById(Long id) {
     STORAGE.remove(id);
    }
}
