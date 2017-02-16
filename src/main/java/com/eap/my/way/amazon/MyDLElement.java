package com.eap.my.way.amazon;

/**
 * Created by evgenypavlenko on 2/14/17.
 */
public class MyDLElement<K> {

    private MyDLElement<K> prev;
    private K key;
    private MyDLElement<K> next;

    public MyDLElement(MyDLElement<K> prev, K key, MyDLElement<K> next) {
        this.prev = prev;
        this.key = key;
        this.next = next;
    }

    public void setPrev(MyDLElement<K> prev) {
        this.prev = prev;
    }

    public void setNext(MyDLElement<K> next) {
        this.next = next;
    }

    public MyDLElement getNext() {
        return this.next;
    }

    public MyDLElement getPrev() {
        return this.prev;
    }

    public K getKey() {
        return this.key;
    }
}
