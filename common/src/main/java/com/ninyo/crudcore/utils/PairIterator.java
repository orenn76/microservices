package com.ninyo.crudcore.utils;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Iterator;

public class PairIterator<T1, T2> implements Iterator<Pair<T1, T2>> {

    private final Iterator<T1> it1;
    private final Iterator<T2> it2;

    public PairIterator(Iterator<T1> it1, Iterator<T2> it2) {
        this.it1 = it1;
        this.it2 = it2;
    }

    @Override
    public boolean hasNext() {
        return it1.hasNext() && it2.hasNext();
    }

    @Override
    public Pair<T1, T2> next() {
        return new ImmutablePair<>(it1.next(), it2.next());
    }

    @Override
    public void remove(){
        it1.remove();
        it2.remove();
    }

}