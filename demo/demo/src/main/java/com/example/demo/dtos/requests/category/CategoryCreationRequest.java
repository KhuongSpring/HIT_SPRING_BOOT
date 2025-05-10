package com.example.demo.dtos.requests.category;

import com.example.demo.constants.ErrorMessage;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryCreationRequest {
    @NotBlank(message = ErrorMessage.Category.ERR_CATEGORY_NAME_BLANK)
    String name;
}
