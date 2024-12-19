package org.example.exercice19;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentLinkedQueue<String> products = new ConcurrentLinkedQueue<>();

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                String elementName = Thread.currentThread().getName() + "-Element-" + i;
                products.add(elementName);
                System.out.println(Thread.currentThread().getName() + " a ajouté : " + elementName);
            }
        }, "Producer");

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                if (products.isEmpty())
                    System.out.println(Thread.currentThread().getName() + " n'a trouvé aucun élément à retirer");
                else {
                    String elementName = Thread.currentThread().getName() + "-Element-" + i;
                    if(products.remove(elementName))
                        System.out.println(Thread.currentThread().getName() + " a retiré : " + elementName);
                }
            }
        }, "Consumer");

        consumer.start();
        Thread.sleep(1000);
        producer.start();

        producer.join();
        consumer.join();

        System.out.println("Etat final de la file : " + products);
    }
}
