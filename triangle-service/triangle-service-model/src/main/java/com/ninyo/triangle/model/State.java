package com.ninyo.triangle.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum State {

    PRE_CALC("pre_calc"),

    POST_CALC("post_calc");

    private final String value;

    State(final String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return this.value;
    }

    /**
     * Returns the enum matching the given string.
     *
     * @param value for which room type the enum needs to be found
     * @return the enum found matching the value
     */
    @JsonCreator
    public static State fromValue(final String value) {
        return Stream.of(State.values())
                .filter(enumValue -> enumValue.value.equals(value))
                .findAny()
                .orElse(null);
    }

    @Override
    public String toString() {
        return this.value;
    }

}