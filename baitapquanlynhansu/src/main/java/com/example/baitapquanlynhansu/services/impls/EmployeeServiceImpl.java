package com.example.baitapquanlynhansu.services.impls;

import com.example.baitapquanlynhansu.dtos.requests.employee.EmployeeCreationRequest;
import com.example.baitapquanlynhansu.dtos.requests.employee.EmployeeGetInfomationRequest;
import com.example.baitapquanlynhansu.dtos.requests.employee.EmployeeUpdationRequest;
import com.example.baitapquanlynhansu.dtos.responses.EmployeeResponse;
import com.example.baitapquanlynhansu.entities.Department;
import com.example.baitapquanlynhansu.entities.Employee;
import com.example.baitapquanlynhansu.entities.Position;
import com.example.baitapquanlynhansu.entities.User;
import com.example.baitapquanlynhansu.exceptions.CustomException;
import com.example.baitapquanlynhansu.repositories.DepartmentRepository;
import com.example.baitapquanlynhansu.repositories.EmployeeRepository;
import com.example.baitapquanlynhansu.repositories.PositionRepository;
import com.example.baitapquanlynhansu.repositories.UserRepository;
import com.example.baitapquanlynhansu.services.EmployeeService;
import jakarta.persistence.criteria.Predicate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    ModelMapper modelMapper;
    EmployeeRepository employeeRepository;
    UserRepository userRepository;
    DepartmentRepository departmentRepository;
    PositionRepository positionRepository;

    @Override
    public EmployeeResponse createEmployee(EmployeeCreationRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new CustomException("User not found", HttpStatus.BAD_REQUEST));
        Department department = departmentRepository.findById(request.getDepartmentId())
                .orElseThrow(() -> new CustomException("Department not found", HttpStatus.BAD_REQUEST));
        Position position = positionRepository.findById(request.getPositionId())
                .orElseThrow(() -> new CustomException("Position not found", HttpStatus.BAD_REQUEST));

        Employee employee = Employee.builder()
                .userId(user)
                .departmentId(department)
                .positionId(position)
                .fullName(request.getFullName())
                .dateOfBirth(request.getDateOfBirth())
                .hiredDate(request.getHiredDate())
                .salary(request.getSalary())
                .build();
        employeeRepository.save(employee);
        return modelMapper.map(employee, EmployeeResponse.class);
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
        Employee oldEmployee = employeeRepository.findById(request.getId())
                .orElseThrow(() -> new CustomException("Employee not found", HttpStatus.BAD_REQUEST));
        Department department = departmentRepository.findById(request.getDepartmentId())
                .orElseThrow(() -> new CustomException("Department not found", HttpStatus.BAD_REQUEST));
        Position position = positionRepository.findById(request.getPositionId())
                .orElseThrow(() -> new CustomException("Position not found", HttpStatus.BAD_REQUEST));

        oldEmployee.setDepartmentId(department);
        oldEmployee.setPositionId(position);
        oldEmployee.setFullName(request.getFullName());
        oldEmployee.setHiredDate(request.getHiredDate());
        oldEmployee.setSalary(request.getSalary());
        employeeRepository.save(oldEmployee);
        return modelMapper.map(oldEmployee, EmployeeResponse.class);
    }

    @Override
    public boolean deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<EmployeeResponse> getEmployee(EmployeeGetInfomationRequest request) {
        Specification<Employee> spec = build(request);
        List<Employee> employees= employeeRepository.findAll(spec);
        List<EmployeeResponse> employeeResponses = new ArrayList<>();
        for (Employee e : employees) {
            employeeResponses.add(modelMapper.map(e, EmployeeResponse.class));
        }
        return employeeResponses;
    }

    public static Specification<Employee> build(EmployeeGetInfomationRequest request) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (request.getId() != null)
                predicates.add(cb.equal(root.get("id"), request.getId()));

            if (request.getUserId() != null) {
                predicates.add(cb.equal(root.get("userId").get("id"), request.getUserId()));
            }

            if (request.getDepartmentId() != null) {
                predicates.add(cb.equal(root.get("departmentId").get("id"), request.getDepartmentId()));
            }

            if (request.getPositionId() != null) {
                predicates.add(cb.equal(root.get("positionId").get("id"), request.getPositionId()));
            }

            if (request.getFullName() != null && !request.getFullName().isBlank()) {
                predicates.add(cb.like(cb.lower(root.get("fullName")), "%" + request.getFullName().toLowerCase() + "%"));
            }

            if (request.getHiredDate() != null) {
                predicates.add(cb.equal(root.get("hiredDate"), request.getHiredDate()));
            }

            if (request.getSalary() != null) {
                predicates.add(cb.equal(root.get("salary"), request.getSalary()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
