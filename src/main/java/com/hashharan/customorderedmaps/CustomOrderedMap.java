package com.hashharan.customorderedmaps;

import com.hashharan.customorderedmaps.doublylinkednode.DoublyLinkedNode;
import com.hashharan.customorderedmaps.interrfaces.OrderedMap;

import java.util.*;
import java.util.stream.Collectors;

public abstract class CustomOrderedMap<K, V> implements OrderedMap<K, V> {
    protected Map<K, DoublyLinkedNode<V>> map;
    protected DoublyLinkedNode<V> head;
    protected DoublyLinkedNode<V> tail;

    public CustomOrderedMap() {
        map = new HashMap<>();
        head = new DoublyLinkedNode<>(null);
        tail = new DoublyLinkedNode<>(null);
        head.setNext(tail);
        tail.setPrev(head);
    }

    @Override
    public List<V> getTopValues(int n) {
        return getMiddleValues(0, n + 1);
    }

    @Override
    public List<V> getBottomValues(int n) {
        List<V> res = new ArrayList<>();
        DoublyLinkedNode<V> node = this.tail;
        while (n != 0 && !node.getPrev().equals(this.head)) {
            res.add(node.getPrev().getContent());
            n --;
            node = node.getPrev();
        }
        return res;
    }

    @Override
    public List<V> getMiddleValues(int start, int end) {
        List<V> res = new ArrayList<>();
        assert start <= end;
        DoublyLinkedNode<V> node = this.head;
        int i = 0;
        while (i < start && !node.getNext().equals(this.tail)) {
            start++;
            node = node.getNext();
        }
        while (i < end && !node.getNext().equals(this.tail)) {
            res.add(node.getNext().getContent());
            i++;
        }
        return res;
    }


    @Override
    public int size() {
        return this.map.size();
    }

    @Override
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return this.map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return this.map.containsValue(value);
    }

    @Override
    public V get(Object key) {
        return this.map.get(key).getContent();
    }

    @Override
    public V put(K key, V value) {
        DoublyLinkedNode<V> node = this.map.get(key);
        if (node != null) {
            node.removeNode();
        }
        DoublyLinkedNode<V> newNode = new DoublyLinkedNode<>(value);
        if (node != null) {
            newNode.setPrev(node.getPrev());
            newNode.setNext(node.getNext());
        }
        DoublyLinkedNode<V> prevNode = getPosition(newNode);
        DoublyLinkedNode<V> nextNode = prevNode.getNext();
        prevNode.setNext(newNode);
        newNode.setPrev(prevNode);
        newNode.setNext(nextNode);
        nextNode.setPrev(newNode);
        this.map.put(key, newNode);
        return value;
    }

    protected abstract DoublyLinkedNode<V> getPosition(DoublyLinkedNode<V> newNode);

    @Override
    public V remove(Object key) {
        DoublyLinkedNode<V> node = this.map.get(key);
        node.removeNode();
        this.map.remove(key);
        return node.getContent();
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {
        this.map.clear();
        this.head.setNext(this.tail);
        this.tail.setPrev(this.head);
    }

    @Override
    public Set<K> keySet() {
        return this.map.keySet();
    }

    @Override
    public Collection<V> values() {
        return this.map.values().stream().map((DoublyLinkedNode::getContent)).collect(Collectors.toList());
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return this.map.entrySet().stream().collect(Collectors.toMap(Entry::getKey, entry -> entry.getValue().getContent())).entrySet();
    }
}
