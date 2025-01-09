package org.example.hci;

import org.example.entities.Character;
import org.example.utils.BinaryFileHandler;

import java.util.Scanner;

public class CLI {
    private static Scanner scanner;
    private static org.example.entities.Character character;
    private static String RESOURCES_PATH = "src/main/resources/";
    private static String CHARACTER_FILE_NAME = "characters.dat";
    private static String MONSTER_FILE_NAME = "monsters.txt";
    private static String EVENTS_FILE_NAME = "events.txt";
    private static String JOURNAL_FILE_NAME = "journal.txt";

    public static void start() {
        init();
        int choice;
        while (true) {
            menu();
            System.out.print("Choisissez une option : ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    createCharacter();
                    return;
                }
                case 2 -> {
                    loadCharacter();
                    return;
                }
                default -> {
                    System.out.println(
                            """
                                    Choix invalide
                                    Réessayer
                                    """
                    );
                }
            }
        }
    }


    private static void loadCharacter() {
        System.out.println("");
    }

    private static void createCharacter() {
        System.out.print("Entrez le nom de votre héros : ");
        String name = scanner.nextLine();
        System.out.print("Entrez la force (1-100) : ");
        int strength = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Entrez la santé (1-100) : ");
        int health = scanner.nextInt();
        scanner.nextLine();
        character = new Character(name, strength, health);
        if (character == null) {
            throw new RuntimeException("Problème lors de la création du personnage");
        }
        BinaryFileHandler.write(RESOURCES_PATH + CHARACTER_FILE_NAME, character);
        System.out.println("Personnage créé avec succès et sauvegardé.");
    }

    private static void menu() {
        System.out.println(
                """
                        --- Bienvenue dans le jeu d'aventure textuelle ! ---
                        1. Créer un nouveau personnage
                        2. Charger un personnage existant
                        """
        );
    }

    private static void init() {
        scanner = new Scanner(System.in);
    }
}
