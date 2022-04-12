package com.ungdungmuonsach.service.impl;

import com.ungdungmuonsach.model.Book;
import com.ungdungmuonsach.repository.IBookRepository;
import com.ungdungmuonsach.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    IBookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void remove(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book findByCode(Long code) {
        return bookRepository.findByCode(code);
    }
}
