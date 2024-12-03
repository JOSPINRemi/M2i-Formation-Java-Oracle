package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*System.out.println("Ajout des éléments à la bibliothèque...");
        List<LibraryItem> library = new ArrayList<>(
                Arrays.asList(
                        new Book(1, "Effective Java", 2018, "Joshua Bloch", "Programmation"),
                        new Magazine(2, "National Geographic", 2023, 42)
                )
        );

        System.out.println("Liste des éléments disponibles :");
        for (LibraryItem libraryItem : library) {
            System.out.println(libraryItem.getDetails());
        }

        System.out.println("Emprunt d'un élément...");
        List<BorrowRecord> borrowRecords = List.of(new BorrowRecord(1, "John Doe", "2024-12-01"));
        System.out.println(borrowRecords);

        System.out.println("Liste des éléments empruntés");


        System.out.println("Liste des éléments disponibles");*/

        Library lib = new Library();
        lib.addItem(new Book(1, "Vingt Mille Lieues sous les mers", 1869, "Jules Verne", "Roman d'aventures"));
        lib.addItem(new Magazine(2, "Science et Vie", 2024, 42));

//        Liste éléments dispos
        System.out.println("Liste des éléments dispos :");
        lib.listAvailableItems();

//        Emprunter un élément
        System.out.println("Emprunt d'un élément ...");
        BorrowRecord record = lib.borrowItem(1, "John Doe", "2024-12-03");
        System.out.println(record);

//        Liste éléments empruntés
        System.out.println("Liste des éléments empruntés :");
        lib.listBorrowedItems();

//        Liste éléments dispos
        System.out.println("Liste des éléments dispos :");
        lib.listAvailableItems();
    }
}