
package com.example.studentmanagement.service;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.repository.StudentRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    // Constructor injection
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // CREATE
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // READ ALL
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // READ ONE
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND, "Student not found"
                        ));
    }

    // UPDATE
    public Student updateStudent(Long id, Student student) {

        Student existingStudent = getStudentById(id);

        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setAge(student.getAge());

        return studentRepository.save(existingStudent);
    }

    // PATCH - PARTIAL UPDATE
    public Student patchStudent(Long id, Student student) {

        Student existingStudent = getStudentById(id);

        if (student.getName() != null) {
            existingStudent.setName(student.getName());
        }

        if (student.getEmail() != null) {
            existingStudent.setEmail(student.getEmail());
        }

        if (student.getAge() != null) {
            existingStudent.setAge(student.getAge());
        }

        return studentRepository.save(existingStudent);
    }


    // DELETE
    public void deleteStudent(Long id) {
        Student existingStudent = getStudentById(id);
        studentRepository.delete(existingStudent);
    }
}
