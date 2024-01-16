package com.library.LibraryMapper;

import com.library.LibraryModel.Author;
import com.library.LibraryModel.Book;
import com.library.LibraryModel.Category;
import com.library.LibraryModel.Language;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Book(rs.getInt("book_id"),rs.getString("title"), Author.builder().lastName(rs.getString("last_name")).firstName(rs.getString("first_name")).build(), Category.builder().categoryName(rs.getString("category_name")).build(),rs.getString("published_year"), Language.builder().languageName(rs.getString("language_name")).build());
    }
}
