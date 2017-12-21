package com.epam.training.enums;

import java.util.function.BiFunction;

/**
 * Created by Valiantsin Pshanichnik on 20.12.2017.
 */
public enum CompareEnum {
    /**
     * Reference defines comparing objects by reference.
     */
    REFERENCE((x, y) -> x == y),
    /**
     * Value defines comparing objects by value.
     */
    VALUE(Object::equals);

    private final BiFunction<Object, Object, Boolean> comparator;

    CompareEnum(final BiFunction<Object, Object, Boolean> comparator) {
        this.comparator = comparator;
    }

    /**
     * Compares two objects.
     *
     * @param firstObject  the first object
     * @param secondObject the second object
     * @return boolean true if objects are equals
     */
    public boolean compare(final Object firstObject, final Object secondObject) {
        return comparator.apply(firstObject, secondObject);
    }
}
