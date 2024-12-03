package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<LibraryItem> library = new ArrayList<>(
                Arrays.asList(
                        new Book(1, "Effective Java", 2018, "Joshua Bloch", "Programmation"),
                        new Magazine(2, "National Geographic", 2023, 42)
                )
        );
        System.out.println("Ajout des éléments à la bibliothèque...");
        System.out.println("Liste des éléments disponibles :");
        for (LibraryItem libraryItem : library) {
            System.out.println(libraryItem.getDetails());
        }
        System.out.println("Emprunt d'un élément...");
    }
}