package com.clover.training.repository;

import com.clover.training.model.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColonBookFinder implements BookFinder {

    private static final String COLON_BOOK_REG = "^(.+),(.+),(.+)$";
    private static final Pattern COLON_BOOK_PATTERN = Pattern.compile(COLON_BOOK_REG);
    private String bookFilePath;

    public ColonBookFinder(String path) {
        this.bookFilePath = path;
    }

    @Override
    public List<Book> findAll() throws IOException {
        InputStream bookStream = this.getClass().getClassLoader().getResourceAsStream(bookFilePath);
        BufferedReader br = new BufferedReader(new InputStreamReader(bookStream));
        String line;
        List<Book> books = new ArrayList<Book>();
        while ((line = br.readLine()) != null) {
            Matcher matcher = COLON_BOOK_PATTERN.matcher(line);
            if (matcher.find()) {
                books.add(new Book(matcher.group(1), matcher.group(2), matcher.group(3)));
            }
        }
        br.close();
        return books;
    }

    @Override
    public Book findByISBN(String isbn) throws IOException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void save(Book book) throws IOException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void update(Book book) throws IOException {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
