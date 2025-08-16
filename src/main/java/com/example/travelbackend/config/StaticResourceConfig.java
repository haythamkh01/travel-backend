package com.example.travelbackend.config;
// StaticResourceConfig.java


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class StaticResourceConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/files/news/**")
                .addResourceLocations("file:uploads/news/");
    }
}
