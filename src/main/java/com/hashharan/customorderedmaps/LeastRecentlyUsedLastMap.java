package com.hashharan.customorderedmaps;

import com.hashharan.customorderedmaps.doublylinkednode.DoublyLinkedNode;

public class LeastRecentlyUsedLastMap<K, V> extends CustomOrderedMap<K, V>{
    @Override
    protected DoublyLinkedNode<V> getPosition(DoublyLinkedNode<V> newNode) {
        return this.tail.getPrev();
    }
}
