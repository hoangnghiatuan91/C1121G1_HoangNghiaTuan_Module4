package com.ungdungmuonsach.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BookBorrow {

    @Id
    private Long borrowCode;

    @ManyToOne(targetEntity =  Book.class)
    @JoinColumn(name = "id_book", referencedColumnName = "id")
    private Book book;

    public BookBorrow() {
    }

    public BookBorrow(Long codeBorrow, Book book) {
        this.borrowCode = codeBorrow;
        this.book = book;
    }

    public Long getBorrowCode() {
        return borrowCode;
    }

    public void setBorrowCode(Long borrowCode) {
        this.borrowCode = borrowCode;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
