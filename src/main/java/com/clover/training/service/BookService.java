package com.clover.training.service;

import com.clover.training.model.Book;
import com.clover.training.repository.BookFinder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookService {

    private BookFinder finder;

    public void setFinder(BookFinder finder) {
        this.finder = finder;
    }

    public List<Book> findBooksWroteBy(String author) throws IOException {
        List<Book> result = new ArrayList<Book>();
        for (Book book : finder.findAll()) {
            if (book.wroteBy(author)) {
                result.add(book);
            }
        }
        return result;
    }

}
