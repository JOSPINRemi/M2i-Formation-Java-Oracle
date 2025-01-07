package org.example;

import java.io.*;

public class TextFileHandler {
    public void demoTextFileOperations() {
        System.out.println("Demo Text File Operations");
        String filePath = "demo.txt";

//        Ecriture
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Ligne 1 : Hello World !!!!\n");
            writer.write("Ligne 2 : Hello You !!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }

//        Lecture
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Ligne lue : " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
