package com.merigasparyan.jmp.task5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ReverseOrder {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9, 78, 6, -9);

        List<Integer> descending = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println(descending);
    }
}
