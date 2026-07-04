package com.chezsan.LibraryManagement.Controller;

import com.chezsan.LibraryManagement.Model.Book;
import com.chezsan.LibraryManagement.Repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController()
public class BookController {
    @Autowired
    BookRepo repo;

    @GetMapping("load")
    public String loadBooks (){
        List<Book> books = new ArrayList<>();
        Collections.addAll(books,
                new Book("Programming in java"),
                new Book("Spring Fundamentals"),
                new Book("How to focus in studies"));

        repo.saveAll(books);

        return "Successfully loaded books";
    }

    @GetMapping("book")
    public List<Book> getBooks(){
        return repo.findAll();
    }

    @PostMapping("book")
    public void addBook(@RequestBody Book book){
        repo.save(book);
        System.out.println("Put method called");
    }

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable int id){
        return repo.findById(id).orElse(new Book());
    }

    @DeleteMapping("/book/{id}")
    public String deleteBook(@PathVariable int id){
        repo.deleteById(id);
        return "Deleted book succesfully";
    }

    
}
