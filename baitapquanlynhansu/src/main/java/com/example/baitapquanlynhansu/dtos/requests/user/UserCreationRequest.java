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
public class UserCreationRequest {
    @NotBlank(message = "Username not valid")
    @Size(max = 50, message = "Username must be shorter than 50 characters")
    String username;
    @NotBlank(message = "Password not valid")
    @Size(max = 255, message = "Password must be shorter than 255 characters")
    String password;
    @Email(message = "Email not valid")
    String email;
}
