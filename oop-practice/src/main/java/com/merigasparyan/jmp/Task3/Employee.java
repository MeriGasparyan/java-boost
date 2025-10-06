package com.merigasparyan.jmp.Task3;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public abstract class Employee {
    private final String name;

    protected abstract Money calculatePay();
    protected abstract Money calculateBonus();
}
