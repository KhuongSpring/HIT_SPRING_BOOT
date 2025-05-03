package com.example.baitapquanlynhansu.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User userId;

    @ManyToOne
    @JoinColumn(name = "department_id")
    Department departmentId;

    @ManyToOne
    @JoinColumn(name = "position_id")
    Position positionId;

    @Column(length = 100, nullable = false)
    String fullName;

    LocalDate dateOfBirth;

    LocalDate hiredDate;

    @Column(precision = 10, scale = 2)
    BigDecimal salary;
}
