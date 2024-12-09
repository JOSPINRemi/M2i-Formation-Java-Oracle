package org.example;

import org.example.ihm.Console;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Calculator add = (a, b) -> a + b;
        Calculator subtract = (a, b) -> a - b;
        Calculator multiply = (a, b) -> a * b;
        Calculator divide = (a, b) -> a / b;

        Map<String, Calculator> operations = new HashMap<>();
        operations.put("add", add);
        operations.put("subtract", subtract);
        operations.put("multiply", multiply);
        operations.put("divide", divide);

//        System.out.println(operations.get("add").calculate(10, 10));

        Console console = new Console(operations);
        console.start();
    }
}