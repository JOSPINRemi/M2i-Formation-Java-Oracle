package org.example.IHM;

import org.example.Animal;
import org.example.Bird;
import org.example.Mammal;

import java.util.Scanner;

public class ConsoleMenu {
    private Scanner scanner;
    private ZooManager zooManager;

    public ConsoleMenu() {
        this.scanner = new Scanner(System.in);
        this.zooManager = new ZooManager();
    }

    public void start() {
        menu();
    }

    private void menu() {
        int choice;
        do {
            System.out.println("=== Menu Zoo ===");
            System.out.println("1. Ajouter un animal");
            System.out.println("2. Lister les animaux");
            System.out.println("3. Déplacer un animal");
            System.out.println("4. Nourrir les animaux");
            System.out.println("5. Quitter");
            choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Choix : " + choice);
            switch (choice) {
                case 1 -> {
                    System.out.println("Choisir le type d'animal\n 1. Mammifère\n 2. Oiseau");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Entrez le nom de l'animal : ");
                    String name = scanner.nextLine();
                    System.out.print("Entez l'espèce : ");
                    String specie = scanner.nextLine();
                    System.out.println(zooManager.getEnclosures());
                    System.out.print("Choix de l'enclos : ");
                    System.out.println(zooManager.getEnclosures());
                    int enclosure = scanner.nextInt();
                    scanner.nextLine();
                    Animal animal = choice == 1 ? new Mammal(1, name, specie) : new Bird(1, name, specie);
                    zooManager.addAnimal(animal, enclosure);
                }
                case 2 -> {

                }
                case 3 -> {

                }
                case 4 -> {
                    throw new RuntimeException("Option pas encore implémentée");
                }
                case 5 -> {

                }
                default -> {
                    System.out.println("Choix invalide");
                }
            }
            System.out.println();

        }while (choice != 5);
    }
}
