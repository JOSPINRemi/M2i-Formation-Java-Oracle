package com.checkout;

import com.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class CheckoutSystem {
    private List<Book> borrowedBooks;

    public CheckoutSystem() {
        borrowedBooks = new ArrayList<>();
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    @Override
    public String toString() {
        return "CheckoutSystem{" +
                "borrowedBooks=" + borrowedBooks +
                '}';
    }

    public boolean borrowBook(Book book) {
        if (borrowedBooks.contains(book))
            throw new RuntimeException("Book already borrowed");
        return borrowedBooks.add(book);
    }

    public boolean returnBook(Book book) {
        if (!borrowedBooks.contains(book))
            throw new RuntimeException("Book not borrowed");
        return borrowedBooks.remove(book);
    }
}