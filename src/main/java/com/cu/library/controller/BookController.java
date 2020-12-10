package com.cu.library.controller;

import com.cu.library.entity.Book;
import com.cu.library.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookServiceImpl bookServiceImpl;

    @GetMapping("/list")
    public String showAll(Model model) {
        List<Book> allBooks = bookServiceImpl.getAllBooks();

        model.addAttribute("books", allBooks);

        return "book-list";
    }

    @GetMapping("showFormForUpdate")
    public String showFormForUpdate(@RequestParam("bookId")int id, Model model){
        Book book = bookServiceImpl.getBook(id);

        model.addAttribute("book",book);

        return "book-form";
    }

    @GetMapping("showFormForAdd")
    public String showFormForAdd(Model model){
        Book book = new Book();

        model.addAttribute("book",book);

        return "book-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("book") @Valid Book book,
                       BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            return "book-form";
        } else {
            bookServiceImpl.saveBook(book);

            return "redirect:/books/list";
        }
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("bookId") int theId) {

        // delete the employee
        bookServiceImpl.deleteBookById(theId);

        // redirect to /employees/list
        return "redirect:/books/list";

    }

    @GetMapping("/search")
    public String search(@RequestParam("name") String theFirstName,
                         @RequestParam("author") String author,
                         @RequestParam("publisher") String publisher,
                         Model theModel) {



        if (theFirstName.trim().isEmpty() && author.trim().isEmpty() && publisher.trim().isEmpty()) {
            System.out.println("isempty");
            return "redirect:/books/list";
        }
        else if(author.trim().isEmpty() && publisher.trim().isEmpty()) {
            List<Book> books =
                    bookServiceImpl.searchByName(theFirstName);
            System.out.println(books);
            // add to the spring model
            theModel.addAttribute("books", books);

            // send to list-employees
            return "book-list";

        }
        else if(theFirstName.trim().isEmpty() && author.trim().isEmpty()) {
            List<Book> books =
                    bookServiceImpl.searchByPublisher(publisher);
            System.out.println(books);
            // add to the spring model
            theModel.addAttribute("books", books);

            // send to list-employees
            return "book-list";

        }
        else if(theFirstName.trim().isEmpty() &&publisher.trim().isEmpty()) {
            List<Book> books =
                    bookServiceImpl.searchByAuthor(author);
            System.out.println(books);
            // add to the spring model
            theModel.addAttribute("books", books);

            // send to list-employees
            return "book-list";

        }
        else{
            // else, search by first name and last name
            List<Book> books =
                    bookServiceImpl.searchByNameAuthorPublisher(theFirstName,author,publisher);
            System.out.println(books);
            // add to the spring model
            theModel.addAttribute("books", books);

            // send to list-employees
            return "book-list";
        }

    }
}
