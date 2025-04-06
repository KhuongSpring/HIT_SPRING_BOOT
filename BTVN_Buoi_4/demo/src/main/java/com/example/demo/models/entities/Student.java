package com.example.demo.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Size(min = 3)
    String name;
    @NotNull
    Date dob;
    @NotNull
    Gender gender;
    @Email
    String email;
    @NotNull
    String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "class_id")
    Class classes;

}
