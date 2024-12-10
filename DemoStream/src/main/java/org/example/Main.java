package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Pomme", "Banane", "Ananas", "Poire", "Orange");

        List<String> listSorted = list.stream()
                .filter(str -> str.contains("a"))
                .sorted()
                .toList();

        List<Person> people = new ArrayList<>();
        people.add(new Person("toto", 12, "123456789"));
        people.add(new Person("titi", 20, "563789478"));
        people.add(new Person("tutu", 22, "134579560"));
        people.add(new Person("tata", 55, "516898731"));

        OptionalDouble moyenneAge = people.stream()
                .mapToInt(Person::getAge)
                .average();
        if (moyenneAge.isPresent()) {
            System.out.println("Moyenne d'âge " + moyenneAge.getAsDouble() + " ans");
        }

        people.add(new Person("toto", 12, "123456789"));
        people.add(new Person("titi", 20, "563789478"));
        people.add(new Person("tutu", 22, "134579560"));
        people.add(new Person("tata", 55, "516898731"));

        Map<String, Long> peopleByName = people.stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.counting()));

        for (Map.Entry entry : peopleByName.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}