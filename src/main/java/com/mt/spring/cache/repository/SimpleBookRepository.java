package com.mt.spring.cache.repository;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.mt.spring.cache.model.Book;

/**
 * created by anyanwen on 2017/7/31.
 */
@Component
public class SimpleBookRepository implements BookRepository{

    @Override
    @Cacheable("books")
    public Book getByIsbn(String isbn) {
        simulateSlowService();
        return new Book(isbn, "Some book");
    }

    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
