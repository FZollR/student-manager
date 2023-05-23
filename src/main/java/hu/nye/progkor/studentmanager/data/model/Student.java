package hu.nye.progkor.studentmanager.data.model;

import java.util.Objects;

/**
 * Model class for Student
 */

public class Student {
    private Long id;
    private String neptunCode;
    private String name;
    private String email;
    private String major;
    private Semester semester;

    public Student()
    {

    }

    public Student(Long id, String neptunCode, String name, String email, String major, Semester semester) {
        this.id = id;
        this.neptunCode = neptunCode;
        this.name = name;
        this.email = email;
        this.major = major;
        this.semester = semester;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNeptunCode() {
        return neptunCode;
    }

    public void setNeptunCode(String neptunCode) {
        this.neptunCode = neptunCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if(!Objects.equals(id, student.id))
        {
            return false;
        }
        if(!Objects.equals(neptunCode, student.neptunCode))
        {
            return false;
        }

        if(!Objects.equals(name, student.name))
        {
            return false;
        }
        if(!Objects.equals(email, student.email))
        {
            return false;
        }
        if(!Objects.equals(major, student.major))
        {
            return false;
        }
        if(!Objects.equals(semester, student.semester))
        {
            return false;
        }
        return semester == student.semester;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, neptunCode, name, email, major, semester);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", neptunCode='" + neptunCode + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", major='" + major + '\'' +
                ", major='" + semester + '\'' +
                '}';
    }
}
