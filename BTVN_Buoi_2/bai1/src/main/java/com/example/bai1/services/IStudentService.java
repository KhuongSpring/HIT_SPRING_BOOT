package com.example.bai1.services;

import com.example.bai1.dtos.requests.StudentCreationRequest;
import com.example.bai1.dtos.requests.StudentUpdationRequest;
import com.example.bai1.entities.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getStudent();
    boolean addStudent(StudentCreationRequest request);
    boolean updateStudent(Long id, StudentUpdationRequest request);
    boolean deleteStudent(Long id);
}
