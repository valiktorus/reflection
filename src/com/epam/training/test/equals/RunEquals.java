package com.epam.training.test.equals;

import com.epam.training.ObjectEqualityAnalyzer;

/**
 * Created by Valiantsin Pshanichnik on 20.12.2017.
 */
public class RunEquals {
    public static void main(String[] args) {
        Equal equal = new Equal(80, "Snow", "Jhon", 30, 185.6);

        Equal equal1 = new Equal(80, "Snow", "Jhon", 31,185.6);
        Equal equal2 = new Equal(80, "Snow", "Jhon", 30, 185.6);
        System.out.println(ObjectEqualityAnalyzer.equalObjects(equal, equal1));
        System.out.println(ObjectEqualityAnalyzer.equalObjects(equal, equal2));
    }
}
