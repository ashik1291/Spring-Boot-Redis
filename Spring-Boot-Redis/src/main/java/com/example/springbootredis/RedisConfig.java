package com.example.springbootredis;

import com.example.springbootredis.entity.Book;
import com.example.springbootredis.repository.BookRepository;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@EnableConfigurationProperties(RedisProperties.class)
public class RedisConfig {

    @Bean
    public RedisTemplate<Long, Book> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<Long, Book> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        return template;
    }
    @Bean
    public BookRepository bookRepository(){
        return new BookRepository();
    }

}
