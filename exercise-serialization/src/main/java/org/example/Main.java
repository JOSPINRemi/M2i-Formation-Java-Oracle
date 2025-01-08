package org.example;

public class Main {
    public static void main(String[] args) {
        String fileName = "books.ser";
        Book book = new Book("Vingt Mille Lieues sous les mers", "Jules Verne");

        System.out.println("Sérialisation ...");
        Serializer.serialize(fileName, book);

        System.out.println("Désérialisation ...");
        System.out.println(Serializer.deserialize(fileName, new Book()));
        Serializer.deserialize(fileName, Book.class);
    }
}