package com.merigasparyan.jmp.Task1;

import lombok.Getter;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Getter
public class Employee {
    private final String empName;
    private final int age;
    private final Address address;
    private final List<Responsibility> responsibilities;
    private final Date birthday;

    public Employee(String empName, int age, Address address,
                    List<Responsibility> responsibilities, Date birthday) {
        this.empName = empName;
        this.age = age;

        this.address = new Address(address);
        this.responsibilities = Collections.unmodifiableList(List.copyOf(responsibilities));
        this.birthday = new Date(birthday.getTime());
    }

}
