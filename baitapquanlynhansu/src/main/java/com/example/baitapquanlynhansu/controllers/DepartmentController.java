package com.example.baitapquanlynhansu.controllers;

import com.example.baitapquanlynhansu.dtos.responses.ApiResponse;
import com.example.baitapquanlynhansu.dtos.responses.DepartmentResponse;
import com.example.baitapquanlynhansu.services.DepartmentService;
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
@RequestMapping("/api/department")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class DepartmentController {
    DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<DepartmentResponse>>> getListDepartment() {
        return ResponseEntity.ok(ApiResponse.<List<DepartmentResponse>>builder()
                .status(HttpStatus.OK)
                .result(departmentService.listDepartment())
                .build());
    }
}
