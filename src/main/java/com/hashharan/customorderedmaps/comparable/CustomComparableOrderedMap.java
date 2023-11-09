package com.hashharan.customorderedmaps.comparable;

import com.hashharan.customorderedmaps.CustomOrderedMap;

import java.util.Comparator;

public abstract class CustomComparableOrderedMap<K, V> extends CustomOrderedMap<K, V> {
    Comparator<V> comparator;

    public CustomComparableOrderedMap(Comparator<V> comparator) {
        this.comparator = comparator;
    }

    public Comparator<V> getComparator() {
        return comparator;
    }
}
