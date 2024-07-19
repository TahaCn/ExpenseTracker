package com.taha.expense_tracker.mapper;

import com.taha.expense_tracker.dto.CategoryDto;
import com.taha.expense_tracker.entity.Category;

public class CategoryMapper {

    public static Category mapToCategory(CategoryDto categoryDto){
           return new Category(
                   categoryDto.id(),
                   categoryDto.name()
           );
    }

    public static CategoryDto mapToCategoryDto(Category category){
        return new CategoryDto(
                category.getId(),
                category.getName()
        );

    }
}
