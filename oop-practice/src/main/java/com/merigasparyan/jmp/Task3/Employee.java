package com.merigasparyan.jmp.Task3;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Employee {
    private final String name;

    protected abstract Money calculatePay();
    protected abstract Money calculateBonus();
}
