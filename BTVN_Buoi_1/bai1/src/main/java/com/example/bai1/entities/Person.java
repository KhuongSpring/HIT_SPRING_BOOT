package com.example.bai1.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Person {
    String name;
    int age;
    String gender;
    String email;
}
