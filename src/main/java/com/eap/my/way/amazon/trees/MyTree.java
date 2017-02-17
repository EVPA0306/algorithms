package com.eap.my.way.amazon.trees;

import com.eap.my.way.amazon.queues.MyQueue;

import java.util.*;

/**
 * Created by evgenypavlenko on 2/16/17.
 */
public class MyTree {

    private MyTreeNode root = null;
    //private int[] arr = {18,12,15,4,10,2,7,14,21,5};
    //private int[] arr = {100, 50, 25, 75, 150, 125, 110, 175};
    private int[] arr = {20, 8, 22, 4, 12, 10, 14};

    public MyTree() {
        for (int i=0; i < arr.length; i++) {
            int key = arr[i];//scanner.nextInt();
            root = insert(root, i, key);
        }
    }


    public static void main(String...args) throws Exception {

        //Scanner scanner = new Scanner(System.in);
        MyTree myTree = new MyTree();
        System.out.println(myTree);
//        System.out.println(myTree.binarySearch(myTree,150).getKey());
        System.out.println("Tree height: " + myTree.treeHeight(myTree.getRoot()));
        System.out.println("PreOrder traversal : ");
        myTree.preOrderTreeWalk(myTree.getRoot());
        System.out.println("InOrder traversal : ");
        myTree.inOrderTreeWalk(myTree.getRoot());
        System.out.println("PostOrder traversal : ");
        myTree.postOrderTreeWalk(myTree.getRoot());
        System.out.println("Minimum: " + myTree.minimun(myTree.getRoot()));
        System.out.println("Maximum: " + myTree.maximum(myTree.getRoot()));
        System.out.println("BFS: " + myTree.breadthFirstSearch( myTree,100 ) );
        System.out.println("DFS: " + myTree.depthFirstSearch( myTree,75 ) );
        System.out.println("Lower common ancestor: " + myTree.findLowerCommonAncestor(myTree.getRoot(),14,10).getKey());
        System.out.println("Path length: " + (myTree.findPathLength(myTree.getRoot(),14)-1));
        System.out.println("Distance between 2 nodes is: " + myTree.findDistanceBetweenNodes(myTree.root,4,20));
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


    //Find a distance between 2 nodes
    public int findDistanceBetweenNodes(MyTreeNode root, int keyOne, int keyTwo) {
        int x = findPathLength(root, keyOne) - 1;
        int y = findPathLength(root, keyTwo) - 1;
        int lcaKey = findLowerCommonAncestor(root,keyOne,keyTwo).getKey();
        int lcaDistance = findPathLength(root,lcaKey) - 1;
        return (x + y) - 2 * lcaDistance;
    }   

    //Find Path length
    public int findPathLength(MyTreeNode root, int key) {
        if (root != null) {
            int x = 0;
            if ( (root.getKey() == key) || ( (x = findPathLength(root.getLeft(),key)) > 0)
                    || (x = findPathLength(root.getRight(),key)) > 0 ) {
                return x + 1;
            }
        }
        return 0;
    }

    //Find Lower Common Ancestor
    public MyTreeNode findLowerCommonAncestor(MyTreeNode root, int keyOne, int keyTwo) {
        while (root != null) {

            int key = root.getKey();
            if (key > keyOne && key > keyTwo)
                root = root.getLeft();
            else if (key < keyOne && key < keyTwo)
                root = root.getRight();
            else
                return root;
        }
        return null;
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
    public int breadthFirstSearch(MyTree tree, int key) throws Exception {

        MyTreeNode root = tree.getRoot();
        //Queue<MyTreeNode> queue = new LinkedList<>();
        MyQueue<MyTreeNode> queue = new MyQueue<>(8);
        int found = 0;
        if (root == null)
            return found;
            //queue.add(root);
            queue.enqueue(root);

        while (!queue.isEmpty()) {

            //MyTreeNode currentNode = queue.poll();
            MyTreeNode currentNode = queue.dequeue();

            if (currentNode.getKey() == key) {
                found = currentNode.getKey();
                //System.out.println(currentNode.getKey());
            }
            if (currentNode.getLeft() != null)
                //queue.add(currentNode.getLeft());
                queue.enqueue(currentNode.getLeft());
            if (currentNode.getRight() != null)
                //queue.add(currentNode.getRight());
                queue.enqueue(currentNode.getRight());
            //return found;
        }
        return found;
    }

    //DFS
    public int depthFirstSearch(MyTree tree, int key) {
        MyTreeNode root = tree.getRoot();
        Stack<MyTreeNode> stack = new Stack<>();
        int found = 0;
        //Set<MyTreeNode> visited = new HashSet<>();
        if (root == null)
            return found;
        stack.add(root);
        while (!stack.isEmpty()) {

            MyTreeNode currentNode = stack.pop();

            if (currentNode.getKey() == key)
                found = currentNode.getKey();
            if (currentNode.getLeft() != null)
                stack.add(currentNode.getLeft());
            if (currentNode.getRight() != null)
                stack.add(currentNode.getRight());
        }
        return found;
    }

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



