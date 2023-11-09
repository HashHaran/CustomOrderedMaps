package com.hashharan.customorderedmaps;

import com.hashharan.customorderedmaps.doublylinkednode.DoublyLinkedNode;

public class LeastRecentlyUsedFirstMap<K, V> extends CustomOrderedMap<K, V> {
    @Override
    protected DoublyLinkedNode<V> getPosition(DoublyLinkedNode<V> newNode) {
        return this.head;
    }
}
