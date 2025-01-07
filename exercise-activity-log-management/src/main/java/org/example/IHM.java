package org.example;

import java.util.Scanner;

public class IHM {
    private static Scanner sc;

    public static void start() {
        sc = new Scanner(System.in);
        int choice;

        while (true) {
            menu();

            System.out.print("Choisissez une option : ");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 5) {
                return;
            }

            FileHandler.initialize();
            switch (choice) {
                case 1 -> {
                    System.out.print("Entrez une description de l'activité : ");
                    FileHandler.addActivity(sc.nextLine());
                    System.out.println("Activité ajoutée avec succès !");
                }
                case 2 -> {
                    FileHandler.readActivities();
                    System.out.println();
                }
                case 3 -> {
                    String binaryFilePath = "journal_backup.dat";
                    if (FileHandler.saveToBinary(binaryFilePath)) {
                        System.out.println("Journal sauvegardé en binaire dans : " + binaryFilePath);
                    }
                }
                case 4 -> {
                    String binaryFilePath = "journal_backup.dat";
                    FileHandler.readFromBinary(binaryFilePath);
                    System.out.println();
                }
                default -> System.out.println("Choix incorrect");
            }
        }
    }

    private static void menu() {
        System.out.println("--- Menu ---");
        System.out.println("1. Ajouter une activité");
        System.out.println("2. Afficher les activités");
        System.out.println("3. Sauvegarder en binaire");
        System.out.println("4. Lire le fichier");
        System.out.println("5. Quitter");
    }
}
