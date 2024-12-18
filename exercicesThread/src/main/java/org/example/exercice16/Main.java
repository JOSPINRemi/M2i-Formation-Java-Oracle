package org.example.exercice16;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class Main {
    private static final int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
    private static final AtomicIntegerArray sumArray = new AtomicIntegerArray(4);

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(sumArray.length(), () -> {
            int sum = 0;
            for (int i = 0; i < sumArray.length(); i++) {
                sum += sumArray.get(i);
            }
            System.out.println("Somme totale : " + sum);
        });

        for (int i = 0; i < sumArray.length(); i++) {
            final int index = i;
            new Thread(new Thread(() -> {
                try {
                    int start = index * 2;
                    int end = start + 2;
                    int sum = 0;
                    for (int j = start; j < end; j++) {
                        sum += array[j];
                    }
                    sumArray.set(index, sum);
                    System.out.println(Thread.currentThread().getName() + " a calculé une somme partielle de (indice : " + start + " à indice : " + (end - 1) + ") : " + sum);
                    barrier.await();
                } catch (BrokenBarrierException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }), "Thread-" + (i + 1)).start();
        }
    }
}
