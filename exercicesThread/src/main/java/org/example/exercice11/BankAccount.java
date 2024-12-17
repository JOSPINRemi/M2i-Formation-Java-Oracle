package org.example.exercice11;

public class BankAccount {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (balance <= amount) {
            throw new RuntimeException("solde insuffisant");
        }
        balance -= amount;
        return true;
    }
}
