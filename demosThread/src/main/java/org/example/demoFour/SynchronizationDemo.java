package org.example.demoFour;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizationDemo {
    static class IdGenerator {
        private static int id = 0;

        public static int generateId() {
            return id++;
        }
    }

    private static final Object lock = new Object();
    private static final Lock reentrantLock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
//        demoWithoutSynchronization();

//        demoWithSynchronization();

        demoWithReentrantLock();
    }

    private static void demoWithoutSynchronization() throws InterruptedException {
        IdGenerator.id = 0;
        Thread[] threads = createThreads(() -> {
            for (int i = 0; i < 1_000; i++) {
                int id = IdGenerator.generateId();
            }
        });
        runThreads(threads);
        System.out.println("Valeur finale du compteur sans synchronization : " + IdGenerator.id);
    }

    private static void demoWithSynchronization() throws InterruptedException {
        IdGenerator.id = 0;
        Thread[] threads = createThreads(() -> {
            for (int i = 0; i < 1_000; i++) {
                synchronized (lock) {
                    int id = IdGenerator.generateId();
                }
            }
        });
        runThreads(threads);
        System.out.println("Valeur finale du compteur avec synchronization : " + IdGenerator.id);
    }

    private static void demoWithReentrantLock() throws InterruptedException {
        IdGenerator.id = 0;
        Thread[] threads = createThreads(() -> {
            for (int i = 0; i < 1_000; i++) {
                reentrantLock.lock();
                try {
                    int id = IdGenerator.generateId();
                }finally {
                    reentrantLock.unlock();
                }
            }
        });
        runThreads(threads);
        System.out.println("Valeur finale du compteur avec ReentrantLock : " + IdGenerator.id);
    }

    private static Thread[] createThreads(Runnable task) {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(task);
        }
        return threads;
    }

    private static void runThreads(Thread[] threads) throws InterruptedException {
        for (Thread thread : threads) thread.start();
        for (Thread thread : threads) thread.join();
    }
}
