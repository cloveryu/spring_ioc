package com.clover.training.service;

import com.clover.training.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    public void should_return_books_by_given_author() throws IOException {
        String author = "David Herman";

        List<Book> books = bookService.findBooksWroteBy(author);

        assertThat(books.size(), is(1));
        assertThat(books.get(0).getAuthor(), is(author));
    }

}
