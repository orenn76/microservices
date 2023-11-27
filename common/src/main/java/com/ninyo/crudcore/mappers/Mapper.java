package com.ninyo.crudcore.mappers;

import com.ninyo.crudcore.utils.PairIterator;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.FatalBeanException;

import java.lang.reflect.InvocationTargetException;

/**
 * Mapper from one object to another. Uses bean conventions:
 * Internally {@link BeanUtilsBean#copyProperties(Object, Object)} is used
 *
 * @param <S> source
 * @param <T> target
 */
public interface Mapper<S, T> {

    /**
     * Default implementation of mapping from source to target.
     * Uses {@link BeanUtilsBean#copyProperties(Object, Object)} internally
     *
     * @param source the source
     * @param target the target
     */
    default void map(S source, T target) {
        try {
            // target must have a property setter for it to be copied
            BeanUtilsBean.getInstance().copyProperties(target, source);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new FatalBeanException("Could not copy properties from source \'" + source.getClass().getSimpleName() + "\' to target '" + target.getClass().getSimpleName(), e);
        }
    }

    /**
     * Default implementation of mapping from Iterable to Iterable.
     * It will use mapping of single instance and map from sources to targets one by one in the order of the two iterable lists.
     * Assumption: sources and targets are ordered correctly for the mapping purpose.
     *
     * @param sources Iterable of source elements
     * @param targets Iterable of target elements
     */
    default void map(Iterable<S> sources, Iterable<T> targets) {
        PairIterator<S, T> pairIter = new PairIterator<>(sources.iterator(), targets.iterator());
        while (pairIter.hasNext()) {
            Pair<S, T> pair = pairIter.next();
            map(pair.getLeft(), pair.getRight());
        }
    }
}