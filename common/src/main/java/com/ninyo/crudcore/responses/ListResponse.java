package com.ninyo.crudcore.responses;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({ "metaData", "data" })
public class ListResponse<D> extends DtoResponse<D> {

    MetaData metaData;

    public ListResponse() {
    }

    public ListResponse(List<D> data) {
        int size = data.size();
        this.metaData = new MetaData(size);
        this.data = data;
    }

    public ListResponse(long count, List<D> data) {
        super();
        this.metaData = new MetaData(count);
        this.data = data;
    }

    public MetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }
}
