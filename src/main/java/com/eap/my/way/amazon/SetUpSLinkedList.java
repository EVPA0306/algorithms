package com.eap.my.way.amazon;

/**
 * Created by evgenypavlenko on 2/15/17.
 */
public class SetUpSLinkedList {
    public static void main(String...args) {

        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList();
        MySLElement mySLElementEight = new MySLElement(8);
        MySLElement mySLElementFive = new MySLElement(5);
        MySLElement mySLElementSeven = new MySLElement(7);
        MySLElement mySLElementFour = new MySLElement(4);

        MySLElement tmp = mySinglyLinkedList.insert(mySLElementEight);
        tmp = mySinglyLinkedList.insert(mySLElementFive);
        tmp = mySinglyLinkedList.insert(mySLElementSeven);
        tmp = mySinglyLinkedList.insert(mySLElementFour);

        MySLElement res = mySinglyLinkedList.search(5);
        System.out.println(res !=null ? res.getKey() : "key not found");
        MySLElement del = mySinglyLinkedList.delete(res);
    }
}
