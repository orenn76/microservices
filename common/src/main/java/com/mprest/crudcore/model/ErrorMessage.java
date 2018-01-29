package com.mprest.crudcore.model;

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

    private String timestamp;
    private int status;
    private String error;
    private String exception;
    private String message;
    private String path;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class ErrorMessageBuilder {
    }
}

