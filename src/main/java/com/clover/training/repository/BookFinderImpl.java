package com.clover.training.repository;

import com.clover.training.model.Book;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

public class BookFinderImpl implements BookFinder {

    private SessionFactory sessionFactory;

    public BookFinderImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Book> findAll() throws IOException {
        return sessionFactory.getCurrentSession().createCriteria(Book.class).list();
    }
}
