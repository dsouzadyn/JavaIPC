package io.github.dsouzadyn;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    // Consumer blocking queue
    private BlockingQueue<Data> queue;
    private Data data;
    public Consumer(BlockingQueue<Data> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while ((data = queue.take()).getData() != "done") {
                System.out.println("Consumed: " + data.getData());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
