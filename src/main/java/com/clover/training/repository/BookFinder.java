package com.clover.training.repository;

import com.clover.training.model.Book;

import java.io.IOException;
import java.util.List;

public interface BookFinder {

    List<Book> findAll() throws IOException;

}
