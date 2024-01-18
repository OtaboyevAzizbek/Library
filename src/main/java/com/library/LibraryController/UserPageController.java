package com.library.LibraryController;

import com.library.LibraryModel.User;
import com.library.LibraryService.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")
public class UserPageController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public ModelAndView checkUser(){
        return new ModelAndView("logger");
    }

    @PostMapping("/login")
    public ModelAndView createUser(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request, HttpServletResponse response){
        User user = userService.getUserByUsernameAndPassword(username,password);
        if (user!=null){
            request.getSession().setAttribute("user",user);
            return new ModelAndView("redirect:/library/main");
        }
        return new ModelAndView("redirect:/user/login");
    }
}
