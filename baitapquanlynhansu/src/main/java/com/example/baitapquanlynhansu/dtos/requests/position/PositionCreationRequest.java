package com.example.baitapquanlynhansu.dtos.requests.position;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PositionCreationRequest {
    @NotBlank
    @Size(max = 100)
    String title;
    String description;
}
