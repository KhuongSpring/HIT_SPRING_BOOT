package com.example.demo.dtos.requests.book;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookGetInformationRequest {
    String name;

    double price;

    String authorName;

    String categoryName;
}
