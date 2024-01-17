package com.library.LibraryController;

import com.library.LibraryModel.User;
import com.library.LibraryService.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserPageController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String checkUser(){
     return "This is login page!";
    }

    @PostMapping("/login")
    public User createUser(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request, HttpServletResponse response){

        User user = userService.getUserByUsernameAndPassword(username,password);
        if (user!=null){
            request.getSession().setAttribute("user",user);
            return user;
        }
        return null;
    }
}
