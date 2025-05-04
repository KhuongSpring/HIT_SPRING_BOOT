package com.example.baitapquanlynhansu.dtos.requests.position;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PositionUpdationRequest {
    @NotNull
    Long id;
    @NotBlank(message = "Title not valid")
    @Size(max = 100, message = "Title must be shorter than 100 characters")
    String title;
    String description;
}
