package com.jamson.example;

/**
 * Created by jamson on 6/10/17.
 */
public class Consumer {

    private Storage storage;

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public void consume() {
        System.out.println(Thread.currentThread().getName() + " consume " + storage.consume());
    }
}
