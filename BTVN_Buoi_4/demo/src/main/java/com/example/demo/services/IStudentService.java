package com.example.demo.services;

import com.example.demo.models.dtos.requests.StudentCreationRequest;
import com.example.demo.models.dtos.responses.StudentResponse;
import com.example.demo.models.entities.Class;
import com.example.demo.models.entities.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getStudents();
    boolean addStudent(StudentCreationRequest request);
    StudentResponse editStudent(Long id);
    boolean deleteStudent(Long id);
    List<StudentResponse> searchStudent(Long id, String name, Long class_id);
}
