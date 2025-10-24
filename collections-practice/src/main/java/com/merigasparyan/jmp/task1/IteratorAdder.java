package com.merigasparyan.jmp.task1;

import java.util.*;

import java.util.concurrent.CopyOnWriteArraySet;

public class IteratorAdder {
    public static void main(String[] args) {

        //HashSet
        System.out.println("HASHSET");
        Set<String> hashSet = new HashSet<>(Arrays.asList("A", "B", "C", "D"));

        try {
            Iterator<String> iterator1 = hashSet.iterator();
            while (iterator1.hasNext()) {
                String element = iterator1.next();
                System.out.println("Elem: " + element);
                if (element.equals("B")) {
                    hashSet.add("E"); // ConcurrentModificationException
                }
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getClass().getSimpleName());
        }

        System.out.println("\nHASHSET -  WITH ITERATOR REMOVE");
        Set<String> hashSet2 = new HashSet<>(Arrays.asList("A", "B", "C", "D"));
        Iterator<String> iterator2 = hashSet2.iterator();

        while (iterator2.hasNext()) {
            String element = iterator2.next();
            System.out.println("Elem: " + element);
            if (element.equals("B")) {
                iterator2.remove();
                System.out.println("Removed 'B'");
            }
        }

        System.out.println("\nHASHSET - MODIFICATION AFTER ITERATOR CREATION");
        Set<String> hashSet3 = new HashSet<>(Arrays.asList("A", "B", "C", "D"));
        Iterator<String> iterator3 = hashSet3.iterator();

        hashSet3.add("X");

        try {
            while (iterator3.hasNext()) {
                String element = iterator3.next();
                System.out.println("Elem: " + element);
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getClass().getSimpleName());
        }

        // CopyOnWriteArraySet
        System.out.println("\n COPYONWRITEARRAYSET");
        Set<String> copyOnWriteSet = new CopyOnWriteArraySet<>(Arrays.asList("A", "B", "C", "D"));
        Iterator<String> iterator4 = copyOnWriteSet.iterator();

        System.out.println("Initial set: " + copyOnWriteSet);
        while (iterator4.hasNext()) {
            String element = iterator4.next();
            System.out.println("Elem: " + element);
            if (element.equals("B")) {
                copyOnWriteSet.add("E");
                copyOnWriteSet.remove("A");
                System.out.println("Added 'E' and removed 'A' during iteration");
            }
        }
        System.out.println("Set after iteration: " + copyOnWriteSet);

        // TreeSet
        System.out.println("\nTREESET");
        Set<String> treeSet = new TreeSet<>(Arrays.asList("A", "B", "C", "D"));

        try {
            Iterator<String> iterator6 = treeSet.iterator();
            while (iterator6.hasNext()) {
                String element = iterator6.next();
                System.out.println("Elem: " + element);
                if (element.equals("C")) {
                    treeSet.add("F"); // ConcurrentModificationException
                }
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getClass().getSimpleName());
        }

        // LinkedHashSet
        System.out.println("\nLINKEDHASHSET");
        Set<String> linkedHashSet = new LinkedHashSet<>(Arrays.asList("A", "B", "C", "D"));

        try {
            Iterator<String> iterator7 = linkedHashSet.iterator();
            while (iterator7.hasNext()) {
                String element = iterator7.next();
                System.out.println("Processing: " + element);
                if (element.equals("A")) {
                    linkedHashSet.remove("C"); // ConcurrentModificationException
                }
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getClass().getSimpleName());
        }
    }
}
