package com.clover.training.service;

import com.clover.training.model.Book;
import com.clover.training.repository.BookFinder;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookService {

    private BookFinder finder;

    public void setFinder(BookFinder finder) {
        this.finder = finder;
    }

    @Transactional
    public List<Book> findBooksWroteBy(String author) throws IOException {
        List<Book> result = new ArrayList<Book>();
        for (Book book : finder.findAll()) {
            if (book.wroteBy(author)) {
                result.add(book);
            }
        }
        return result;
    }

    @Transactional
    public List<Book> listBooks() throws IOException {
        return finder.findAll();
    }

    @Transactional
    public Book findByISBN(String isbn) throws IOException {
        return finder.findByISBN(isbn);
    }

    @Transactional()
    public void save(Book book) throws IOException {
        finder.save(book);
        throw new IOException();
    }

    @Transactional
    public void update(Book book) throws IOException {
        finder.update(book);
    }

}
