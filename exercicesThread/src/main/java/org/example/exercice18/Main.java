package org.example.exercice18;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<String > productsName = new CopyOnWriteArrayList<>();
        runTest(productsName);
    }

    private static void runTest(List<String> list) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 10; i++) {
                list.add(Thread.currentThread().getName() + "-Produit-" + i);
            }
        };

        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Liste finale des produits : " + list);
    }
}
