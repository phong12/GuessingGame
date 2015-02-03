package com.collegeboard.guess;

public enum UserAnswerEnum {

    Higher("higher"),
    Lower("lower"),
    Yes("yes"),
    End("end"),
    Ready("ready");

    private String value;

    UserAnswerEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

    public static UserAnswerEnum toEnum(String value) {
        for(UserAnswerEnum v : values()) {
            if (v.getValue().equalsIgnoreCase(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException();
    }
}