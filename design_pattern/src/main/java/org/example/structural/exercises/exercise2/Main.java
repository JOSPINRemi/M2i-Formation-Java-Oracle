package org.example.structural.exercises.exercise2;

public class Main {
    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();

        CurrencyAdapter currencyAdapter = new CurrencyConverterAdapter(converter);

        System.out.println("10€ to USD " + currencyAdapter.convert("EUR", "USD", 10));
    }
}
