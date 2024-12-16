package org.example.exercice6;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);

        scheduler.schedule(() -> System.out.println("Tâche 1 executée après 1 seconde."), 1, TimeUnit.SECONDS);
        scheduler.schedule(() -> System.out.println("Tâche 2 executée après 2 secondes."), 2, TimeUnit.SECONDS);
        scheduler.schedule(() -> System.out.println("Tâche 3 executée après 3 secondes."), 3, TimeUnit.SECONDS);

        scheduler.schedule(() -> System.out.println("Toutes les tâches ont été exécutées. Arrêt du programme"), 4, TimeUnit.SECONDS);

        scheduler.shutdown();
    }
}
