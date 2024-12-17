package org.example.exercice7;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Message périodique " + counter.incrementAndGet());
            if (counter.get() == 5) {
                System.out.println("Programme terminé.");
                scheduler.shutdown();
            }
        }, 1, 2, TimeUnit.SECONDS);
    }
}
