package org.example.demoFive;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
//        demoSimpleBarrier();
//        demoBarrierWithAction();
        demoBarrierReuse();
    }

    private static void demoSimpleBarrier() {
        CyclicBarrier barrier = new CyclicBarrier(3);

        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " a atteint la barrière");
                barrier.await();
                System.out.println(Thread.currentThread().getName() + " continue après la barrière");
            } catch (BrokenBarrierException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        for (int i = 0; i < 3; i++) {
            new Thread(task, ("Thread " + i)).start();
        }
    }

    private static void demoBarrierWithAction() {
        CyclicBarrier barrier = new CyclicBarrier(5, () -> {
            System.out.println("Tous les threads ont atteint la barrière. action exécutée");
        });

        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " a atteint la barrière");
                barrier.await();
                System.out.println(Thread.currentThread().getName() + " continue après la barrière");
            } catch (BrokenBarrierException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        for (int i = 0; i < 5; i++) {
            new Thread(task, ("Thread " + i)).start();
        }
    }

    private static void demoBarrierReuse() {
        CyclicBarrier barrier = new CyclicBarrier(5, () -> {
            System.out.println("Tous les threads ont atteint la barrière. action exécutée");
        });

        Runnable task = () -> {
            try {
                for (int i = 0; i < 3; i++) {
                    System.out.println(Thread.currentThread().getName() + " a atteint la barrière");
                    barrier.await();
                }
                System.out.println(Thread.currentThread().getName() + " a terminé");
            } catch (BrokenBarrierException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        for (int i = 0; i < 5; i++) {
            new Thread(task, ("Thread " + i)).start();
        }
    }
}
