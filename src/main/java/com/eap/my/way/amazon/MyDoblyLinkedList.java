package com.eap.my.way.amazon;

/**
 * Created by evgenypavlenko on 2/14/17.
 */
public class MyDoblyLinkedList {

    private MyDLElement head;

    public void insert(MyDLElement next) {
        next.setNext(head);
        if (head != null)
            head.setPrev(next);
        head = next;
        next.setPrev(null);
    }

    public MyDLElement getHead() {
        return this.head;
    }

    public <K> MyDLElement search(K key) {

        MyDLElement tmp = getHead();

        while(tmp != null && key != tmp.getKey()) {
            tmp = tmp.getNext();
        }
        return tmp;
    }

    public void delete(MyDLElement el) {
        if (el.getPrev() != null) {
            el.getPrev().setNext(el.getNext());
            el.getNext().setPrev(el.getPrev());
        }
        else {
            this.head = el.getNext();
            this.head.setPrev(null);
            if (head.getNext() != null)
                head.getNext().setPrev(head);
        }

    }
}
