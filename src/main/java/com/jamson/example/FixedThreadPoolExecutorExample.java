package com.jamson.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by jamson on 6/16/17.
 */
public class FixedThreadPoolExecutorExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        List<Future<Integer>> futureList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<Integer> future = executorService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return (int) (Math.random() * 1000);
                }
            });
            futureList.add(future);
        }
        try {
            for (Future<Integer> f : futureList) {
                System.out.println(f.get());
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        }
    }
}
