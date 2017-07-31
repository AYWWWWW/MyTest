package com.mt.spring.cache.repository;

import com.mt.spring.cache.model.Book;

/**
 * created by anyanwen on 2017/7/31.
 */
public interface BookRepository {
    Book getByIsbn(String isbn);
}
