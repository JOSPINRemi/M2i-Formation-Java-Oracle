package org.example.exercice17;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    private static ConcurrentHashMap<String, Integer> products;

    public static void main(String[] args) throws InterruptedException {
        products = new ConcurrentHashMap<>();
        products.put("ProduitA", 10);
        products.put("ProduitB", 20);
        products.put("ProduitC", 30);

        Runnable buyTask = () -> {
            for (int i = 0; i < 5; i++) {
                String productName = "Produit" + (char) ('A' + ThreadLocalRandom.current().nextInt(products.size()));
                products.computeIfPresent(productName, (key, value) -> value > 0 ? value - 1 : 0);
                System.out.println(Thread.currentThread().getName() + " a acheté 1 unité de " + productName);
            }
        };

        Runnable restockTask = () -> {
          for (int i = 0; i < 5; i++) {
              String productName = "Produit" + (char) ('A' + ThreadLocalRandom.current().nextInt(products.size()));
              products.merge(productName, 10, Integer::sum);
              System.out.println(Thread.currentThread().getName() + " a réapprovisionné 10 unités de " + productName);
          }
        };

        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(buyTask);
        executor.submit(restockTask);
        executor.submit(buyTask);
        executor.shutdown();

        while (!executor.isTerminated()) {
            Thread.sleep(100);
        }

        System.out.println("Inventaire final : " + products);
    }
}
