package org.example.exercice12;

import java.util.ArrayList;
import java.util.List;

public class SharedResource {
    private List<Integer> list;

    public SharedResource() {
        this.list = new ArrayList<>();
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public void add(Integer i) {
        list.add(i);
    }

    public void remove(Integer i) {
        if (list.isEmpty())
            throw new RuntimeException("List is empty");
        list.remove(i);
    }
}
