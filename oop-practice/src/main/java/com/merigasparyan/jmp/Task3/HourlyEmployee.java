package com.merigasparyan.jmp.Task3;

public class HourlyEmployee extends Employee {
    private final double hourlyRate;
    private final int hoursWorked;
    private final int overtimeThreshold;
    private final double overtimeBonusRate;

    public HourlyEmployee(String name, double hourlyRate, int hoursWorked,
                          int overtimeThreshold, double overtimeBonusRate) {
        super(name);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.overtimeThreshold = overtimeThreshold;
        this.overtimeBonusRate = overtimeBonusRate;
    }


    @Override
    protected Money calculatePay() {
        return new Money(hourlyRate * hoursWorked);
    }

    @Override
    protected Money calculateBonus() {
        return new Money(hoursWorked > overtimeThreshold ? (hoursWorked - overtimeThreshold)
                * overtimeBonusRate : 0);
    }
}
