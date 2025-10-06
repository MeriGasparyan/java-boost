package com.merigasparyan.jmp.Task5;

public class Number {

    public static void aNumber(int aNumber) {
        if (aNumber >= 0) {
            if (aNumber == 0) {
                System.out.println("first string");
            } else {
                System.out.println("second string");
            }
        }

        System.out.println("third string");
    }
}

// Else is always matched with nearest preceding unmatched if, hence the inner if and else
// would be considered a single operation and inside that outer if
