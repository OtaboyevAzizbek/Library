package com.library.LibraryMapper;

import com.library.LibraryModel.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(rs.getInt("user_id"),rs.getString("username"),rs.getString("password"),rs.getInt("role_name"));
    }
}
