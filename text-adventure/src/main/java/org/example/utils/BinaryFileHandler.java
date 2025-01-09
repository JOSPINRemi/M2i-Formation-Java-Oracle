package org.example.utils;

import org.example.entities.Character;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BinaryFileHandler {
    public static void write(String filePath, Object content) {
        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(filePath, true))) {
            writer.writeObject(content);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static List<Character> read(String filePath) {
        FileHandler.fileExists(filePath);
        List<Character> characters = new ArrayList<>();
        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(filePath))) {
            characters = (List<Character>) reader.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return characters;
    }
}
