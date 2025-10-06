package com.merigasparyan.jmp.Task2;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CounterTest{

    @Test
    public void testThreadSafety() throws InterruptedException {
        Counter counter = new Counter();

        int threadCount = 100;
        int incrementsPerThread = 1000;

        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < incrementsPerThread; j++) {
                    counter.increment();
                }
            });
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        int expected = threadCount * incrementsPerThread;
        int actual = counter.getValue();

        assertEquals(expected, actual, "Counter should be thread-safe and reach the expected value");
    }
}