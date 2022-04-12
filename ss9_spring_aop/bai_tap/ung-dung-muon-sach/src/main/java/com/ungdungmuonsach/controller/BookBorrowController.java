package com.ungdungmuonsach.controller;

import com.ungdungmuonsach.model.Book;
import com.ungdungmuonsach.model.BookBorrow;
import com.ungdungmuonsach.service.IBookBorrowService;
import com.ungdungmuonsach.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/borrow-and-return")
public class BookBorrowController {
    @Autowired
    private IBookBorrowService bookBorrowService;

    @Autowired
    private IBookService bookService;

    @PostMapping("/borrow-book")
    public ModelAndView borrow(@ModelAttribute Book book) throws Exception {
        if (book.getQuantity() > 0) {
            Long codeBorrow = (long) (Math.random() * 100000);
            BookBorrow bookBorrow = new BookBorrow(codeBorrow, book);
            bookBorrowService.save(bookBorrow);
            book.setQuantity(book.getQuantity() - 1);
            bookService.save(book);
            ModelAndView modelAndView = new ModelAndView("book/list");
            modelAndView.addObject("books", bookService.findAll());
            modelAndView.addObject("message", "Borrow successfully. Your borrow code is: " + codeBorrow);
            return modelAndView;
        } else {
            throw new Exception("Error");
        }
    }

        @GetMapping("/return/{id}")
    public ModelAndView showFormReturnBook (@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("borrow/index");
        modelAndView.addObject("bookBorrow", bookBorrowService.findById(id));
        return modelAndView;
    }

    @GetMapping("/return-book")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("borrow/list");
        modelAndView.addObject("bookBorrows", bookBorrowService.findAll());
        return modelAndView;
    }

    @PostMapping("")
    public String returnBook(@ModelAttribute BookBorrow bookBorrow, RedirectAttributes redirectAttributes) throws Exception {
        BookBorrow bookBorrow1 = bookBorrowService.findByCode(bookBorrow.getBorrowCode());
        if (bookBorrow1 != null) {
            Book book = bookService.findByCode(bookBorrow1.getBook().getId());
            book.setQuantity(book.getQuantity() + 1);
            bookService.save(book);
            bookBorrowService.remove(bookBorrow.getBorrowCode());
        } else {
            throw new Exception("Error");
        }
        redirectAttributes.addFlashAttribute("message", "Book returning successfully");
        return "redirect:/book";
    }

    @ExceptionHandler
    public String showErrorPage() {
        return "error";
    }

}