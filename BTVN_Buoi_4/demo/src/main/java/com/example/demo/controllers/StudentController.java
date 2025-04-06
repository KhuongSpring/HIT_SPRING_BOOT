package com.example.demo.controllers;

import com.example.demo.models.dtos.requests.StudentCreationRequest;
import com.example.demo.models.dtos.responses.ApiResponse;
import com.example.demo.models.dtos.responses.StudentResponse;
import com.example.demo.models.entities.Class;
import com.example.demo.models.entities.Student;
import com.example.demo.services.impls.StudentService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/api/student")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class StudentController {
    StudentService studentService;
    ModelMapper modelMapper;

    @GetMapping("/getAll")
    public ApiResponse<List<StudentResponse>> getStudent() {
        ApiResponse<List<StudentResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Lay danh sach thanh cong");
        List<StudentResponse> studentResponses = studentService.getStudents()
                .stream()
                .map(student -> modelMapper.map(student, StudentResponse.class))
                .collect(Collectors.toList());
        apiResponse.setResult(studentResponses);
        return apiResponse;
    }

    @GetMapping("/getStudent")
    public ApiResponse<List<StudentResponse>> getStudentBy(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Long class_id) {
        ApiResponse<List<StudentResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Lay sinh vien thanh cong");
        apiResponse.setResult(studentService.searchStudent(id, name, class_id));
        return apiResponse;
    }

    @PostMapping("/create")
    public ApiResponse<StudentResponse> createStudent(@RequestBody @Valid StudentCreationRequest request) {
        ApiResponse<StudentResponse> apiResponse = new ApiResponse<>();
        if (studentService.addStudent(request)) {
            apiResponse.setMessage("Them thanh cong");
            apiResponse.setStatus(200);
            StudentResponse studentResponse = modelMapper.map(studentService.addStudent(request), StudentResponse.class);
            apiResponse.setResult(studentResponse);
            return apiResponse;
        }
        apiResponse.setStatus(404);
        apiResponse.setMessage("Them that bai");
        return apiResponse;
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse<String> deleteStudent(@PathVariable Long id) {
        ApiResponse<String> apiResponse = new ApiResponse<>();
        if (!studentService.deleteStudent(id)) {
            apiResponse.setMessage("Xoa that bai");
            apiResponse.setStatus(404);
            return apiResponse;
        }
        apiResponse.setMessage("Xoa thanh cong");
        apiResponse.setStatus(200);
        return apiResponse;
    }
}
