package com.jamson.example;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;

/**
 * Created by jliu1 on 2017/6/18.
 */
public class ThreadSafeList {
    public static void main(final String[] args) {
        //
//        final List<Integer> array = new ArrayList<>();
//        final List<Integer> array = new Vector<>();
//        final List<Integer> array = new LinkedList<>();
//        final List<Integer> array = new CopyOnWriteArrayList<>();
        final List<Integer> array = Collections.synchronizedList(new ArrayList<Integer>());
        for (int i = 0; i < 10; i++) {
            array.add(i);
        }

        new Thread("iteration") {
            @Override
            public void run() {
                Iterator<Integer> it = array.iterator();
                while (it.hasNext()) {
                    System.out.println(it.next());
                }
            }
        }.start();

        new Thread("remove thread") {
            @Override
            public void run() {
                array.remove(5);
            }
        }.start();

    }
}

