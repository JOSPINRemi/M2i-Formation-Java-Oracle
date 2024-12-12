package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //region Exercice 1
        /*Scanner sc = new Scanner(System.in);
        boolean correct = false;
        while (!correct) {
            System.out.println("Saisir un entier positif :");
            String chaineDeCaracteres = sc.nextLine();
            try {
                int entier = Integer.parseInt(chaineDeCaracteres);
                //region Exercice 2
                if (entier < 0)
                    throw new NumberFormatException("L'entier doit être positif");
                correct = true;
                System.out.println(Math.sqrt(entier));
                //endregion
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }*/
        //endregion

        //region Exercice 3
        /*int[] tableau = {1, 2, 3, 4, 5};
        Scanner sc2 = new Scanner(System.in);
        boolean valide = false;
        do {
            System.out.println("Vous avez un tableau de 5 entiers\nÀ quel élément du tableau voulez-vous accèder ?");
            try {
                String  n = sc2.nextLine();
                int nEntier = Integer.parseInt(n);
                System.out.println("L'élément à l'indice " + nEntier + " est " + tableau[nEntier]);
                valide = true;
            } catch (NumberFormatException e) {
                System.out.println("La saisie doit être un entier.");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("L'entier saisi n'est pas valide.");
            }
        } while (!valide);*/
        //endregion

        //region Exercice 4
        List<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            try {
                System.out.println("Menu\n1.Ajouter un étudiant\n2.Lister les étudiants\n3.Quitter");
                String stringChoice = scanner.nextLine();
                choice = Integer.parseInt(stringChoice);
                switch (choice) {
                    case 1 -> {
                        System.out.print("Saisir un nom : ");
                        String nom = scanner.nextLine();
                        System.out.print("Saisir un age : ");
                        String stringAge = scanner.nextLine();
                        int age = Integer.parseInt(stringAge);
                        if (age < 0)
                            throw new InvalidAgeException();
                        Student student = new Student(nom, age);
                        System.out.println(student);
                        students.add(student);
                    }
                    case 2 -> {
                        System.out.println(students);
                    }
                    case 3 -> {
                        return;
                    }
                    default -> System.out.println("Invalid choice");
                }
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            } catch (InvalidAgeException e) {
                System.out.println("L'âge doit être un entier positif");
            }
        }
        //endregion
    }
}