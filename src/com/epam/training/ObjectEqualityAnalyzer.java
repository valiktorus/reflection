package com.epam.training;

import com.epam.training.annotations.Equals;
import com.epam.training.enums.CompareEnum;

import java.util.Arrays;

/**
 * Created by Valiantsin Pshanichnik on 20.12.2017.
 */
public class ObjectEqualityAnalyzer {
    public static <T> boolean equalObjects(T firstObject, T secondObject ){
        return compareClassFields(firstObject.getClass(), secondObject.getClass(), firstObject, secondObject);
    }

    private static <T> boolean compareClassFields(Class<?> firstClass, Class<?> secondClass, T first, T second) {
        if (firstClass == null) {
            return true;
        }
        if (compareClassFields(firstClass.getSuperclass(), secondClass.getSuperclass(), first, second)) {
            return Arrays.stream(firstClass.getDeclaredFields())
                    .filter(field -> field.getAnnotation(Equals.class) != null)
                    .allMatch(field -> {
                        Equals equalsAnnotation = field.getDeclaredAnnotation(Equals.class);
                        CompareEnum compareby = equalsAnnotation.compareby();
                        field.setAccessible(true);
                        try {
                            Object firstField = field.get(first);
                            Object secondField = field.get(second);
                            if (CompareEnum.REFERENCE == compareby) {
                                if (firstField != secondField) {
                                    return false;
                                }
                            } else if (CompareEnum.VALUE == compareby) {
                                if (!firstField.equals(secondField)) {
                                    return false;
                                }
                            }
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                        return true;
                    });
        }else {
            return false;
        }
    }

}
