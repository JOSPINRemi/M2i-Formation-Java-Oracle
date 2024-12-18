package org.example.exercice11;

public class Main {
    private static final Object lock = new Object();
    private static BankAccount bankAccount;

    public static void main(String[] args) throws InterruptedException {
        demo();
    }

    private static void demo() throws InterruptedException {
        bankAccount = new BankAccount();
        Thread[] threads = createThreads(() -> {
            long rand = Math.round(Math.random());
            for (int i = 0; i < 5; i++) {
                synchronized (lock) {
                    if (rand == 0) {
                        bankAccount.deposit(10);
                        System.out.println(Thread.currentThread().getName() + " a déposé 10, solde actuel : " + bankAccount.getBalance());
                    } else if (rand == 1) {
                        try {
                            bankAccount.withdraw(10);
                            System.out.println(Thread.currentThread().getName() + " a retiré 10, solde actuel : " + bankAccount.getBalance());

                        } catch (Exception e) {
                            System.out.println(Thread.currentThread().getName() + " n'a pas pu retirer 10 (" + e.getMessage() + "). Solde actuel : " + bankAccount.getBalance());
                        }
                    }
                }
            }
        }, 3);
        runThreads(threads);
        System.out.println("Solde final : " + bankAccount.getBalance());
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
