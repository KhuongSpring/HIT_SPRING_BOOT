package com.example.demo.dtos.requests.book;

import com.example.demo.constants.ErrorMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookCreationRequest {
    @NotBlank(message = ErrorMessage.Book.ERR_BOOK_NAME_BLANK)
    String name;

    String description;

    double price;

    @NotNull(message = ErrorMessage.Book.ERR_AUTHOR_ID_NULL)
    Long author;

    @NotNull(message = ErrorMessage.Book.ERR_CATEGORY_ID_NULL)
    Long category;
}
