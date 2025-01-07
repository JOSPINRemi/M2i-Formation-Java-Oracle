package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextFileHandler {
    public static int occurrencesNumber(String filePath, String word) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(word)) count++;
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return count;
    }
}
