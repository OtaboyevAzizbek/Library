package com.library.Handler;

import com.library.LibraryModel.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        if (user==null && !request.getRequestURI().equals("/user/login")){
            response.sendRedirect("/user/login");
            return false;
        }
        return true;
    }
}
