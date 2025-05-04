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
public class DepartmentCreationRequest {
    @NotBlank(message = "Name not valid")
    @Size(max = 100, message = "Name must be shorter than 100 characters")
    String name;
    String description;
}
