package com.merigasparyan.jmp.task5;

import java.io.FileNotFoundException;

public class Child extends Parent {
    @Override
    void readFile() throws FileNotFoundException {
        System.out.println("Child reading specific file");
    }

    void writeFile() throws ArithmeticException {
        System.out.println("Child writing specific file");
    }

    @Override
    void doStuff() throws IllegalArgumentException {
        System.out.println("Child doing stuff");

    }


    // Can't do this
//    void doBadMath() throws Exception {
//
//    }
}
