package org.example.exercice23;

import java.util.ArrayList;
import java.util.List;

public class ItemCatalogue {
    private List<Item> items;

    public ItemCatalogue() {
        items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "ItemCatalogue{" +
                "items=" + items +
                '}';
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }
}
