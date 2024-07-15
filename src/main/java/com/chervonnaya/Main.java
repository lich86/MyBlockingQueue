package com.chervonnaya;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(5);

        ExecutorService executor = Executors.newFixedThreadPool(10);

        Runnable producer = () -> {
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println("Produced: " + i);
                    queue.enqueue(i);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Runnable consumer = () -> {
            for (int i = 0; i < 10; i++) {
                try {
                    int item = queue.dequeue();
                    System.out.println("Consumed: " + item);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        executor.execute(producer);
        executor.execute(consumer);

        executor.shutdown();
    }
}
