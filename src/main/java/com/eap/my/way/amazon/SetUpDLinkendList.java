package com.eap.my.way.amazon;

/**
 * Created by evgenypavlenko on 2/14/17.
 */
public class SetUpDLinkendList {

    public static void main(String...args) {

        MyDoblyLinkedList myDoblyLinkedList = new MyDoblyLinkedList();
        MyDLElement<Integer> myDLElementEight = new MyDLElement<>(null,4,null);
        myDoblyLinkedList.insert(myDLElementEight);
        MyDLElement<Integer> myDLElementFive = new MyDLElement<>(null,7,null);
        myDoblyLinkedList.insert(myDLElementFive);
        MyDLElement<Integer> myDLElementSeven = new MyDLElement<>(null,5,null);
        myDoblyLinkedList.insert(myDLElementSeven);
        MyDLElement<Integer> myDLElementTen = new MyDLElement<>(null,8,null);
        myDoblyLinkedList.insert(myDLElementTen);
        //mySinglyLinkedList.insert(6);
        //mySinglyLinkedList.insert(3);

        MyDLElement el  = myDoblyLinkedList.search(5);
        System.out.println(el + ": key is " + el.getKey());

        myDoblyLinkedList.delete(el);
    }
}
