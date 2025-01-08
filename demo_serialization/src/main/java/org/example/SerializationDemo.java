package org.example;

import java.io.*;

public class SerializationDemo {
    public static void runSerializationDemo() {
        System.out.println("La sérialisation ...");

        Student student = new Student("Toto", 33, "1234");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.ser"))) {
            oos.writeObject(student);
            System.out.println("Objet sérialisé ...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void runDeserializationDemo() {
        System.out.println("La désérialisation ...");

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.ser"))) {
            Student student = (Student) ois.readObject();
            System.out.println("Objet désérialisé ... " + student);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
