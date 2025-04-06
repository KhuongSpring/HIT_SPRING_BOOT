package com.example.demo.models.dtos.requests;

import com.example.demo.models.entities.Class;
import com.example.demo.models.entities.Gender;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentCreationRequest {
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
    Class classes;
}
