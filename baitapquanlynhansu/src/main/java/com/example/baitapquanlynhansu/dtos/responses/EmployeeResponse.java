package com.example.baitapquanlynhansu.dtos.responses;

import com.example.baitapquanlynhansu.entities.Department;
import com.example.baitapquanlynhansu.entities.Position;
import com.example.baitapquanlynhansu.entities.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeResponse {
    Long id;

    User userId;

    Department departmentId;

    Position positionId;

    String fullName;

    LocalDate dateOfBirth;

    LocalDate hiredDate;

    BigDecimal salary;
}
