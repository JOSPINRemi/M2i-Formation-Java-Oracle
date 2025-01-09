package org.example.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextFileHandler {
    public static void write(String filePath, String content) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static List<String> read(String filePath){
        FileHandler.fileExists(filePath);
        List<String> content = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null)
                content.add(line);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return content;
    }
}
