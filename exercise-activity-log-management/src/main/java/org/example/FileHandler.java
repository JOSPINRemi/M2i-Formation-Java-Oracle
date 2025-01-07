package org.example;

import java.io.*;
import java.time.LocalDateTime;

public class FileHandler {
    private static String srcFilePath;

    public static void initialize() {
        srcFilePath = "journal.txt";
        File srcFile = new File(srcFilePath);
        try {
            srcFile.createNewFile();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }


    public static void addActivity(String description) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(srcFilePath, true))) {
            writer.write("\n" + LocalDateTime.now() + " - " + description);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void readActivities() {
        try (BufferedReader reader = new BufferedReader(new FileReader(srcFilePath))) {
            System.out.println("--- Journal des activités ---");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static boolean saveToBinary(String destFilePath) {
        try (
                BufferedReader reader = new BufferedReader(new FileReader(srcFilePath));
                FileOutputStream out = new FileOutputStream(destFilePath)
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                out.write(line.getBytes());
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return true;
    }

    public static void readFromBinary(String binaryFilePath) {
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(binaryFilePath))) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            System.out.println("--- Contenu du Fichier Binaire ---");
            while ((bytesRead = in.read(buffer)) != -1) {
                System.out.println(new String(buffer, 0, bytesRead));
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
