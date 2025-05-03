package com.example.baitapquanlynhansu.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(length = 50, unique = true, nullable = false)
    String username;

    @Column(nullable = false)
    String password;

    @Column(length = 100, nullable = false, unique = true)
    String email;

    LocalDateTime createAt;
}
