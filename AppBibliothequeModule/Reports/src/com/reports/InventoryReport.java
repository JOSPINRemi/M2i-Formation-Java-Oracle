package com.reports;

import com.inventory.BookInventory;

public class InventoryReport {
    private BookInventory inventory;

    public InventoryReport(BookInventory inventory) {
        this.inventory = inventory;
    }

    public void displayInventoryReport() {
        System.out.println(inventory);
    }
}