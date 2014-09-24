package com.clover.training.model;

import javax.persistence.*;

@Entity
@Table(name="t_book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private long id;
    @Column(name = "ISBN", length = 25)
    private String isbn;
    @Column(name = "NAME", length = 50)
    private String name;
    @Column(name = "AUTHOR", length = 50)
    private String author;

    public Book() {
    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public Book(String isbn, String name, String author) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean wroteBy(String author) {
        return this.author.equals(author);
    }

    public String print() {
        return isbn + ", " + name + ", " + author + ";";
    }
}
