package org.example.exercice12;

public class Main {
    private static final Object lock = new Object();
    private static SharedResource sharedResource;

    public static void main(String[] args) throws InterruptedException {
        demo();
    }

    private static void demo() throws InterruptedException {
        sharedResource = new SharedResource();
        Thread[] threads = createThreads(() -> {
            long rand = Math.round(Math.random());
            for (int i = 0; i < 5; i++) {
                synchronized (lock) {
                    if (rand == 0) {
                        sharedResource.add(i);
                        System.out.println(Thread.currentThread().getName() + " a ajouté " + i);
                    } else if (rand == 1) {
                        try {
                            sharedResource.remove(i);
                            System.out.println(Thread.currentThread().getName() + " a supprimé " + i);
                        } catch (Exception e) {
                            System.out.println(Thread.currentThread().getName() + " n'a rien à supprimer.");
                        }
                    }
                }
            }
        }, 2);
        runThreads(threads);
        System.out.println("Etat final de la liste : " + sharedResource.getList());
    }

    private static Thread[] createThreads(Runnable task, int size) {
        Thread[] threads = new Thread[size];
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
