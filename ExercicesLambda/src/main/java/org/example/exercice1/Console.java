package org.example.exercice1.ihm;

import org.example.exercice1.Calculator;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

public class Console {
    private Scanner scanner;
    private Map<String, Calculator> operations;
    private Consumer<String> printMessage;

    public Console(Map<String, Calculator> operations) {
        this.scanner = new Scanner(System.in);
        this.operations = operations;
        this.printMessage = message -> System.out.println(message);
    }

    public void start(){
        while (true){
            int choice = 1;
            printMessage.accept("Menu");
            for (String operation : operations.keySet()) {
                printMessage.accept(choice + ". " + operation);
                choice++;
            }
            printMessage.accept(choice + ". exit");
            printMessage.accept("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            int firstNumber, secondNumber;
            switch (choice) {
                case 1 -> {
                    firstNumber = enterNumber("Enter first number :");
                    secondNumber = enterNumber("Enter second number :");
                    printMessage.accept(firstNumber + " + " + secondNumber + " = " + operations.get("add").calculate(firstNumber, secondNumber) + "\n");
                }
                case 2 -> {
                    firstNumber = enterNumber("Enter first number :");
                    secondNumber = enterNumber("Enter second number :");
                    printMessage.accept(firstNumber + " - " + secondNumber + " = " + operations.get("subtract").calculate(firstNumber, secondNumber) + "\n");
                }
                case 4 -> {
                    firstNumber = enterNumber("Enter first number :");
                    secondNumber = enterNumber("Enter second number :");
                    printMessage.accept(firstNumber + " * " + secondNumber + " = " + operations.get("multiply").calculate(firstNumber, secondNumber) + "\n");
                }
                case 3 -> {
                    firstNumber = enterNumber("Enter first number :");
                    secondNumber = enterNumber("Enter second number :");
                    printMessage.accept(firstNumber + " / " + secondNumber + " = " + operations.get("divide").calculate(firstNumber, secondNumber) + "\n");
                }
                case 5 -> {
                    printMessage.accept("Goodbye");
                    return;
                }
                default -> printMessage.accept("Invalid choice");
            }
        }
    }

    private int enterNumber(String message){
        printMessage.accept(message);
        int n = scanner.nextInt();
        scanner.nextLine();
        return n;
    }
}
