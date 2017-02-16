package com.eap.my.way.amazon;

/**
 * Created by evgenypavlenko on 2/10/17.
 */
public class MyQueue<E> {

    private E[] data;
    private int size;
    private int head;
    private int tail;
    private final int DEF_SIZE = 12;

    public MyQueue(int size) {
        if (size <= 0)
            this.size = DEF_SIZE;
        else
            this.size = size;
        data = (E[])new Object[this.size];
        head = 0;
        tail = 0;
    }

    public void enqueue(E element) {
        data[tail] = element;
        if (tail == this.size)
            tail = 0;
        else
            tail++;
    }

    public E dequeue() throws Exception{
        if (isEmpty())
            throw new Exception("Underflows!");
        E x =  data[head];
        if (head == this.size)
            head = 0;
        else
            head = head + 1;
        return x;
    }

    public boolean isEmpty() {
        return head == tail;
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(MyQueue.class + " [ ");
        for (E element : data) {
            stringBuilder.append(element+", ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-2);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
