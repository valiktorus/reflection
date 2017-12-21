package com.epam.training.test.equals;

import com.epam.training.annotations.Equals;
import com.epam.training.enums.CompareEnum;

/**
 * Created by Valiantsin Pshanichnik on 20.12.2017.
 */
public class Equal extends SuperEqual{
    @Equals(compareBy = CompareEnum.VALUE)
    public String name;
    @Equals(compareBy = CompareEnum.VALUE)
    private int age;
    @Equals(compareBy = CompareEnum.VALUE)
    private double height;

    public Equal(int weight, String lastName, String name, int age, double height) {
        super(weight, lastName);
        this.name = name;
        this.age = age;
        this.height = height;
    }
}
