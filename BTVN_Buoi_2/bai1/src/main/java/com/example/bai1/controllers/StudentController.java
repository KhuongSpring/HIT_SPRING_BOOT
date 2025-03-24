package com.example.bai1.controllers;

import com.example.bai1.dtos.requests.StudentCreationRequest;
import com.example.bai1.dtos.requests.StudentUpdationRequest;
import com.example.bai1.dtos.responses.ApiResponse;
import com.example.bai1.dtos.responses.StudentResponse;
import com.example.bai1.services.impl.StudentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentController {
    StudentService studentService;
    ModelMapper modelMapper;
    @GetMapping("/get")
    public ApiResponse<List<StudentResponse>> getStudents(){
        ApiResponse<List<StudentResponse>> response = new ApiResponse<>();
        List<StudentResponse> studentResponse = studentService.getStudent()
                .stream()
                .map(student -> modelMapper.map(student, StudentResponse.class))
                .collect(Collectors.toList());
        response.setResult(studentResponse);
        return response;
    }

    @PostMapping("/add")
    public ApiResponse<StudentResponse> addStudent(@RequestBody StudentCreationRequest request){
        ApiResponse<StudentResponse> response = new ApiResponse<>();
        if (!studentService.addStudent(request)){
            response.setCode(404);
            response.setMessage("Tao student khong thanh cong");
        }
        response.setMessage("Tao student thanh cong");
        response.setResult(modelMapper.map(request, StudentResponse.class));
        return response;
    }

    @PutMapping("/update/{id}")
    public ApiResponse<StudentResponse> updateStudent(@PathVariable("id") Long id, @RequestBody StudentUpdationRequest request){
        ApiResponse<StudentResponse> response = new ApiResponse<>();
        if (!studentService.updateStudent(id, request)){
            response.setCode(404);
            response.setMessage("Cap nhat khong thanh cong");
        }
        response.setMessage("Cap nhat thanh cong");
        response.setResult(modelMapper.map(request, StudentResponse.class));
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse<Object> deleteStudnet(@PathVariable("id") Long id){
        ApiResponse<String> response = new ApiResponse<>();
        if (!studentService.deleteStudent(id)){
            response.setCode(404);
            response.setMessage("Xoa khong thanh cong");
        }
        return response.builder()
                .message("Xoa thanh cong")
                .build();
    }


}
