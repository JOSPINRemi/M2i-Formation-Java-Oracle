package org.example;

import java.io.*;

public class Serializer {
    public static void serialize(String fileName, Object object) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(object);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static Object deserialize(String fileName, Object object) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            object = ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return object;
    }
}
