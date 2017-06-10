package com.jamson.example;

/**
 * Created by jamson on 6/10/17.
 */
public class Producer {

    private Storage<Integer> storage;

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public void add(int elem) {
        storage.produce(elem);
        System.out.println(Thread.currentThread().getName() + " add " + elem);
    }

}
