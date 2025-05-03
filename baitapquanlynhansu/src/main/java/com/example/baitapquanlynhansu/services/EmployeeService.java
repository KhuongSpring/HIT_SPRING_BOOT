package com.example.baitapquanlynhansu.services;

import com.example.baitapquanlynhansu.dtos.requests.employee.EmployeeCreationRequest;
import com.example.baitapquanlynhansu.dtos.requests.employee.EmployeeUpdationRequest;
import com.example.baitapquanlynhansu.dtos.responses.EmployeeResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    EmployeeResponse createEmployee(EmployeeCreationRequest request);

    List<EmployeeResponse> listEmployee();

    EmployeeResponse updateEmployee(EmployeeUpdationRequest request);

    boolean deleteEmployee(Long id);
}
