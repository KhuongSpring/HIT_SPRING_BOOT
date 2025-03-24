package com.example.bai1.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "full_name", length = 100, nullable = false)
    String name;
    @Column(name = "email", unique = true, length = 150)
    String email;
    @Column(name = "phone_number", length = 15)
    String phoneNumber;
    @Column(name = "address")
    String address;
}
