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

    public Student(Long id, String neptunCode, String name, String email, String major) {
        this.id = id;
        this.neptunCode = neptunCode;
        this.name = name;
        this.email = email;
        this.major = major;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return  Objects.equals(id, student.id) &&
                Objects.equals(neptunCode, student.neptunCode) &&
                Objects.equals(name, student.name) &&
                Objects.equals(email, student.email) &&
                Objects.equals(major, student.major);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, neptunCode, name, email, major);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", neptunCode='" + neptunCode + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", major='" + major + '\'' +
                '}';
    }
}
