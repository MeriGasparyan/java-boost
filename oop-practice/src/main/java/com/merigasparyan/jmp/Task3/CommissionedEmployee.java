package com.merigasparyan.jmp.Task3;

import lombok.Getter;

@Getter
public class CommissionedEmployee extends Employee {
    private final double commissionRate;
    private final double sales;
    private final double salesBonusRate;

    public CommissionedEmployee(String name, double commissionRate, double sales, double salesBonusRate) {
        super(name);
        this.commissionRate = commissionRate;
        this.sales = sales;
        this.salesBonusRate = salesBonusRate;
    }

    @Override
    protected Money calculatePay() {
        return new Money(sales * commissionRate);
    }

    @Override
    protected Money calculateBonus() {
        return new Money(sales * salesBonusRate);
    }


}
