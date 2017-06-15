package com.jamson.example;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by jliu1 on 2017/6/15.
 */
public class Worker implements Runnable {
    private CountDownLatch beginSignal;
    private CountDownLatch doSignal;
    private int id;

    public Worker(int id, CountDownLatch beginSignal, CountDownLatch doSignal) {
        this.id = id;
        this.beginSignal = beginSignal;
        this.doSignal = doSignal;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.id + " 已经就位准备起跑");
            beginSignal.await();
            System.out.println(this.id + " 起跑");
            int nextInt = new Random().nextInt(10000);
            Thread.sleep(nextInt);
            System.out.println(this.id + " 跑到终点了");
            doSignal.countDown();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int numRunners = 8;
        CountDownLatch beginSignal = new CountDownLatch(1);
        CountDownLatch doSignal = new CountDownLatch(numRunners);
        for (int i = 0; i < numRunners; i++) {
            new Thread(new Worker(i, beginSignal, doSignal)).start();
        }

        try {
            beginSignal.countDown();
            doSignal.await();
            System.out.println("结果发送到汇报成绩的系统");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
