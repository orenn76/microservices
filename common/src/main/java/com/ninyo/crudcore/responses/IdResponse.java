package com.ninyo.crudcore.responses;

public class IdResponse {

    private long id;

    public IdResponse() {
    }

    public IdResponse(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
