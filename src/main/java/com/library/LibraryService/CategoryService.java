package com.library.LibraryService;

import com.library.LibraryModel.Category;

import java.util.List;

public interface CategoryService {
    void createCategory(Category category);
    Category getCategoryById(int categoryId);
    void updateCategoryById(Category category);
    void deleteCategoryById(int categoryId);
    List<Category> getCategoryList();
}
