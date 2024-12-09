package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Pomme", "Banane", "Orange", "Fraise");
        fruits.sort((f1, f2) -> f1.compareTo(f2));
//        fruits.sort(String::compareTo);
        System.out.println("Liste triée : " + fruits);

//        Function
        Function<String, Integer> stringLengthFunction = str -> str.length();
//        Function<String, Integer> stringLengthFunction = String::length;

        String input = "Bonjour";
        int length = stringLengthFunction.apply(input);
        System.out.println("Longueur de \"" + input + "\" : " + length);

//        Consumer
        Consumer<String> printMessage = message -> System.out.println("Message : " + message);
        printMessage.accept("Ceci est un test");

//        Predicate
        Predicate<Integer> isEven = number -> number % 2 == 0;

        int testNumber = 4;
        if (isEven.test(testNumber)) {
            printMessage.accept(testNumber + " est pair");
        }
        else {
            printMessage.accept(testNumber + " est impair");
        }

//        Supplier
        Supplier<Integer> randomSupplier = () -> new Random().nextInt(100);
        System.out.println("Nombre aléatoire : " + randomSupplier.get());

        int test = randomSupplier.get();
        if (isEven.test(testNumber)) {
            printMessage.accept(test + " est pair");
        }
        else {
            printMessage.accept(test + " est impair");
        }
    }
}