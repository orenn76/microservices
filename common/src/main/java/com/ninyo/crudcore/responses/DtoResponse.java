package com.ninyo.crudcore.responses;

import java.util.Collections;
import java.util.List;

public class DtoResponse<DTO> {

    List<DTO> data;

    public DtoResponse() {
    }

    public DtoResponse(DTO dto) {
        if (dto != null) {
            this.data = Collections.singletonList(dto);
        }
    }

    public List<DTO> getData() {
        return data;
    }

    public void setData(List<DTO> data) {
        this.data = data;
    }

}
