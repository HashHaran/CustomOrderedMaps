package com.hashharan.customorderedmaps.comparable;

import com.hashharan.customorderedmaps.doublylinkednode.DoublyLinkedNode;

import java.util.Comparator;

public class CustomOrderedSwimMap<K, V> extends CustomComparableOrderedMap<K, V> {
    public CustomOrderedSwimMap(Comparator<V> comparator) {
        super(comparator);
    }

    @Override
    protected DoublyLinkedNode<V> getPosition(DoublyLinkedNode<V> newNode) {
        DoublyLinkedNode<V> prev;
        if (newNode.getPrev() != null && newNode.getNext() != null) {
            prev = newNode.getPrev();
        } else {
            prev = this.tail.getPrev();
        }
        while (comparator.compare(prev.getContent(), newNode.getContent()) >= 0) {
            prev = prev.getPrev();
        }
        return prev;
    }
}
