package com.merigasparyan.jmp.Task6;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Resume {
    private int candidateId;
    private String candidateFullName;
    private String technology;
    private int yearsOfExperience;
}
