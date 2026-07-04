package com.library.service;

import com.library.repository.BookRepository;

import javax.sound.midi.Soundbank;
import java.util.List;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("Setter method called");
    }
    public BookService (BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("Constructor called");
    }

    public void displayAvailableBooks() {
        System.out.println("Available books:");
        List<String> books = bookRepository.findAllBooks();
        for (int i = 0 ; i < books.size() ; i++) {
            System.out.println("- " + books.get(i));
        }
    }
}
