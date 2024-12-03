package org.example;

public class BorrowRecord {
    private int itemId;
    private String borrowerName;
    private String borrowDate;

    public BorrowRecord(int itemId, String borrowerName, String borrowDate) {
        this.itemId = itemId;
        this.borrowerName = borrowerName;
        this.borrowDate = borrowDate;
    }
}
