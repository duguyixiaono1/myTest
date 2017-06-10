package com.jamson.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by jamson on 6/10/17.
 */
public class Storage<E> {
    private int maxSize;
    private BlockingQueue<E> blockingQueue;

    public Storage() {
        maxSize = Integer.MAX_VALUE;
        blockingQueue = new LinkedBlockingQueue();
    }

    public Storage(int maxSize) {
        this.maxSize = maxSize;
        blockingQueue = new LinkedBlockingQueue(maxSize);
    }

    public Storage(int maxSize, BlockingQueue blockingQueue) {
        this.maxSize = maxSize;
        this.blockingQueue = blockingQueue;
    }

    public void produce(E e) {
        try {
            blockingQueue.put(e);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }

    public E consume() {
        try {
            return blockingQueue.take();
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }

        return null;
    }

    public static void main(String[] args) {
        Storage<Integer> storage = new Storage<>(10);

        for (int i = 0; i < 50; i++) {
            new Thread("producer-" + i) {
                @Override
                public void run() {
                    Producer producer = new Producer();
                    producer.setStorage(storage);
                    producer.add((int) (Math.random() * 100));
                }
            }.start();
        }

        for (int i = 0; i < 50; i++) {
            new Thread("consumer-" + i) {
                @Override
                public void run() {
                    Consumer consumer = new Consumer();
                    consumer.setStorage(storage);
                    consumer.consume();
                }
            }.start();
        }
    }
}
