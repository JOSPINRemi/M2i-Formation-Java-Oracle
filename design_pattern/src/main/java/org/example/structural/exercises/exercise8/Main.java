package org.example.structural.exercises.exercise8;

public class Main {
    public static void main(String[] args) {
        Manager manager1 = new Manager("John Doe");
        Manager manager2 = new Manager("Jane Doe");

        IndividualEmployee individualEmployee1 = new IndividualEmployee("Jonnie Doe");
        IndividualEmployee individualEmployee2 = new IndividualEmployee("Janie Doe");
        IndividualEmployee individualEmployee3 = new IndividualEmployee("Baby Doe");

        manager1.addEmployee(manager2);
        manager2.addEmployee(individualEmployee1);
        manager2.addEmployee(individualEmployee2);
        manager2.addEmployee(individualEmployee3);

        manager1.showDetails();
    }
}
