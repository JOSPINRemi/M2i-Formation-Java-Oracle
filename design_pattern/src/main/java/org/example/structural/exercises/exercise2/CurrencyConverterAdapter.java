package org.example.structural.exercises.exercise2;

public class CurrencyConverterAdapter implements CurrencyAdapter {
    private CurrencyConverter converter;

    public CurrencyConverterAdapter(CurrencyConverter converter) {
        this.converter = converter;
    }

    @Override
    public double convert(String fromCurrency, String toCurrency, double amount) {
        double amountInUSD = converter.convertToUSD(fromCurrency, amount);
        return converter.convertFromUSD(toCurrency, amountInUSD);
    }
}
