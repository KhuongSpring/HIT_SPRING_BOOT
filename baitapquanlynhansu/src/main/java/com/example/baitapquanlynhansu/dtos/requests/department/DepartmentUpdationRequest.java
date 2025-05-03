package com.example.baitapquanlynhansu.dtos.requests.department;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentUpdationRequest {
    @NotBlank
    @Size(max = 100)
    String name;
    String description;
}
