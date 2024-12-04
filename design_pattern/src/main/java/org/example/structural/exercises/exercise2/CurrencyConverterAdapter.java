package org.example.structural.exercises.exercise2;

public class CurrencyConverterAdapter implements CurrencyAdapter {
    private CurrencyConverter converter;

    public CurrencyConverterAdapter(CurrencyConverter converter) {
        this.converter = converter;
    }

    @Override
    public double convert(String fromCurrency, String toCurrency, double amount) {
        if (fromCurrency.equals("USD")) {
            return converter.convertFromUSD(toCurrency, amount);
        } else if (toCurrency.equals("USD")) {
            return converter.convertToUSD(fromCurrency, amount);
        }
        return amount;
    }
}
