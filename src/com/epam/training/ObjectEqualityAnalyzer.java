package com.epam.training;

import com.epam.training.annotations.Equals;
import com.epam.training.enums.CompareEnum;

import java.util.Arrays;

/**
 * Created by Valiantsin Pshanichnik on 20.12.2017.
 */
public final class ObjectEqualityAnalyzer {
    private ObjectEqualityAnalyzer() {
    }

    /**
     * equalObjects compares two objects.
     *
     * @param <T>          the type parameter
     * @param firstObject  the first object
     * @param secondObject the second object
     * @return the boolean true if objects are equals
     */
    public static <T> boolean equalObjects(final T firstObject, final T secondObject) {
        return compareClassFields(firstObject.getClass(), secondObject.getClass(), firstObject, secondObject);
    }

    private static <T> boolean compareClassFields(final Class<?> firstClass, final Class<?> secondClass,
                                                  final T firstObject, final T secondObject) {
        if (firstClass == null) {
            return true;
        }
        if (compareClassFields(firstClass.getSuperclass(), secondClass.getSuperclass(), firstObject, secondObject)) {
            return Arrays.stream(firstClass.getDeclaredFields())
                    .filter(field -> field.getAnnotation(Equals.class) != null)
                    .allMatch(field -> {
                        Equals equalsAnnotation = field.getDeclaredAnnotation(Equals.class);
                        CompareEnum compareBy = equalsAnnotation.compareby();
                        field.setAccessible(true);
                        Object firstField = null;
                        Object secondField = null;
                        try {
                            field.setAccessible(true);
                            firstField = field.get(firstObject);
                            secondField = field.get(secondObject);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } finally {
                            field.setAccessible(false);
                        }
                        return compareFieldValue(firstField, secondField, compareBy);
                    });
        } else {
            return false;
        }
    }

    private static <T> boolean compareFieldValue(final T firstField, final T secondField,
                                                 final CompareEnum compareEnum) {
        switch (compareEnum) {
            case REFERENCE:
                return firstField == secondField;
            case VALUE:
                return firstField.equals(secondField);
            default:
                return false;
        }
    }
}
