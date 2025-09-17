package com.merigasparyan.jmp.Task2;

public class Test {

    public static void main(String[] args) {
        Test t1= new Test();
        t1.method1(null);
    }
    public void method1(Object o)
    {
        System.out.println("object call");
    }

    public void method1(String o)
    {
        System.out.println("String call");
    }
}

