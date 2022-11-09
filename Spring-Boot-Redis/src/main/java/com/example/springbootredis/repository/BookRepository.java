package com.example.springbootredis.repository;

import com.example.springbootredis.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class BookRepository {

    @Autowired
    private RedisTemplate<Long, Book> redisTemplate;

    public void save(Book book){
        redisTemplate.opsForValue().set(book.getId(), book);
    }

    public Book findById(Long id) {
        return redisTemplate.opsForValue()
                .get(id);
    }

}
