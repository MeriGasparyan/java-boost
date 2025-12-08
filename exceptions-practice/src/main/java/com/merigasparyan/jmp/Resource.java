package com.merigasparyan.jmp;

public class Resource implements AutoCloseable {
    @Override
    public void close() {
        throw new IllegalStateException("Exception thrown in close() method");
    }
}
