package hu.nye.progkor.studentmanager.service.impl;

import hu.nye.progkor.studentmanager.data.model.Semester;
import hu.nye.progkor.studentmanager.data.model.Student;
import hu.nye.progkor.studentmanager.data.repository.Repository;
import hu.nye.progkor.studentmanager.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class DefaultStudentServiceTest {
   private static final Long STUDENT_ID = 1L;
    private static final Student STUDENT = new Student(1L, "VUR1JV",
            "Fábri Zoltán", "darkfabri@gmail.hu", "Programtervező info", Semester.FIRST);

    @Mock
    private Repository<Student, Long> studentRepository;

    private StudentService underTest;

    @BeforeEach
    void setup()
    {
        MockitoAnnotations.openMocks(this);
        underTest = new DefaultStudentService(studentRepository);
    }
    @Test
    void createStudentShouldDelegateToTheRepositoryThenReturnTheStudentWhichIsSaved() {
        //Given
        given(studentRepository.save(STUDENT)).willReturn(STUDENT);

        //When
        final Student actual = underTest.createStudent(STUDENT);

        //Then
        assertThat(actual,equalTo(STUDENT));
        verify(studentRepository).save(STUDENT);
        verifyNoMoreInteractions(studentRepository);
    }

    @Test
    void retrieveStudentById() {
    }

    @Test
    void retrieveAllStudents() {
    }

    @Test
    void updateStudent() {
    }

    @Test
    void deleteStudentById() {
    }
}