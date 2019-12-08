package Assignment1;

import java.io.*;
import java.util.*;


public class main {     

     
    public static void main(String[] args) {
    //TODO:build the hash table and insert keys using the insertKeyArray function.
        // w must be set such that 2^w-1 < A < 2^w where A1 = 554 and A2 = 1018. w = 10 satisfies both.
        int w = 10;
        Chaining table1 = new Chaining(w, 0, 554);
        Chaining table2 = new Chaining(w, 0, 1018);

        int[] keySet1 = {86, 85, 6, 97, 19, 66, 26, 14, 15, 49, 75, 64, 35, 54, 31, 9, 82, 29, 81, 13};
        int[] keySet2 = {52, 71, 34, 95, 68, 25, 44, 38, 47, 77, 92, 84, 94, 12, 61, 9, 89, 56, 28, 75};

        int numberCollisions1 = table1.insertKeyArray(keySet1);
        int numberCollisions2 = table2.insertKeyArray(keySet2);

        System.out.println("The number of collisions in the first list: " + numberCollisions1);
        System.out.println("The number of collisions in the second list: " + numberCollisions2);
    }
}