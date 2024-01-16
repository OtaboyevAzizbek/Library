package com.library.LibraryDao;

import com.library.LibraryMapper.CategoryMapper;
import com.library.LibraryModel.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryDaoImp implements CategoryDao{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void createCategory(Category category) {
        jdbcTemplate.update("INSERT INTO category(category_name) VALUES(?);",new Object[]{category.getCategoryName()});
    }

    @Override
    public Category getCategoryById(int categoryId) {
        return jdbcTemplate.queryForObject("SELECT * FROM category WHERE category_id=?;",new Object[]{categoryId},new CategoryMapper());
    }

    @Override
    public void updateCategoryById(Category category) {
        jdbcTemplate.update("UPDATE category SET category_name=? WHERE category_id=?;",new Object[]{category.getCategoryName(),category.getCategoryId()});
    }

    @Override
    public void deleteCategoryById(int categoryId) {
        jdbcTemplate.update("DELETE FROM category WHERE category_id=?;",new Object[]{categoryId});
    }

    @Override
    public List<Category> getCategoryList() {
        return jdbcTemplate.query("SELECT * FROM category;",new CategoryMapper());
    }
}
