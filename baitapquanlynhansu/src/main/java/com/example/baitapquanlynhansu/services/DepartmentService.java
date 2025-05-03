package com.example.baitapquanlynhansu.services;

import com.example.baitapquanlynhansu.dtos.requests.department.DepartmentCreationRequest;
import com.example.baitapquanlynhansu.dtos.requests.department.DepartmentUpdationRequest;
import com.example.baitapquanlynhansu.dtos.responses.DepartmentResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DepartmentService {
    DepartmentResponse createDepartment(DepartmentCreationRequest request);

    List<DepartmentResponse> listDepartment();

    DepartmentResponse updateDepartment(DepartmentUpdationRequest request);

    boolean deleteDepartment(Long id);
}
