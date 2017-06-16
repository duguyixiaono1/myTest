package com.jamson.example;

/**
 * Created by jamson on 6/16/17.
 */
public class SwapTest {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        int aa = 1;
        int bb = 2;
        swap(a, b);
        System.out.println("a=" + a + ",b=" + b);
        swap(aa, bb);
        System.out.println("aa=" + aa + ",bb=" + bb);
    }

    public static void swap(Integer a, Integer b) {
        Integer tmp = a;
        a = b;
        b = tmp;
    }
}
