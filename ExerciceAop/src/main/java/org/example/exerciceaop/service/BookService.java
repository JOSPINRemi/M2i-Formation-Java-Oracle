package org.example.exerciceaop.service;

import org.example.exerciceaop.annotation.Exception;
import org.example.exerciceaop.annotation.Log;
import org.example.exerciceaop.annotation.Performance;
import org.example.exerciceaop.entity.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private List<Book> books;

    public BookService() {
        books = new ArrayList<>();
    }

    @Log
    @Performance
    public Boolean createBook(Book book) {
        return books.add(book);
    }

    @Log
    @Performance
    @Exception
    public List<Book> getBooks() {
        //region Test Exception
//        books = null;
        //endregion
        if (books == null)
            throw new RuntimeException("Books array is null");
        return books;
    }

    @Log
    @Performance
    @Exception
    public Boolean deleteBookById(int bookId) {
        Book searchedBook = books.stream()
                .filter(book -> book.getId() == bookId)
                .findFirst()
                .orElse(null);
        if(searchedBook == null)
            throw new RuntimeException("Cannot find Book with id " + bookId);
        return books.remove(searchedBook);
    }
}
