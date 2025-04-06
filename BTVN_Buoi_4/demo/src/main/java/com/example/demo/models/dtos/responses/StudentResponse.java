package com.example.demo.models.dtos.responses;

import com.example.demo.models.entities.Class;
import com.example.demo.models.entities.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class StudentResponse {
    Long id;
    String name;
    Date dob;
    Gender gender;
    String email;
    String phoneNumber;
    Class classes;
}
