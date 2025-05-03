package com.example.baitapquanlynhansu.services.impls;

import com.example.baitapquanlynhansu.dtos.requests.employee.EmployeeCreationRequest;
import com.example.baitapquanlynhansu.dtos.requests.employee.EmployeeUpdationRequest;
import com.example.baitapquanlynhansu.dtos.responses.EmployeeResponse;
import com.example.baitapquanlynhansu.entities.Employee;
import com.example.baitapquanlynhansu.repositories.EmployeeRepository;
import com.example.baitapquanlynhansu.services.EmployeeService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    ModelMapper modelMapper;
    EmployeeRepository employeeRepository;

    @Override
    public EmployeeResponse createEmployee(EmployeeCreationRequest request) {
        return null;
    }

    @Override
    public List<EmployeeResponse> listEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeResponse> employeeResponses = new ArrayList<>();
        for (Employee e : employees) {
            employeeResponses.add(modelMapper.map(e, EmployeeResponse.class));
        }
        return employeeResponses;
    }

    @Override
    public EmployeeResponse updateEmployee(EmployeeUpdationRequest request) {
        return null;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        return false;
    }
}
