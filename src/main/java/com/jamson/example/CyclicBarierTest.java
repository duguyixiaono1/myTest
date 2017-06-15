package com.jamson.example;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by jamson on 6/15/17.
 */
public class CyclicBarierTest {
    private static int num = 8;

    private static class Runner implements Runnable {
        private int id;
        private CyclicBarrier cyclicBarrier;

        public Runner(int id, CyclicBarrier cyclicBarrier) {
            this.id = id;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            // do something
            try {
                System.out.println("Worker's waiting");
                Thread.sleep((int) (Math.random() * 1000));

                cyclicBarrier.await();
                System.out.println(id + " is working");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } catch (BrokenBarrierException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(num, new Runnable() {
            //当所有线程到达barrier时执行
            @Override
            public void run() {
                System.out.println("Inside Barrier");
            }
        });

        for (int i = 0; i < num; i++) {
            new Thread(new Runner(i, cyclicBarrier)).start();
        }
    }
}
