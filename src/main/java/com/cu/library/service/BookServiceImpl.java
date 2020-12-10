package com.cu.library.service;

import com.cu.library.dao.BookDAO;
import com.cu.library.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookDAO bookDAO;

    @Override
    public List<Book> getAllBooks(){
        return bookDAO.findAllByOrderByName();
    }

    @Override
    public Book getBook(int id){
        Optional<Book> result = bookDAO.findById(id);

        Book book = null;

        if (result.isPresent()) {
            book = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + id);
        }

        return book;
    }

    @Override
    public void saveBook(Book book){
        bookDAO.save(book);
    }


    @Override
    public void deleteBookById(int id){
        bookDAO.deleteById(id);
    }

    @Override
    public List<Book> searchByNameAuthorPublisher(String theFirstName,String author,String publisher) {
        System.out.println(theFirstName);
        System.out.println(author);
        System.out.println(publisher);
       // return bookDAO.findByName("Giorgi");
        return bookDAO.
                findByNameLikeOrPublisherLikeOrAuthorLikeIgnoreCase(theFirstName,author,publisher
                        );
    }

    @Override
    public List<Book> searchByName(String theFirstName) {
        return bookDAO.findByNameOrderByName(theFirstName);
    }

    @Override
    public List<Book> searchByAuthor(String author) {
        return bookDAO.findByAuthorOrderByName(author);
    }

    @Override
    public List<Book> searchByPublisher(String publisher) {
        return bookDAO.findByPublisherOrderByName(publisher);
    }

}
