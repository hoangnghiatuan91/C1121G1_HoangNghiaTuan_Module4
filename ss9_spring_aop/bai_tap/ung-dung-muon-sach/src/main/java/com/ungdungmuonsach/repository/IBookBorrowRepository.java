package com.ungdungmuonsach.repository;

import com.ungdungmuonsach.model.BookBorrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookBorrowRepository extends JpaRepository<BookBorrow,Long> {
    BookBorrow findByCode(Long code);
}
