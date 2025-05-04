package com.example.baitapquanlynhansu.dtos.requests.employee;

import com.example.baitapquanlynhansu.entities.Department;
import com.example.baitapquanlynhansu.entities.Position;
import com.example.baitapquanlynhansu.entities.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "User Id not valid")
    Long userId;

    @NotNull(message = "Department Id not valid")
    Long departmentId;

    @NotNull(message = "Position Id not valid")
    Long positionId;

    @NotBlank(message = "Full name not valid")
    @Size(max = 100, message = "Full name must be shorter than 100 characters")
    String fullName;

    @NotNull(message = "Date of Birth not valid")
    LocalDate dateOfBirth;

    @NotNull(message = "Hired Date not valid")
    LocalDate hiredDate;

    @NotNull(message = "Salary not valid")
    BigDecimal salary;
}
