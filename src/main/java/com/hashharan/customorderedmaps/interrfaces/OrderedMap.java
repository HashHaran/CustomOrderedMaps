package com.hashharan.customorderedmaps.interrfaces;

import java.util.*;

public interface OrderedMap<K, V> extends Map<K, V> {

    public List<V> getTopValues(int n);
    public List<V> getBottomValues(int n);

    /**
     *
     * @param start: start index of the value in the ordered list, inclusive
     * @param end: start index of the value in the ordered list, exclusive
     * @return List of values
     */
    public List<V> getMiddleValues(int start, int end);


}
