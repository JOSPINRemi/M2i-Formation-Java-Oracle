package com.main;

import com.checkout.CheckoutSystem;
import com.entity.Book;
import com.inventory.BookInventory;
import com.reports.InventoryReport;

public class LibraryApp {
    public static void main(String[] args) {
        BookInventory bookInventory = new BookInventory();
        InventoryReport inventoryReport = new InventoryReport(bookInventory);
        Book book1 = new Book(1, "Book 1", "Author 1");
        if (bookInventory.addBook(book1)) {
            System.out.println("Book added successfully");
        }
        inventoryReport.displayInventoryReport();

        CheckoutSystem checkoutSystem = new CheckoutSystem();
        try {
            if (checkoutSystem.borrowBook(book1)) {
                System.out.println("Book borrowed successfully");
            }
            if (checkoutSystem.returnBook(book1)) {
                System.out.println("Book returned successfully");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}