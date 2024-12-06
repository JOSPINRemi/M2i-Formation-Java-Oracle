package org.example.structural.demos.composite;

public class Main {
    public static void main(String[] args) {
        Component file1 = new File("file 1");
        Component file2 = new File("file 2");
        Component file3 = new File("file 3");

        Folder folder1 = new Folder("folder 1");
        Folder folder2 = new Folder("folder 2");

        folder2.add(file3);
        folder1.add(file1);
        folder1.add(file2);
        folder1.add(folder2);

        folder1.operation();
    }
}
