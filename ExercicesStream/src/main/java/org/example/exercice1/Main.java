package org.example.exercice1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try {
            List<Movie> movies = new ArrayList<>();
            String file = "src/main/resources/films_with_genres 1.csv".replace("/", File.separator);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

//            Entête
            br.readLine();

            while (br.ready()) {
                String line = br.readLine();
//                System.out.println(line);
                String[] datas = line.split(",");
                Movie movie = new Movie(datas[0], LocalDate.parse(datas[1]), datas[2], datas[3], Integer.parseInt(datas[4]));
                movies.add(movie);
            }
//            movies.forEach(System.out::println);

//            System.out.println("1.Lecture et affichage basique avec Streams");
            /*System.out.println("Les 10 premiers films :");
            movies.stream().limit(10).forEach(System.out::println);*/
            /*System.out.println("Titres des films :");
            movies.stream().map(Movie::getTitle).forEach(System.out::println);*/

//            System.out.println("2.Filtrage avec Streams");
            /*System.out.println("Tous les films d'action :");
            movies.stream().filter(movie -> movie.getGenre().equals("Action")).forEach(System.out::println);*/
            /*System.out.println("Titre des films réalisés après les années 2000 :");
            movies.stream().filter(movie -> movie.getReleaseDate().isAfter(LocalDate.parse("2000-01-01"))).forEach(movie -> System.out.println(movie.getTitle()));*/
            /*System.out.println("Films réalisés par Michael Webster :");
            movies.stream().filter(movie -> movie.getDirector().equals("Michael Webster")).forEach(System.out::println);*/

//            System.out.println("3.Tri et limitation avec Streams");
            /*System.out.println("5 premiers films triés par nombre d'entrées croissant :");
            movies.stream().sorted(Comparator.comparing(Movie::getAdmissionNumber)).limit(5).forEach(System.out::println);*/
            /*System.out.println("Titres des films triés par date de sortie croissante :");
            movies.stream().sorted(Comparator.comparing(Movie::getReleaseDate)).forEach(movie -> System.out.println(movie.getTitle()));*/
            /*System.out.println("10 films avec le plus petit nombre d'entrées par nombre d'entrée croissant :");
            movies.stream().sorted(Comparator.comparing(Movie::getAdmissionNumber)).limit(10).forEach(System.out::println);*/

//            System.out.println("4.Regroupement avec Streams");
            /*System.out.println("Nombre de films par genre :");
            movies.stream().collect(Collectors.groupingBy(Movie::getGenre, Collectors.counting())).forEach((key, value) -> System.out.println(key + ": " + value));*/
            /*System.out.println("Titre des films par réalisateur :");
            movies.stream().collect(Collectors.groupingBy(Movie::getDirector)).forEach((key, value) -> System.out.println(key + " : " + value.stream().map(Movie::getTitle).collect(Collectors.joining(", "))));*/

//            System.out.println("5.Calculs avec Streams");
            /*System.out.println("Total des entrées de tous les films :");
            System.out.println(movies.stream().mapToLong(Movie::getAdmissionNumber).sum());*/
            /*System.out.println("Le genre avec le plus grand nombre total d'entrées :");
            System.out.println(movies.stream()
                    .collect(Collectors.groupingBy(Movie::getGenre, Collectors.summingLong(Movie::getAdmissionNumber)))
                    .entrySet().stream().max(Map.Entry.comparingByValue()).orElse(null));*/
            /*System.out.println("Moyenne des entrées pour les films d'un réalisateur donné (Michael Webster) :");
            movies.stream()
                    .filter(movie -> movie.getDirector().equals("Michael Webster"))
                    .mapToDouble(Movie::getAdmissionNumber)
                    .average()
                    .ifPresent(System.out::println);*/

//            System.out.println("6.Transformation avec Streams");
            /*System.out.println("Liste des films sous la forme Titre (Genre) - Réalisé par Réalisateur en Année");
            movies.stream().forEach(movie -> System.out.println(movie.getTitle() + " (" + movie.getGenre() + ")" + " - Réalisé par " + movie.getDirector() + " en " + movie.getReleaseDate()));*/
            /*System.out.println("Liste des genres uniques du fichier :");
            System.out.println(movies.stream().collect(Collectors.groupingBy(Movie::getGenre)).keySet());*/

            System.out.println("7.Questions avancées");
            /*System.out.println("Liste des premiers films dans chaque genre par date :");
            movies.stream()
                    .sorted(Comparator.comparing(Movie::getReleaseDate))
                    .collect(Collectors.groupingBy(Movie::getGenre))
                    .forEach((key, value) -> {
                        System.out.println(key + ": " + value.getFirst());
                    });*/
            System.out.println("Réalisateurs ayant réalisés plus de 50 films");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}