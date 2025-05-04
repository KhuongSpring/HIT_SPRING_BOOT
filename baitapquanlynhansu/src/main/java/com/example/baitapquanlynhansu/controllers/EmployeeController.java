package com.example.baitapquanlynhansu.controllers;

import com.example.baitapquanlynhansu.dtos.requests.employee.EmployeeCreationRequest;
import com.example.baitapquanlynhansu.dtos.requests.employee.EmployeeGetInfomationRequest;
import com.example.baitapquanlynhansu.dtos.requests.employee.EmployeeUpdationRequest;
import com.example.baitapquanlynhansu.dtos.responses.ApiResponse;
import com.example.baitapquanlynhansu.dtos.responses.EmployeeResponse;
import com.example.baitapquanlynhansu.exceptions.CustomException;
import com.example.baitapquanlynhansu.services.EmployeeService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<ApiResponse<EmployeeResponse>> createPosition(@Valid @RequestBody EmployeeCreationRequest request) {
        return ResponseEntity.ok(ApiResponse.<EmployeeResponse>builder()
                .status(HttpStatus.CREATED)
                .result(employeeService.createEmployee(request))
                .message("Create success")
                .build());
    }

    @PutMapping
    public ResponseEntity<ApiResponse<EmployeeResponse>> updatePosition(@Valid @RequestBody EmployeeUpdationRequest request){
        return ResponseEntity.ok(ApiResponse.<EmployeeResponse>builder()
                .status(HttpStatus.OK)
                .message("Update success")
                .result(employeeService.updateEmployee(request))
                .build());
    }

    @DeleteMapping
    public ResponseEntity<ApiResponse<?>> deletePosition(@RequestParam(name = "id") Long id) {
        if (employeeService.deleteEmployee(id))
            return ResponseEntity.ok(ApiResponse.builder()
                    .status(HttpStatus.OK)
                    .message("Delete success")
                    .build());
        throw new CustomException("Employee not found", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<EmployeeResponse>>> searchEmployee(@RequestBody EmployeeGetInfomationRequest request){
        return ResponseEntity.ok(ApiResponse.<List<EmployeeResponse>>builder()
                        .result(employeeService.getEmployee(request))
                        .status(HttpStatus.OK)
                        .message("Get data success")
                .build());
    }
}
