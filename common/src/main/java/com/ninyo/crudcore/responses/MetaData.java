package com.ninyo.crudcore.responses;

/**
 * @author Oren on 7/3/2016
 */
public class MetaData {

    //The total count of items
    long count;

    public MetaData() {
        this.count = 0;
    }

    public MetaData(long count) {
        this.count = count;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
