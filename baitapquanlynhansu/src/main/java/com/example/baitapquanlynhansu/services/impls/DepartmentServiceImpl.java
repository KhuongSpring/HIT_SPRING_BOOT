package com.example.baitapquanlynhansu.services.impls;

import com.example.baitapquanlynhansu.dtos.requests.department.DepartmentCreationRequest;
import com.example.baitapquanlynhansu.dtos.requests.department.DepartmentUpdationRequest;
import com.example.baitapquanlynhansu.dtos.responses.DepartmentResponse;
import com.example.baitapquanlynhansu.entities.Department;
import com.example.baitapquanlynhansu.exceptions.CustomException;
import com.example.baitapquanlynhansu.repositories.DepartmentRepository;
import com.example.baitapquanlynhansu.services.DepartmentService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    ModelMapper modelMapper;
    DepartmentRepository departmentRepository;

    @Override
    public DepartmentResponse createDepartment(DepartmentCreationRequest request) {
        if (departmentRepository.existsByName(request.getName()))
            throw new CustomException("Name existed", HttpStatus.CONFLICT);
        Department department = modelMapper.map(request, Department.class);
        departmentRepository.save(department);
        return modelMapper.map(department, DepartmentResponse.class);
    }

    @Override
    public List<DepartmentResponse> listDepartment() {
        List<Department> departments = departmentRepository.findAll();
        List<DepartmentResponse> departmentResponses = new ArrayList<>();
        for (Department d : departments) {
            departmentResponses.add(modelMapper.map(d, DepartmentResponse.class));
        }
        return departmentResponses;
    }

    @Override
    public DepartmentResponse updateDepartment(DepartmentUpdationRequest request) {
        Department oldDepartment = departmentRepository.findById(request.getId())
                .orElseThrow(() -> new CustomException("Department not found", HttpStatus.BAD_REQUEST));
        if (departmentRepository.existsByName(request.getName()) && !oldDepartment.getName().equals(request.getName()))
            throw new CustomException("Name existed", HttpStatus.CONFLICT);

        oldDepartment.setName(request.getName());
        oldDepartment.setDescription(request.getDescription());
        departmentRepository.save(oldDepartment);
        return modelMapper.map(oldDepartment, DepartmentResponse.class);
    }


    @Override
    public boolean deleteDepartment(Long id) {
        if (departmentRepository.existsById(id)){
            departmentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
