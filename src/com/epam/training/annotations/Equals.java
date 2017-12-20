package com.epam.training.annotations;

import com.epam.training.enums.CompareEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Valiantsin Pshanichnik on 19.12.2017.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
public @interface Equals {
    /**
     * Compareby defines way of comparing fields.
     *
     * @return the compare enum
     */
    CompareEnum compareby();
}
