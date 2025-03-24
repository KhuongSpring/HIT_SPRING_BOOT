package com.example.bai1.services.impl;

import com.example.bai1.dtos.requests.StudentCreationRequest;
import com.example.bai1.dtos.requests.StudentUpdationRequest;
import com.example.bai1.entities.Student;
import com.example.bai1.repositories.StudentRepository;
import com.example.bai1.services.IStudentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class StudentService implements IStudentService {
    StudentRepository studentRepository;
    ModelMapper modelMapper;

    @Override
    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    @Override
    public boolean addStudent(StudentCreationRequest request) {
        if (studentRepository.existsByEmail(request.getEmail())) return false;
        studentRepository.save(modelMapper.map(request, Student.class));
        return true;
    }

    @Override
    public boolean updateStudent(Long id, StudentUpdationRequest request) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException());
        if (request.getName() != null) student.setName(request.getName());
        if (request.getPhoneNumber() != null) student.setPhoneNumber(request.getPhoneNumber());
        if (request.getEmail() != null) student.setEmail(request.getEmail());
        if (request.getAddress() != null) student.setAddress(request.getAddress());
        studentRepository.save(student);
        return true;
    }

    @Override
    public boolean deleteStudent(Long id) {
        studentRepository.findById(id).orElseThrow(() -> new RuntimeException());
        studentRepository.deleteById(id);
        return true;
    }
}
