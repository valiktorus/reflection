package com.epam.training.test.equals;

import com.epam.training.annotations.Equals;
import com.epam.training.enums.CompareEnum;

/**
 * Created by Valiantsin Pshanichnik on 20.12.2017.
 */
public class Equal extends SuperEqual{
    @Equals(compareby = CompareEnum.VALUE)
    public String name;
    @Equals(compareby = CompareEnum.VALUE)
    private int age;
    @Equals(compareby = CompareEnum.VALUE)
    private double height;

    public Equal(int weight, String lastName, String name, int age, double height) {
        super(weight, lastName);
        this.name = name;
        this.age = age;
        this.height = height;
    }
}
