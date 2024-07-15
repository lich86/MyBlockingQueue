package com.chervonnaya;

import java.util.LinkedList;
import java.util.Queue;

public class MyBlockingQueue<E> {

    private final Queue<E> queue = new LinkedList<>();
    private final int maxCapacity;

    public MyBlockingQueue(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public synchronized void enqueue(E e) throws InterruptedException {
        while (queue.size() == maxCapacity) {
            wait();
        }
        queue.add(e);
        notifyAll();
    }

    public synchronized E dequeue() throws InterruptedException {
        if(queue.isEmpty()) {
            wait();
        }
        E item = queue.poll();
        notifyAll();
        return item;
    }

    public synchronized int size() {
        return queue.size();
    }
}
