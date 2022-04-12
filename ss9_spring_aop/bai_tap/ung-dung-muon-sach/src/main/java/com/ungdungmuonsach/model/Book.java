package com.ungdungmuonsach.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameOfBook;
    private String typeOfBook;
    private Integer quantity;
    @OneToMany(mappedBy = "book")
    private Set<BookBorrow> bookBorrows;

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfBook() {
        return nameOfBook;
    }

    public void setNameOfBook(String nameOfBook) {
        this.nameOfBook = nameOfBook;
    }

    public String getTypeOfBook() {
        return typeOfBook;
    }

    public void setTypeOfBook(String typeOfBook) {
        this.typeOfBook = typeOfBook;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Set<BookBorrow> getBookBorrows() {
        return bookBorrows;
    }

    public void setBookBorrows(Set<BookBorrow> bookBorrows) {
        this.bookBorrows = bookBorrows;
    }
}
