package com.example.baitapquanlynhansu.dtos.responses;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentResponse {
    Long id;
    String name;
    String description;
}
