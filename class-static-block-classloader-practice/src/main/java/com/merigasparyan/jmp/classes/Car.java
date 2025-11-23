package com.merigasparyan.jmp.classes;

public class Car {
    private String brand;
    public Car(String brand) {
        this.brand = brand;
    }
    public String getBrand() {
        return brand;
    }

    public static void changeBrand(Car car) {
        car = new Car("Audi");
    }
    public static void main(String[] args) {
        Car mers = new Car("Mercedes");
        changeBrand(mers);
        System.out.println(mers.getBrand());
    }
}

// The output is "Mercedes"
// This is because in java a copy of a method argument is what's getting passed, be it a primitive type
// or an object reference in this case. Hence the car in the changeBrand method is a local reference copy
// thus reassigning won't affect original mers.

