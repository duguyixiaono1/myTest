package com.jamson.example;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

/**
 * Created by jamson on 6/15/17.
 */
public class LONG {
    public static Long t1() {
        return null;
    }

    public static void main(String[] args) {
        if (0L == t1()) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
