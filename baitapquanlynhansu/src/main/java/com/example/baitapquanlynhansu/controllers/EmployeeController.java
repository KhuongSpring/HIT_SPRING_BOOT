package com.example.baitapquanlynhansu.controllers;

import com.example.baitapquanlynhansu.dtos.responses.ApiResponse;
import com.example.baitapquanlynhansu.dtos.responses.EmployeeResponse;
import com.example.baitapquanlynhansu.services.EmployeeService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class EmployeeController {
    EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<EmployeeResponse>>> getListEmployee() {
        return ResponseEntity.ok(ApiResponse.<List<EmployeeResponse>>builder()
                .status(HttpStatus.OK)
                .result(employeeService.listEmployee())
                .build());
    }
}
