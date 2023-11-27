package com.ninyo.crudcore.mappers;

import java.util.ArrayList;
import java.util.List;

/**
 * Converter from one object to another.
 *
 * @param <S> source
 * @param <T> target
 */
public interface Converter<S, T> extends org.springframework.core.convert.converter.Converter<S, T> {

    /**
     * Default implementation of mapping from Iterable to List.
     * It will use mapping of single instance.
     *
     * @param sources Iterable of source elements
     * @return List of target elements
     */
    default List<T> convert(Iterable<S> sources) {
        List<T> targetList = new ArrayList<>();
        for (S source : sources) {
            T target = convert(source);
            targetList.add(target);
        }
        return targetList;
    }

}