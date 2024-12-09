package org.example.exercice2;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductFilter stockFilter = p -> p.getQuantity() > 0;
        ProductFilter findByNameFilter = p -> p.getName().equals("Laptop");

        ProductTransform increasePrice = p -> {
            p.setPrice(p.getPrice() + 1);
            return p;
        };
        ProductTransform decreasePrice = p ->{
            p.setPrice(p.getPrice() - 1);
            return p;
        };
        ProductTransform increaseStock = p -> {
            p.setQuantity(p.getQuantity() + 1);
            return p;
        };
        ProductTransform decreaseStock = p ->{
            p.setQuantity(p.getQuantity() - 1);
            return p;
        };

        ProductOperation operations = p -> {
            decreasePrice.transform(p).setName("Prefix_" + p.getName());
            return p;
        };

        Product product = new Product("Laptop", 1250, 40);
        Product product1 = new Product("Desk", 1250, 0);
        List<Product> products = Arrays.asList(product, product1);
        products.forEach(System.out::println);
        for (Product p : products) {
            System.out.println("Product in stock : " + stockFilter.filter(p));
        }
        for (Product p : products) {
            System.out.println("Product named Laptop : " + findByNameFilter.filter(p));
        }
        System.out.println("Increase product price : " + increasePrice.transform(product));
        System.out.println("Decrease product price : " + decreasePrice.transform(product));
        System.out.println("Increase stock : " + increaseStock.transform(product));
        System.out.println("Decrease stock : " + decreaseStock.transform(product));
        System.out.println("Operations : " + operations.execute(product));
    }
}
