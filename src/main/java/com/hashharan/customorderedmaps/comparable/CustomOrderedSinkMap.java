package com.hashharan.customorderedmaps.comparable;

import com.hashharan.customorderedmaps.doublylinkednode.DoublyLinkedNode;

import java.util.Comparator;

public class CustomOrderedSinkMap<K, V> extends CustomComparableOrderedMap<K, V> {
    public CustomOrderedSinkMap(Comparator<V> comparator) {
        super(comparator);
    }

    @Override
    protected DoublyLinkedNode<V> getPosition(DoublyLinkedNode<V> newNode) {
        DoublyLinkedNode<V> next;
        if (newNode.getPrev() != null && newNode.getNext() != null) {
            next = newNode.getNext();
        } else {
            next = this.head.getNext();
        }
        while (comparator.compare(next.getContent(), newNode.getContent()) >= 0) {
            next = next.getNext();
        }
        return next;
    }
}
