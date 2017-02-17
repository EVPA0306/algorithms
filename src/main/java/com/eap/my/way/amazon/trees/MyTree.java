package com.eap.my.way.amazon.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by evgenypavlenko on 2/16/17.
 */
public class MyTree {

    private MyTreeNode root = null;
    //private int[] arr = {18,12,15,4,10,2,7,14,21,5};
    private int[] arr = {100, 50, 25, 75, 150, 125, 110, 175};

    public MyTree() {
        for (int i=0; i < arr.length; i++) {
            int key = arr[i];//scanner.nextInt();
            root = insert(root, i, key);
        }
    }


    public static void main(String...args) {

        //Scanner scanner = new Scanner(System.in);
        MyTree myTree = new MyTree();
        System.out.println(myTree);
        System.out.println(myTree.binarySearch(myTree,150).getKey());
        System.out.println("Tree height: " + myTree.treeHeight(myTree.getRoot()));
        System.out.println("PreOrder traversal : ");
        myTree.preOrderTreeWalk(myTree.getRoot());
        System.out.println("InOrder traversal : ");
        myTree.inOrderTreeWalk(myTree.getRoot());
        System.out.println("PostOrder traversal : ");
        myTree.postOrderTreeWalk(myTree.getRoot());
        System.out.println("Minimum: " + myTree.minimun(myTree.getRoot()));
        System.out.println("Maximum: " + myTree.maximum(myTree.getRoot()));
        System.out.println("BFS: " + myTree.breadthFirstSearch( myTree,75 ) );
        //myTree.breadthFirstSearch( myTree,110 );
    }



    public MyTreeNode getRoot() {
        return this.root;
    }

    //Build a tree or insert a particular node.
    public MyTreeNode insert(MyTreeNode root, int index ,int key) {
        if (root == null)
            return new MyTreeNode(index,key,null,null,null);
        else {
            MyTreeNode currentNode;
            if ( key <= root.getKey()) {//insert to the left
                currentNode = insert(root.getLeft(), index, key);
                currentNode.setParent(root);
                root.setLeft(currentNode);
            } else {
                //insert to the right
                currentNode = insert(root.getRight(),index, key);
                currentNode.setParent(root);
                root.setRight(currentNode);
            }
            return root;
        }
    }

//Tree height O(n)
    public int treeHeight(MyTreeNode root) {
        // = tree.getRoot();
        if ( root == null)
            return 0;
        return 1 + Math.max(treeHeight(root.getLeft()),treeHeight(root.getRight()));
    }

    //Binary search
    public MyTreeNode binarySearch(MyTree tree, int key) {

        MyTreeNode root = tree.getRoot();

        if (root == null)
            return null;

        while (root != null) {
            if (root.getKey() == key)
                return root;
            if (root.getKey() < key )
                root = root.getRight();
            if (root.getKey() > key)
                root = root.getLeft();
        }
        return root;
    }

    //BFS uses queue
    public int breadthFirstSearch(MyTree tree, int key) {

        MyTreeNode root = tree.getRoot();
        Queue<MyTreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.add(root);

        int found = 0;
        while (!queue.isEmpty()) {

            MyTreeNode currentNode = queue.poll();

            if (currentNode.getKey() == key) {
                found = currentNode.getKey();
                //System.out.println(currentNode.getKey());
            }
            if (currentNode.getLeft() != null)
                queue.add(currentNode.getLeft());
            if (currentNode.getRight() != null)
                queue.add(currentNode.getRight());
            //return found;
        }
        return found;
    }

    //DFS
    //public void depthFirstSearch(MyTree tree {}

    public int minimun(MyTreeNode root) {
        while (root.getLeft() != null) {
            root = root.getLeft();
        }
        return root.getKey();
    }

    public int maximum(MyTreeNode root) {
        while (root.getRight() != null) {
            root = root.getRight();
        }
        return root.getKey();
    }


    //Post-order Tree Walk
    public void postOrderTreeWalk(MyTreeNode root) {
        if (root == null)
            return;
        postOrderTreeWalk(root.getLeft());
        postOrderTreeWalk(root.getRight());
        System.out.println(root.getKey());
    }

    //In-order Tree Walk - O(n)
    public void inOrderTreeWalk(MyTreeNode root) {
        if (root == null)
            return;
        inOrderTreeWalk(root.getLeft());
        System.out.println(root.getKey());
        inOrderTreeWalk(root.getRight());
    }

    //Pre-order Tree Walk
    public void preOrderTreeWalk(MyTreeNode root) {
        if (root == null)
            return;
        else {
            System.out.println(root.getKey());
            preOrderTreeWalk(root.getLeft());
            preOrderTreeWalk(root.getRight());
        }
    }
}



