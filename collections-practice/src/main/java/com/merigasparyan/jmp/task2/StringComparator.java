package com.merigasparyan.jmp.task2;

import java.util.Comparator;

// Please check tests

public class StringComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if (o1 == null || o2 == null) {
            throw new NullPointerException("Cannot compare null strings");
        }
        if (o1.length() < 2 || o2.length() < 2) {
            throw new IllegalArgumentException("String lengths must be greater than 2");
        }

        return Character.compare(o2.charAt(1), o1.charAt(1));
    }
}
