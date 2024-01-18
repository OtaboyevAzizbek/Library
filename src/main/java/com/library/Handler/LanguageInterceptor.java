package com.library.Handler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Locale;

public class LanguageInterceptor implements HandlerInterceptor {

    private ReloadableResourceBundleMessageSource messageSource;

    public LanguageInterceptor(ReloadableResourceBundleMessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getAttribute("messageSource")==null){
            request.setAttribute("messageSource",messageSource);
        }
        if (request.getParameter("lang")!=null){
            request.getSession().setAttribute("lang", Locale.forLanguageTag(request.getParameter("lang")));
        }
        if (request.getSession().getAttribute("lang")==null){
            request.getSession().setAttribute("lang",Locale.forLanguageTag("en-US"));
        }
        request.setAttribute("lang", request.getSession().getAttribute("lang"));

        return true;
    }
}
