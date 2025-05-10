package com.example.demo.dtos.responses.book;

import com.example.demo.entities.Author;
import com.example.demo.entities.Category;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookResponse {
    Long id;

    String name;

    String description;

    double price;

    Author author;

    Category category;
}
