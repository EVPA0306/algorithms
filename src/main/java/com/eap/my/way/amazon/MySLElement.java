package com.eap.my.way.amazon;

/**
 * Created by evgenypavlenko on 2/15/17.
 */
public class MySLElement<K> {
    private K key;
    private MySLElement<K> next;

    public MySLElement(K key) {
        this.key = key;
    }

    public MySLElement<K> getNext() {
        return this.next;
    }

    public K getKey() {
        return this.key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setNext(MySLElement<K> next) {
        this.next = next;
    }
}
