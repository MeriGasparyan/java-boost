package com.merigasparyan.jmp.classes;

public class ClassB extends ClassA {
    //public static void methodOne(int i) {} // This one makes the compiler to complain, since we cannot hide an instance method with static one
    public void methodTwo(int i) {} // This one overrides
    //public void methodThree(int i) {} // This one also makes the compiler to complain, since we cannot override a static method by instance one
    public static void methodFour(int i) {} // This one hides
}

