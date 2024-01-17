package com.library.LibraryDao;

import com.library.LibraryMapper.UserMapper;
import com.library.LibraryModel.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImp implements UserDao{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void createUser(User user) {
        jdbcTemplate.update("INSERT INTO users_table(username, password, role_name) VALUES(?,?,?);",new Object[]{user.getUsername(),user.getPassword(),user.getUserRole()});
    }

    @Override
    public User geUserById(int userId) {
        return jdbcTemplate.queryForObject("SELECT * FROM users_table WHERE user_id=?;",new Object[]{userId},new UserMapper());
    }

    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        return jdbcTemplate.queryForObject("SELECT * FROM users_table WHERE username=? AND password=?;",new Object[]{username,password},new UserMapper());
    }

    @Override
    public void updateUserById(User user) {
        jdbcTemplate.update("UPDATE users_table SET username=?,password=?,role_name=? WHERE user_id=?;",new Object[]{user.getUsername(),user.getPassword(),user.getUserRole(),user.getUserId()});
    }

    @Override
    public void deleteUserById(int userId) {
        jdbcTemplate.update("DELETE FROM users_table WHERE user_id=?;",new Object[]{userId});
    }

    @Override
    public List<User> getUserList() {
        return jdbcTemplate.query("SELECT * FROM users_table;",new UserMapper());
    }
}
