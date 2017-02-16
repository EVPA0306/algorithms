package com.eap.my.way.amazon;

/**
 * Created by evgenypavlenko on 2/10/17.
 */
public class Main {
    public static void main(String...args) throws Exception {
        MyStack<Integer> myStack = new MyStack<>(6);
        //System.out.println(myStack);
        //myStack.push(4);
        //myStack.push(1);
        //myStack.push(3);
        //System.out.println(myStack);
        //System.out.println("pop: " + myStack.pop());
        //myStack.push(8);
        //System.out.println("pop: " + myStack.pop());
        //System.out.println(myStack);

        //System.out.println("pop: " + myStack.pop());
        MyQueue<Integer> myQueue = new MyQueue<>(6);
        //myQueue.enqueue(4);
        //myQueue.enqueue(1);
        ///myQueue.enqueue(3);
        //myQueue.enqueue(8);
        //myQueue.enqueue(4);
        myQueue.enqueue(13);
        System.out.println(myQueue);
        //System.out.println(myQueue);
        System.out.println("Dequeue: " + myQueue.dequeue());
        System.out.println("Dequeue: " + myQueue.dequeue());
        //myQueue.enqueue(8);
        //System.out.println("Dequeue: " + myQueue.dequeue());
        //System.out.println("Dequeue: " + myQueue.dequeue());
        //System.out.println("Dequeue: " + myQueue.dequeue());
        //System.out.println("Dequeue: " + myQueue.dequeue());
        //System.out.println("Dequeue: " + myQueue.dequeue());
        //System.out.println(myQueue);
        //System.out.println("Dequeue: " + myQueue.dequeue());
        //System.out.println(myQueue);
        //MyDeque<Integer> myDoubleQueue = new MyDeque<>(6);
        //myDoubleQueue.enqueueLast(17);
        //myDoubleQueue.enqueueFirst(10);
        //myDoubleQueue.enqueueLast(8);
        //myDoubleQueue.enqueueFirst(-9);
        //myDoubleQueue.enqueueLast(13);
        //myDoubleQueue.enqueueFirst(28);
        //System.out.println(myDoubleQueue);
    }
}
