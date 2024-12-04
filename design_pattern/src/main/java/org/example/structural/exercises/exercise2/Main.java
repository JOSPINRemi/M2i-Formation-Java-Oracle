package org.example.structural.exercises.exercise2;

public class Main {
    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();

        CurrencyAdapter currencyAdapter = new CurrencyConverterAdapter(converter);

        System.out.println("100€ en GBP : " + currencyAdapter.convert("EUR", "GBP", 100));

        System.out.println("60 GBP en USD : " + currencyAdapter.convert("GBP", "USD", 60));
    }
}
