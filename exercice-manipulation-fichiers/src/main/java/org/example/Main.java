package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String srcFilePath = "source.txt";
        String word = "java";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("result.txt"))){
            writer.write("Dans le fichier, il a " + TextFileHandler.occurrencesNumber(word, srcFilePath) + " fois le mot " + word);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}