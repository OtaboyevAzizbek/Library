package com.library.LibraryService;

import com.library.LibraryDao.CategoryDao;
import com.library.LibraryModel.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService{

    @Autowired
    CategoryDao categoryDao;

    @Override
    public void createCategory(Category category) {
        categoryDao.createCategory(category);
    }

    @Override
    public Category getCategoryById(int categoryId) {
        return categoryDao.getCategoryById(categoryId);
    }

    @Override
    public void updateCategoryById(Category category) {
        categoryDao.updateCategoryById(category);
    }

    @Override
    public void deleteCategoryById(int categoryId) {
        categoryDao.deleteCategoryById(categoryId);
    }

    @Override
    public List<Category> getCategoryList() {
        return categoryDao.getCategoryList();
    }
}
