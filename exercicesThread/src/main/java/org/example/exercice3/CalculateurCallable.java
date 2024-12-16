package org.example.exercice3;

import java.util.concurrent.*;

public class CalculateurCallable implements Callable<Integer> {
    private int value;

    public CalculateurCallable(int value) {
        this.value = value;
    }

    @Override
    public Integer call() {
        return (int) Math.pow(value, 3);
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = 1; i < 6; i++) {
            CalculateurCallable calculateurCallable = new CalculateurCallable(i);
            Future<Integer> result = executor.submit(calculateurCallable);
            try {
                System.out.println("Le cube de " + i + " est " + result.get());
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Erreur lors de la récupération");
            }
        }
        executor.shutdown();
    }
}
