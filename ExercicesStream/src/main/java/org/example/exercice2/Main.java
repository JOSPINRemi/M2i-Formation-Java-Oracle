package org.example.exercice2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Liste de commandes
        List<Commande> commandes = Arrays.asList(
                new Commande(1, "Alice", Arrays.asList("Ordinateur", "Souris"), 1200.50, true),
                new Commande(2, "Bob", Arrays.asList("Clavier", "Écran"), 300.75, false),
                new Commande(3, "Charlie", Arrays.asList("Imprimante"), 150.00, true),
                new Commande(4, "Alice", Arrays.asList("USB", "Casque"), 75.50, false),
                new Commande(5, "Bob", Arrays.asList("Tablette"), 200.00, true)
        );

//        Question 1
        commandes
                .forEach(System.out::println);

//        Question 2
        commandes.stream()
                .map(Commande::getClient)
                .forEach(System.out::println);

//        Question 3
        System.out.println(
                commandes.stream()
                        .mapToDouble(Commande::getMontantTotal).sum()
        );

//        Question 4
        commandes
                .forEach(commande -> System.out.println(commande.getArticles() + " " + commande.getMontantTotal()));

//        Question 5
        commandes.stream()
                .filter(Commande::isEstLivree)
                .forEach(System.out::println);

//        Question 6
        commandes.stream()
                .collect(Collectors.groupingBy(
                        Commande::getClient, Collectors.summingDouble(Commande::getMontantTotal)
                ))
                .forEach((client, sommeMontantTotal) -> System.out.println(client + " : " + sommeMontantTotal));

//        Question 7
        System.out.println(commandes.stream()
                .map(Commande::getArticles)
                .distinct().toList());

//        Question 8
        System.out.println(
                commandes.stream()
                        .collect(Collectors.groupingBy(
                                Commande::getClient
                        ))
                        .entrySet().stream()
                        .allMatch(entry -> entry.getValue().stream()
                                .anyMatch(Commande::isEstLivree)
                        )
        );
    }
}
