package com.example.bai1.dtos.requests;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class StudentUpdationRequest {
    String name;
    String email;
    String phoneNumber;
    String address;
}
