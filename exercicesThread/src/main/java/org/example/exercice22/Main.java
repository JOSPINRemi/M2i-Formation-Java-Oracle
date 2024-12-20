package org.example.exercice22;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        CompletableFuture<Void> read = CompletableFuture.runAsync(() -> {
            System.out.println("1. Lecture des données...");
        }, Executors.newVirtualThreadPerTaskExecutor());

        CompletableFuture<Void> process = read.thenRunAsync(() -> {
            System.out.println("2. Traitement des données...");
        }, Executors.newVirtualThreadPerTaskExecutor());

        CompletableFuture<Void> store = process.thenRunAsync(() -> {
            System.out.println("3. Stockage des résultats...");
        }, Executors.newVirtualThreadPerTaskExecutor());
        store.join();
    }
}
