package com.example.baitapquanlynhansu.dtos.requests.employee;

import com.example.baitapquanlynhansu.entities.Department;
import com.example.baitapquanlynhansu.entities.Position;
import com.example.baitapquanlynhansu.entities.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeCreationRequest {
    @NotBlank
    User userId;

    @NotBlank
    Department departmentId;

    @NotBlank
    Position positionId;

    @NotBlank
    @Size(max = 100)
    String fullName;

    LocalDate dateOfBirth;

    LocalDate hiredDate;

    BigDecimal salary;
}
