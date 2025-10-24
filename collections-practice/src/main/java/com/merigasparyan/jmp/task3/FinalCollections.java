package com.merigasparyan.jmp.task3;

import java.util.List;
import java.util.Set;

public class FinalCollections {
    public static final List<String> NAMES = List.of(
            "Meri", "Bob", "Anna", "Bob"

    );
    public static final Set<String> CURRENCIES = Set.of(
            "USD", "EUR", "GBP", "JPY", "CAD", "AUD"
    );
    public static void main(String[] args) {
        System.out.println(NAMES);
        System.out.println(CURRENCIES);
    }
}
