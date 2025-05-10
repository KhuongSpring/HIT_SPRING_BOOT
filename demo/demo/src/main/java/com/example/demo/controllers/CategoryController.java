package com.example.demo.controllers;

import com.example.demo.constants.ErrorMessage;
import com.example.demo.constants.ResponseMessage;
import com.example.demo.constants.UrlConstant;
import com.example.demo.dtos.requests.author.AuthorCreationRequest;
import com.example.demo.dtos.requests.category.CategoryCreationRequest;
import com.example.demo.dtos.responses.ApiResponse;
import com.example.demo.dtos.responses.author.AuthorResponse;
import com.example.demo.dtos.responses.category.CategoryResponse;
import com.example.demo.exceptions.CustomException;
import com.example.demo.services.CategoryService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryController {
    CategoryService categoryService;

    @GetMapping(UrlConstant.Category.GET_CATEGORYS)
    public ResponseEntity<ApiResponse<List<CategoryResponse>>> getCategories() {
        return ResponseEntity.ok(ApiResponse.
                <List<CategoryResponse>>builder()
                .status(HttpStatus.OK)
                .result(categoryService.getCategories())
                .message(ResponseMessage.Messgae.GET_SUCCESS)
                .build());
    }

    @PostMapping(UrlConstant.Category.CREATE_CATEGORY)
    public ResponseEntity<ApiResponse<CategoryResponse>> createCategory(@Valid @RequestBody CategoryCreationRequest request){
        return ResponseEntity.ok(ApiResponse.<CategoryResponse>builder()
                .result(categoryService.createCategory(request))
                .status(HttpStatus.CREATED)
                .message(ResponseMessage.Messgae.CREATE_SUCCESS)
                .build());
    }

    @DeleteMapping(UrlConstant.Category.DELETE_CATEGORY)
    public ResponseEntity<ApiResponse<?>> deleteCategory(@RequestParam(name = "id") Long id){
        if (categoryService.deleteCategory(id))
            return ResponseEntity.ok(ApiResponse.builder()
                    .status(HttpStatus.OK)
                    .message(ResponseMessage.Messgae.DELETE_SUCCESS)
                    .build());
        throw new CustomException(ErrorMessage.Category.ERR_DELETE_FAIL, HttpStatus.BAD_REQUEST);
    }

    @GetMapping(UrlConstant.Category.GET_CATEGORY)
    public ResponseEntity<ApiResponse<CategoryResponse>> getCategory(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok(ApiResponse.
                <CategoryResponse>builder()
                .status(HttpStatus.OK)
                .result(categoryService.getCategoryById(id))
                .message(ResponseMessage.Messgae.GET_SUCCESS)
                .build());
    }
}
