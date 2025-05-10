package com.example.demo.dtos.requests.author;

import com.example.demo.constants.ErrorMessage;
import jakarta.validation.constraints.NotBlank;
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
public class AuthorCreationRequest {
    @NotBlank(message = ErrorMessage.Author.ERR_AUTHOR_NAME_BLANK)
    String name;

    @NotNull(message = ErrorMessage.Author.ERR_DOB_NULL)
    LocalDate dob;

    String bio;
}
