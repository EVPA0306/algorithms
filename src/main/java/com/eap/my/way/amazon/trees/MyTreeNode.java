package com.eap.my.way.amazon.trees;

/**
 * Created by evgenypavlenko on 2/16/17.
 */
public class MyTreeNode {

    private int index;
    private int key;

    private MyTreeNode parent;
    private MyTreeNode left;
    private MyTreeNode right;


    public MyTreeNode(int index, int key, MyTreeNode parent, MyTreeNode left, MyTreeNode right) {
        this.index = index;
        this.key = key;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public MyTreeNode getParent() {
        return parent;
    }

    public void setParent(MyTreeNode parent) {
        this.parent = parent;
    }

    public MyTreeNode getLeft() {
        return left;
    }

    public void setLeft(MyTreeNode left) {
        this.left = left;
    }

    public MyTreeNode getRight() {
        return right;
    }

    public void setRight(MyTreeNode right) {
        this.right = right;
    }
}
