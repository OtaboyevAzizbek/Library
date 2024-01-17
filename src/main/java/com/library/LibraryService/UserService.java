package com.library.LibraryService;

import com.library.LibraryModel.User;

import java.util.List;

public interface UserService {
    void createUser(User user);
    User geUserById(int userId);
    User getUserByUsernameAndPassword(String username,String password);
    void updateUserById(User user);
    void deleteUserById(int userId);
    List<User> getUserList();
}
