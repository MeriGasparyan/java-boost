package com.merigasparyan.jmp.task5;

import java.io.IOException;

public class Parent {

    void readFile() throws IOException {
        System.out.println("Parent reading file");
    }

    void writeFile() throws IOException {
        System.out.println("Parent writing file");
    }

    void doStuff() throws Exception {
        System.out.println("Parent doing stuff");
    }

    void doBadMath() throws ArithmeticException {
        System.out.println("Parent doing bad math");
    }
}
