package hu.nye.progkor.studentmanager.service.impl;

import hu.nye.progkor.studentmanager.data.model.Semester;
import hu.nye.progkor.studentmanager.data.model.Student;
import hu.nye.progkor.studentmanager.data.repository.Repository;
import hu.nye.progkor.studentmanager.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;
import java.util.Optional;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
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
    void retrieveStudentByIdShouldDelegateToTheRepoAndReturnFoundStudent() {
        //Given
        given(studentRepository.getById(STUDENT_ID)).willReturn(Optional.of(STUDENT));

        //When
        final Optional<Student> actual = underTest.retrieveStudentById((STUDENT_ID));

        //Then
        assertThat(actual,equalTo(STUDENT));
        verify(studentRepository).getById(STUDENT_ID);
        verifyNoMoreInteractions(studentRepository);
    }

    @Test
    void retrieveStudentByIdShouldDelegateToTheRepoAndReturnTheStudentFound() {
        //Given
        given(studentRepository.getAll()).willReturn(List.of(STUDENT));

        //When
        final List<Student> actual = underTest.retrieveAllStudents();

        //Then
        assertThat(actual,equalTo(List.of(STUDENT)));
        verify(studentRepository).getAll();
        verifyNoMoreInteractions(studentRepository);
    }

    @Test
    void updateStudent() {
    }

    @Test
    void deleteStudentById() {
    }
}