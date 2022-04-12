package com.ungdungmuonsach.repository;

import com.ungdungmuonsach.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book,Long> {
    Book findByCode(Long code);
}
