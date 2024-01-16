package com.library.LibraryMapper;

import com.library.LibraryModel.Author;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorMapper implements RowMapper<Author> {
    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Author(rs.getInt("author_id"),rs.getString("last_name"),rs.getString("first_name"),rs.getString("address"));
    }
}
