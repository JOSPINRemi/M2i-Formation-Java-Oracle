package org.example.exerciceaop.controller;

import org.example.exerciceaop.entity.Book;
import org.example.exerciceaop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<?> createBook() {
        bookService.createBook(
                new Book(
                        "Les Aventures d'Alice au pays des merveilles",
                        "Lewis Carroll",
                        "Fantastique"
                )
        );
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<?> getAllBooks() {
        return ResponseEntity.ok(bookService.getBooks());
    }

    @DeleteMapping
    public ResponseEntity<?> deleteBook() {
        int bookId = 1;
        bookService.deleteBookById(bookId);
        return ResponseEntity.ok().build();
    }
}
