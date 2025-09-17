package com.merigasparyan.jmp.Task1;

public class Test {
    public static void main(String[] args) {
        A ab = new B();
        A ac = new C();
        C cb = (C) new B();
    }
}
// We get a runtime error on line C, because during runtime it
// is checked whether B is instance of C, and it throws exception
// because it is not(it's the other way around).
// Simply put All C-s are B, but not all B-s are C hence the exception