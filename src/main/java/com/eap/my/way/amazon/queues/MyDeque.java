package com.eap.my.way.amazon.queues;

/**
 * Created by evgenypavlenko on 2/13/17.
 */
public class MyDeque<E> {

    private E[] data;
    private int size;
    private int head;
    private int tail;
    private final int DEF_SIZE = 12;
    private int front;
    private int rear;

    public MyDeque(int size) {
        if (size <= 0)
            this.size = DEF_SIZE;
        else
            this.size = size;
        data = (E[])new Object[size];
        head = tail = 0;
        front = rear = 0;
    }

    public void enqueueFirst(E element) throws Exception  {
        if (front == size-1)
            throw new Exception("Overflown!");
       // if (front == rear) {
       //     E tmp = data[rear];
       //     data[++rear] = tmp;
       // }
        data[front++] = element;
        //rear = front;
    }

    public void enqueueLast(E element) throws Exception {
        if (rear == size-1)
            throw new Exception("Overflown!");
        data[rear++] = element;
        //front = rear;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(MyDeque.class + " [ ");
        for (E element : data) {
            stringBuilder.append(element+", ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-2);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
