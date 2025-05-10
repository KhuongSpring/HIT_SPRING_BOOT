package com.example.demo.services.impls;

import com.example.demo.constants.ErrorMessage;
import com.example.demo.dtos.requests.category.CategoryCreationRequest;
import com.example.demo.dtos.responses.category.CategoryResponse;
import com.example.demo.entities.Category;
import com.example.demo.exceptions.CustomException;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.services.CategoryService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    ModelMapper modelMapper;
    CategoryRepository categoryRepository;

    @Override
    public CategoryResponse createCategory(CategoryCreationRequest request) {
        if (categoryRepository.existsByName(request.getName()))
            throw new CustomException(ErrorMessage.Category.ERR_CATEGORY_NAME_EXISTED, HttpStatus.CONFLICT);
        Category category = modelMapper.map(request, Category.class);
        categoryRepository.save(category);
        return modelMapper.map(category, CategoryResponse.class);
    }

    @Override
    public boolean deleteCategory(Long id) {
        if (categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<CategoryResponse> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryResponse> categoryResponses = new ArrayList<>();
        for(Category a : categories){
            categoryResponses.add(modelMapper.map(a, CategoryResponse.class));
        }
        return categoryResponses;
    }

    @Override
    public CategoryResponse getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorMessage.Category.ERR_CATEGORY_NOT_FOUND, HttpStatus.BAD_REQUEST));
        return modelMapper.map(category, CategoryResponse.class);
    }
}
