package com.ninyo.crudcore.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

import java.io.Serializable;

@JsonPropertyOrder({"timestamp", "status", "error", "exception", "message", "path"})
@Builder(toBuilder = true)
@Value
@JsonDeserialize(builder = ErrorMessage.ErrorMessageBuilder.class)
public class ErrorMessage implements Serializable {

    private static final long serialVersionUID = -8042087345155849600L;

    String timestamp;
    int status;
    String exception;
    String message;
    String path;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class ErrorMessageBuilder {
    }
}

