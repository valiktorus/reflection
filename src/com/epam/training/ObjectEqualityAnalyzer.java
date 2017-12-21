package com.epam.training;

import com.epam.training.annotations.Equals;
import com.epam.training.enums.CompareEnum;
import com.epam.training.exception.CompareObjectsException;

import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Valiantsin Pshanichnik on 20.12.2017.
 */
public final class ObjectEqualityAnalyzer {
    private ObjectEqualityAnalyzer() {
    }

    /**
     * equalObjects compares two objects.
     *
     * @param firstObject  the first object
     * @param secondObject the second object
     * @return the boolean true if objects are equals
     */
    public static boolean equalObjects(final Object firstObject, final Object secondObject) {
        Map<String, Field> firstObjectFields = getEqualsFields(firstObject.getClass());
        Map<String, Field> secondObjectFields = getEqualsFields(secondObject.getClass());
        if (firstObjectFields.size() != secondObjectFields.size()) {
            return false;
        }
        return firstObjectFields.entrySet()
                .stream()
                .allMatch(compareFields(secondObjectFields, firstObject, secondObject));
    }

    private static Map<String, Field> getEqualsFields(final Class<?> clazz) {
        return getStream(Stream.empty(), clazz)
                .collect(Collectors.toMap(Field::getName, Function.identity()));
    }

    private static Stream<Field> getStream(final Stream<Field> fieldStream, final Class<?> clazz) {
        final Stream<Field> stream = Arrays.stream(clazz.getDeclaredFields())
                .filter(field -> field.getAnnotation(Equals.class) != null);
        Class<?> superclass = clazz.getSuperclass();
        Stream<Field> resultStream = Stream.concat(fieldStream, stream);
        if (superclass == null) {
            return resultStream;
        }
        return getStream(resultStream, superclass);
    }

    private static Predicate<Map.Entry<String, Field>> compareFields(final Map<String, Field> fields,
                                                                     final Object firstObject,
                                                                     final Object secondObject) {
        return fieldEntry -> {
            String key = fieldEntry.getKey();
            if (!fields.containsKey(key)) {
                return false;
            }
            CompareEnum compareEnum = fieldEntry.getValue().getAnnotation(Equals.class).compareBy();
            return compareFieldValue(fieldEntry.getValue(), fields.get(key), compareEnum, firstObject, secondObject);
        };
    }

    private static  boolean compareFieldValue(final Field firstField, final Field secondField,
                                                               final CompareEnum compareEnum, final Object firstObject,
                                                               final Object secondObject) {
        boolean accessFirstField = firstField.isAccessible();
        boolean accessSecondField = secondField.isAccessible();
        try {
            firstField.setAccessible(true);
            secondField.setAccessible(true);
            return compareEnum.compare(firstField.get(firstObject), secondField.get(secondObject));
        } catch (IllegalAccessException e) {
            throw new CompareObjectsException(e);
        } finally {
            firstField.setAccessible(accessFirstField);
            secondField.setAccessible(accessSecondField);
        }
    }
}
