package com.example.bai1.dtos.responses;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentResponse {
    Long id;
    String name;
    String email;
    String phoneNumber;
    String address;
}
