package org.example.structural.demos.composite;

public class File implements Component {
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("File : " + name);
    }
}
