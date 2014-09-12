package com.clover.training.controller;

import com.clover.training.model.Book;
import com.clover.training.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(ModelMap model) throws IOException {
        List<Book> books = bookService.listBooks();
        StringBuilder sb = new StringBuilder();
        for (Book book : books) {
            sb.append(book.print());
        }
        model.addAttribute("books", sb.toString());
        return "book";
    }

}
