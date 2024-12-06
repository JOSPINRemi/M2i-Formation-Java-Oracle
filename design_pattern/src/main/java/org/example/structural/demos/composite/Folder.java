package org.example.structural.demos.composite;

import java.util.ArrayList;
import java.util.List;

public class Folder implements Component {
    private String name;
    private List<Component> content;

    public Folder(String name) {
        this.name = name;
        content = new ArrayList<>();
    }

    public void add(Component component) {
        content.add(component);
    }

    public void remove(Component component) {
        content.remove(component);
    }

    @Override
    public void operation() {
        System.out.println("Folder : " + name);
        for (Component component : content) {
            component.operation();
        }
    }
}
