package com.jamson.example;

/**
 * Created by jamson on 6/8/17.
 */
public class ThreadLocalExample {

    public static class MyRunnalbe implements Runnable {
        private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

        public void run() {
            threadLocal.set((int) (Math.random() * 100));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {

            }

            System.out.println(threadLocal.get());
        }
    }

    public static void main(String[] args) {
        MyRunnalbe runnalbe = new MyRunnalbe();

        Thread thread1 = new Thread(runnalbe);
        Thread thread2 = new Thread(runnalbe);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException ex) {

        }
    }
}
