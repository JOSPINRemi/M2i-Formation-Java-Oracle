package org.example.exercice3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String csvFile = "src/main/resources/books_dataset.csv";
        List<Livre> livres;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            livres = br.lines()
                    .skip(1)
                    .map(line -> line.split(","))
                    .map(value -> new Livre(value[0], value[1], value[2], LocalDate.parse(value[3]), Integer.parseInt(value[4]), Boolean.parseBoolean(value[5]), Double.parseDouble(value[6])))
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        1
        /*livres.stream()
                .filter(Livre::isEstDisponible)
                .forEach(System.out::println);*/

//        2
        /*livres.stream()
                .filter(livre -> livre.getDatePublication().getYear() < 1950)
                .forEach(livre -> System.out.println(livre.getTitre() + " de " + livre.getAuteur()));*/

//        3
        /*livres.stream()
                .collect(Collectors.groupingBy(Livre::getGenre))
                .forEach((genre, livreList) -> System.out.println("Genre : " + genre + " Livres : " + livreList));*/

//        4
        /*livres.stream().min(Comparator.comparing(Livre::getDatePublication))
                .ifPresent(livre -> System.out.println("Livre : " + livre));*/

//        5
        /*System.out.println(livres.stream()
                .anyMatch(livre -> livre.getTitre().startsWith("Harry")));*/

//        6
        /*livres.stream()
                .filter(Livre::isEstDisponible)
                .mapToDouble(Livre::getPrix)
                .average()
                .ifPresent(System.out::println);*/

//        7
        /*livres.stream()
                .sorted(Comparator.comparingDouble(Livre::getPrix))
                .sorted(Comparator.comparingInt(Livre::getNbPages))
                .forEach(System.out::println);*/

//        8
        /*System.out.println(
                livres.stream()
                        .filter(livre -> livre.getGenre().equalsIgnoreCase("Fantasy"))
                        .mapToInt(Livre::getNbPages).sum()
        );*/

//        9
        /*livres.stream()
                .filter(Livre::isEstDisponible)
                .max(Comparator.comparingDouble(Livre::getPrix))
                .ifPresent(System.out::println);*/

//        10
        /*livres.stream()
                .collect(Collectors.groupingBy(Livre::getAuteur), Collectors.counting())*/

//        11

//        12

//        13

    }
}
