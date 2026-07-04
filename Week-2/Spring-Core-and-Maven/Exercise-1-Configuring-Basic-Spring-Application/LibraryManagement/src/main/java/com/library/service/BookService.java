package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayAvailableBooks() {
        System.out.println("Available books:");
        bookRepository.findAllBooks().forEach(book -> System.out.println("- " + book));
    }
}
