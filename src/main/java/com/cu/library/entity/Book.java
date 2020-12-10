package com.cu.library.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotBlank(message="აუცილებელი ველია")
    private String name;

    @Column(name = "author")
    @NotBlank(message="აუცილებელი ველია")
    private String author;

    @Column(name = "language")
    private String language;

    @Column(name = "genre")
    private String genre;

    @Column(name = "date")
    private String date;

    @Column(name = "publisher")
    private String publisher;

    public Book() {
    }

    public Book(int id, @NotBlank(message = "აუცილებელი ველია") String name, @NotBlank(message = "აუცილებელი ველია") String author, String language, String genre, String date, String publisher) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.language = language;
        this.genre = genre;
        this.date = date;
        this.publisher = publisher;
    }

    public Book(int id, String name, String author, String language, String date, String publisher) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.language = language;
        this.date = date;
        this.publisher = publisher;
    }

    public Book(String name, String author, String language, String date, String publisher) {

        this.name = name;
        this.author = author;
        this.language = language;
        this.date = date;
        this.publisher = publisher;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", language='" + language + '\'' +
                ", genre='" + genre + '\'' +
                ", date='" + date + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
