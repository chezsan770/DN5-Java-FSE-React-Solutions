package com.library.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookRepository {
    public List<String> findAllBooks() {
        List<String> books = new ArrayList<>();
        books.add("Programming in java");
        books.add("Fundamentals of Spring Boot");
        books.add("Backend basics");
        return books;
    }
}
