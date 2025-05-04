package com.example.baitapquanlynhansu.controllers;

import com.example.baitapquanlynhansu.dtos.requests.department.DepartmentCreationRequest;
import com.example.baitapquanlynhansu.dtos.requests.department.DepartmentUpdationRequest;
import com.example.baitapquanlynhansu.dtos.requests.user.UserCreationRequest;
import com.example.baitapquanlynhansu.dtos.requests.user.UserUpdationRequest;
import com.example.baitapquanlynhansu.dtos.responses.ApiResponse;
import com.example.baitapquanlynhansu.dtos.responses.DepartmentResponse;
import com.example.baitapquanlynhansu.dtos.responses.UserResponse;
import com.example.baitapquanlynhansu.exceptions.CustomException;
import com.example.baitapquanlynhansu.services.DepartmentService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<ApiResponse<DepartmentResponse>> createDepartment(@Valid @RequestBody DepartmentCreationRequest request) {
        return ResponseEntity.ok(ApiResponse.<DepartmentResponse>builder()
                .status(HttpStatus.CREATED)
                .result(departmentService.createDepartment(request))
                .message("Create success")
                .build());
    }

    @PutMapping
    public ResponseEntity<ApiResponse<DepartmentResponse>> updateDepartment(@Valid @RequestBody DepartmentUpdationRequest request){
        return ResponseEntity.ok(ApiResponse.<DepartmentResponse>builder()
                .status(HttpStatus.OK)
                .message("Update success")
                .result(departmentService.updateDepartment(request))
                .build());
    }

    @DeleteMapping
    public ResponseEntity<ApiResponse<?>> deleteDepartment(@RequestParam(name = "id") Long id) {
        if (departmentService.deleteDepartment(id))
            return ResponseEntity.ok(ApiResponse.builder()
                    .status(HttpStatus.OK)
                    .message("Delete success")
                    .build());
        throw new CustomException("Department not found", HttpStatus.BAD_REQUEST);
    }
}
