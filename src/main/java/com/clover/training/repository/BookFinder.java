package com.clover.training.repository;

import com.clover.training.model.Book;

import java.io.IOException;
import java.util.List;

public interface BookFinder {

    List<Book> findAll() throws IOException;

    Book findByISBN(String isbn) throws IOException;

    void save(Book book) throws IOException;

    void update(Book book) throws IOException;

}
