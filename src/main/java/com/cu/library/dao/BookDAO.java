package com.cu.library.dao;

import com.cu.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.validation.constraints.NotBlank;
import java.util.List;

public interface BookDAO extends JpaRepository<Book,Integer> {

    public List<Book> findByNameLikeOrPublisherLikeOrAuthorLikeIgnoreCase(
            String name, String author, String publisher);
    public List<Book> findAllByOrderByName();
    public List<Book> findByNameOrderByName(String name);
    public List<Book> findByAuthorOrderByName(String name);
    public List<Book> findByPublisherOrderByName(String name);
}
