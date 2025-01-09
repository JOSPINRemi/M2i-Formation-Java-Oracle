package org.example.utils;

import java.io.File;
import java.io.IOException;

public abstract class FileHandler {
    public static void fileExists(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
