package org.example.exercice23;

public class Main {
    public static void main(String[] args) {
        ItemCatalogue catalogue = new ItemCatalogue();
        for (int i = 0; i < 4; i++) {
            catalogue.addItem(new Item("Item-" + i, (i + 1) * 10));
        }
        for (Item item : catalogue.getItems()) {
            System.out.println(item);
        }
    }

//    4. barrier
}
