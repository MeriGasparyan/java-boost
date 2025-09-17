package com.merigasparyan.jmp.Task3;

public class SalariedEmployee extends Employee {
    private final double monthlySalary;
    private final double bonusRate;

    public SalariedEmployee(String name, double monthlySalary, double bonusRate) {
        super(name);
        this.monthlySalary = monthlySalary;
        this.bonusRate = bonusRate;
    }

    @Override
    protected Money calculatePay() {
        return new Money(monthlySalary);
    }

    @Override
    protected Money calculateBonus() {
        return new Money(monthlySalary * bonusRate);
    }
}
