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

        for (int i=0; i <= 12;i++) {
            System.out.println(i);
        }

        int[] arr = {100, 50, 25, 75, 150, 125, 110, 75};
        for (int i=0; i < arr.length; i++) {
            System.out.println(i+": " + arr[i]);
        }
    }

}
