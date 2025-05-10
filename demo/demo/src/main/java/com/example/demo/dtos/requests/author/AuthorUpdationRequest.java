package com.example.demo.dtos.requests.author;

import com.example.demo.constants.ErrorMessage;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorUpdationRequest {
    @NotNull(message = ErrorMessage.Author.ERR_NULL_ID)
    Long id;

    String name;

    LocalDate dob;

    String bio;
}
