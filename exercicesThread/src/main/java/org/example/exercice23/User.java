package org.example.exercice23;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Item> cart;

    public User() {
        cart = new ArrayList<>();
    }

    public List<Item> getCart() {
        return cart;
    }

    public void setCart(List<Item> cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "User{" +
                "cart=" + cart +
                '}';
    }

    public void addItem(Item item) {
        cart.add(item);
    }

    public void removeItem(Item item) {
        cart.remove(item);
    }
}
