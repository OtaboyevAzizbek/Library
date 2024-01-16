package com.library.LibraryDao;

import com.library.LibraryModel.Category;

import java.util.List;

public interface CategoryDao {
    void createCategory(Category category);
    Category getCategoryById(int categoryId);
    void updateCategoryById(Category category);
    void deleteCategoryById(int categoryId);
    List<Category> getCategoryList();
}
