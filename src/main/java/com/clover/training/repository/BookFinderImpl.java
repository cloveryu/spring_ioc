package com.clover.training.repository;

import com.clover.training.model.Book;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.util.List;

public class BookFinderImpl implements BookFinder {

    private SessionFactory sessionFactory;

    public BookFinderImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Book> findAll() throws IOException {
        return sessionFactory.getCurrentSession().createCriteria(Book.class).list();
    }

    @Override
    public Book findByISBN(String isbn) throws IOException {
        String hql = "from Book b where b.isbn = :isbn";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("isbn", isbn);
        return (Book) query.list().get(0);
    }

    @Override
    public void save(Book book) throws IOException {
        sessionFactory.getCurrentSession().save(book);
    }

    @Override
    public void update(Book book) throws IOException {
        sessionFactory.getCurrentSession().update(book);
    }

}
