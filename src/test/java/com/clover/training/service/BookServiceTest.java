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
    public static final String ISBN = "9787111446231";

    @Test
    public void should_return_books_by_given_author() throws IOException {
        String author = "David Herman";

        List<Book> books = bookService.findBooksWroteBy(author);

        assertThat(books.size(), is(1));
        assertThat(books.get(0).getAuthor(), is(author));
    }

    @Test
    public void should_return_books_by_isbn() throws IOException {
        Book book = bookService.findByISBN(ISBN);

        assertThat(book.getAuthor(), is("David Herman"));
    }

    @Test(expected = RuntimeException.class)
    public void should_save_book() throws Exception {
        String bookName = "clover";
        String isbn = "123";

        try {
            bookService.save(newBook(isbn, bookName, "test"));
        } catch (IOException e) {

        }

        assertThat(bookService.findByISBN(isbn).getName(), is(bookName));
    }

    private Book newBook(String isbn, String bookName, String author) {
        return new Book(isbn, bookName, author);
    }

}
