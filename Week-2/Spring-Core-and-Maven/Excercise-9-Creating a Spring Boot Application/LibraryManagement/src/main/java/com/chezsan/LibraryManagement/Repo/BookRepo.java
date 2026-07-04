package com.chezsan.LibraryManagement.Repo;

import com.chezsan.LibraryManagement.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Integer> {

}
