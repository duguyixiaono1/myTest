package com.jamson.example;

/**
 * Created by jamson on 6/16/17.
 */
public class BestPracticeToStopThread implements Runnable {
    private volatile boolean finished = false;

    public void stopMe() {
        finished = true;
    }

    @Override
    public void run() {
        while (!finished) {
            // do something
        }
    }
}
