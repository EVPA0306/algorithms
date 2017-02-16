package com.eap.my.way.amazon;

/**
 * Created by evgenypavlenko on 2/13/17.
 */
public class SimpleArray {
    public static void main(String[] args) {
        int[] data = new int[6];
        //Fills an array from tail to head
        for (int i= data.length-1; i >= 0; i--) {
            data[i] = i+1;
        }
    }

}
