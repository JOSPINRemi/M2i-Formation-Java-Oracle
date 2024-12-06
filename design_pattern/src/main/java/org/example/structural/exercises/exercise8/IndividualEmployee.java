package org.example.structural.exercises.exercise8;

public class IndividualEmployee implements Employee {
    private String name;

    public IndividualEmployee(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("Individual Employee : " + name);
    }
}
