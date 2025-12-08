package com.merigasparyan.jmp;

public class Task3 {
    public static void main(String[] args) {
        try (Resource resource = new Resource()) {
            throw new RuntimeException("Primary exception in try block");
        } catch (Exception e) {
            System.out.println("Caught: " + e.getMessage());
            for (Throwable suppressed : e.getSuppressed()) {
                System.out.println("Suppressed: " + suppressed.getMessage());
            }
        }
    }
}
