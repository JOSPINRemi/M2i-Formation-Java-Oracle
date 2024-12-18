package org.example.exercice13;

public class SharedResource {
    private String name;

    public SharedResource(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
