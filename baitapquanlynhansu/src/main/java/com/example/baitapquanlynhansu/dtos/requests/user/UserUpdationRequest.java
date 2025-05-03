package com.example.baitapquanlynhansu.dtos.requests.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdationRequest {
    @NotBlank
    @Size(max = 50)
    String username;
    @NotBlank
    @Size(max = 255)
    String password;
    @Email
    String email;
}
