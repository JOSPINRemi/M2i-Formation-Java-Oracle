package com.inventory;

import com.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookInventory {
    private List<Book> inventory;

    public BookInventory() {
        inventory = new ArrayList<>();
    }

    public List<Book> getInventory() {
        return inventory;
    }

    public void setInventory(List<Book> inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "BookInventory{" +
                "inventory=" + inventory +
                '}';
    }

    public boolean addBook(Book book) {
        return inventory.add(book);
    }

    public boolean removeBook(Book book) {
        return inventory.remove(book);
    }
}