package com.ungdungmuonsach.service.impl;

import com.ungdungmuonsach.model.BookBorrow;
import com.ungdungmuonsach.repository.IBookBorrowRepository;
import com.ungdungmuonsach.service.IBookBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookBorrowService implements IBookBorrowService {
    @Autowired
    IBookBorrowRepository borrowRepository;

    @Override
    public List<BookBorrow> findAll() {
        return borrowRepository.findAll();
    }

    @Override
    public Optional<BookBorrow> findById(Long id) {
        return borrowRepository.findById(id);
    }

    @Override
    public void save(BookBorrow bookBorrow) {
        borrowRepository.save(bookBorrow);
    }

    @Override
    public void remove(Long id) {
        borrowRepository.deleteById(id);
    }

    @Override
    public BookBorrow findByCode(Long code) {
        return borrowRepository.findByCode(code);
    }
}
