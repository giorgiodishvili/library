package com.cu.library.service;

import com.cu.library.entity.Book;

import java.util.List;

public interface BookService {


        public List<Book> getAllBooks();

        public Book getBook(int theId);

        public void saveBook(Book theEmployee);

        public void deleteBookById(int theId);

        public List<Book> searchByNameAuthorPublisher(String theFirstName,String author,String publisher);
        public List<Book> searchByName(String theFirstName);
        public List<Book> searchByAuthor(String author);
        public List<Book> searchByPublisher(String publisher);



}
