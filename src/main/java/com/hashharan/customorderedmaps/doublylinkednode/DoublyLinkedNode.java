package com.hashharan.customorderedmaps.doublylinkednode;

public class DoublyLinkedNode<C> {
    C content;
    DoublyLinkedNode<C> prev;
    DoublyLinkedNode<C> next;

    public DoublyLinkedNode(C content) {
        this.content = content;
    }

    public void setPrev(DoublyLinkedNode<C> prev) {
        this.prev = prev;
    }

    public void setNext(DoublyLinkedNode<C> next) {
        this.next = next;
    }

    public C getContent() {
        return content;
    }

    public DoublyLinkedNode<C> getPrev() {
        return prev;
    }

    public DoublyLinkedNode<C> getNext() {
        return next;
    }

    public void removeNode() {
        this.prev.setNext(this.next);
        this.next.setPrev(this.prev);
    }
}
