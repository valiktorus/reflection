package com.epam.training.enums;

public enum  CompareEnum {
    REFERENCE("reference"),
    VALUE("value");

    private String value;

    CompareEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
