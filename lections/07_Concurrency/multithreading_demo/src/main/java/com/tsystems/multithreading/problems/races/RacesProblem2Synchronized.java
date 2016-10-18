package com.tsystems.multithreading.problems.races;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author aesipov
 */
public class RacesProblem2Synchronized {

    static class BankAccount {

        private int balance;

        public BankAccount(int balance) {
            this.balance = balance;
        }

        public synchronized void withdraw(int amount) {
            if (balance >= amount) {
                Thread.yield();
                balance -= amount;
            }
        }
        @Override
        public String toString() {
            return "BankAccount { balance = " + balance + '}';
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int n = 1000;
        final BankAccount bankAccount = new BankAccount(100);
        final Random random = new Random();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    bankAccount.withdraw(random.nextInt(50));
                }
            };
            threads.add(t);
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(bankAccount);
    }
}
