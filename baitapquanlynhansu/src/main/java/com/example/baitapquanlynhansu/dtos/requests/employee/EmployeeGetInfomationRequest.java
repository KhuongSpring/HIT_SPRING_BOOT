package com.example.baitapquanlynhansu.dtos.requests.employee;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeGetInfomationRequest {
    Long id;

    Long userId;

    Long departmentId;

    Long positionId;

    String fullName;

    LocalDate dateOfBirth;

    LocalDate hiredDate;

    BigDecimal salary;
}
