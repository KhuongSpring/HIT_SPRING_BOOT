package com.example.demo.services;

import com.example.demo.dtos.requests.category.CategoryCreationRequest;
import com.example.demo.dtos.responses.category.CategoryResponse;
import com.example.demo.entities.Category;

import java.util.List;

public interface CategoryService {
    CategoryResponse createCategory(CategoryCreationRequest request);

    boolean deleteCategory(Long id);

    List<CategoryResponse> getCategories();
    CategoryResponse getCategoryById(Long id);
}
