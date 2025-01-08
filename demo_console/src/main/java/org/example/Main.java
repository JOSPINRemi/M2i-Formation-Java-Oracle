package org.example;

import java.io.Console;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Démonstration Console");

//        Obtenir une instance de Console
        Console console = System.console();

        if (console == null) {
            System.out.println("No console available");
            return;
        }

//        Lire une entrée utilisateur
        String username = console.readLine("Username: ");

//        Lire un mot de passe
        char[] password = console.readPassword("Password: ");

//        Affichage
        console.printf("%s\n", username);

//        Nettoyer les données sensibles
        Arrays.fill(password, ' ');
    }
}