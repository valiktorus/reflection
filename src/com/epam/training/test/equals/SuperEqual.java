package com.epam.training.test.equals;

import com.epam.training.annotations.Equals;
import com.epam.training.enums.CompareEnum;

/**
 * Created by Valiantsin Pshanichnik on 20.12.2017.
 */
public class SuperEqual {
    @Equals(compareBy = CompareEnum.VALUE)
    private int weight;
    @Equals(compareBy = CompareEnum.VALUE)
    public String lastName;

    public SuperEqual(int weight, String lastName) {
        this.weight = weight;
        this.lastName = lastName;
    }
}
