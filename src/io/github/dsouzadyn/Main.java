package io.github.dsouzadyn;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    public static void main(String[] args) {
        BlockingQueue<Data> mainQueue = new ArrayBlockingQueue<Data>(10);
        Producer producer = new Producer(mainQueue);
        Consumer consumer = new Consumer(mainQueue);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);
        System.out.println("Starting producer and consumer threads...");
        producerThread.start();
        consumerThread.start();
        System.out.println("Done.");
    }
}
