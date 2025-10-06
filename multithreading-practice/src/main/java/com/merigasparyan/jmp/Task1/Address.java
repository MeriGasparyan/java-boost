package com.merigasparyan.jmp.Task1;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Address {
    private final String city;
    private final String street;
    private final int buildingNumber;

    public Address(Address other) {
        this(other.city, other.street, other.buildingNumber);
    }
}
