package com.eap.my.way.amazon;

/**
 * Created by evgenypavlenko on 2/10/17.
 */
public class MyStack<E> {
    private E[] data;
    private int size;
    private int top;
    private final int DEF_SIZE = 12;

    public MyStack(int size) {
        if (size <= 0)
            this.size = DEF_SIZE;
        else
            this.size = size;
        data = (E[]) new Object[size];
        top = 0;
    }

    public boolean isEmpty() {
        if(top == 0)
            return true;
        else
            return false;
    }

    public void push(E element) {
        data[top++] = element;
    }

    public E pop() throws Exception {
        if (isEmpty())
            throw new Exception("Underflow");
        else
        return data[--top];
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ");
        for (E element: data) {
            stringBuilder.append(element+", ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-2);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
