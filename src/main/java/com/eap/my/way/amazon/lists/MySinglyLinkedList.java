package com.eap.my.way.amazon.lists;

/**
 * Created by evgenypavlenko on 2/15/17.
 */
public class MySinglyLinkedList {

    private MySLElement head;

    public MySLElement getHead() {
        return this.head;
    }

    public MySLElement insert(MySLElement element) {
        element.setNext(head);
        //if (this.head == null)
        head = element;
        return this.head;
    }

    public <K> MySLElement search(K key) {

        MySLElement tmp = getHead();

        while(tmp != null && key != tmp.getKey()) {
            tmp = tmp.getNext();
        }
        return tmp;
    }

    public MySLElement delete(MySLElement deleteElement) {
        if (deleteElement == this.head) {
            this.head = this.head.getNext();
            deleteElement.setNext(null);
        } else {
            MySLElement tmp = getHead();
            while (tmp != null ) {
                if (tmp.getNext() == deleteElement) {
                    tmp.setNext(deleteElement.getNext());
                    deleteElement.setNext(null);
                }
                tmp = tmp.getNext();
            }
        }
        return head;
    }
}
