package io.github.dsouzadyn;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    // Producer blocking queue
    private BlockingQueue<Data> queue;

    public Producer(BlockingQueue<Data> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for(int i = 0; i <= 5; i++) {
            try {
                queue.put(new Data(String.valueOf(i)));
                System.out.println("Produced: " + i);
                Thread.sleep(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            queue.put(new Data("done"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
