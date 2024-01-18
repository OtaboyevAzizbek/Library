package com.library.Configuration;

import com.library.Handler.LanguageInterceptor;
import com.library.Handler.UserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    ReloadableResourceBundleMessageSource messageSource;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LanguageInterceptor(messageSource)).addPathPatterns("/**");
        registry.addInterceptor(new UserInterceptor()).addPathPatterns("/**");
    }
}
