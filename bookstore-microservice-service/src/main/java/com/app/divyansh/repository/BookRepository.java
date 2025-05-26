package com.app.divyansh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.divyansh.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
