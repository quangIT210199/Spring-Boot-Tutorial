package com.quang.springboot13.config;

import com.quang.springboot13.model.TodoValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TodoConfig {
    /**
     * Tạo ra Bean TodoValidator để sử dụng sau này,
     * @return
     */
    @Bean
    public TodoValidator validator(){
        return new TodoValidator();
    }
}
