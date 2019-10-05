package Assignment1;

import java.io.*;
import java.util.*;

public class Open_Addressing {
     public int m; // number of SLOTS AVAILABLE
     public int A; // the default random number
     int w;
     int r;
     public int[] Table;

     protected Open_Addressing(int w, int seed, int A) {

         this.w = w;
         this.r = (int) (w-1)/2 +1;
         this.m = power2(r);
         if (A==-1){
            this.A = generateRandom((int) power2(w-1), (int) power2(w),seed);
         }
        else{
            this.A = A;
        }
         this.Table = new int[m];
         for (int i =0; i<m; i++) {
             Table[i] = -1;
         }
         
     }
     
                 /** Calculate 2^w*/
     public static int power2(int w) {
         return (int) Math.pow(2, w);
     }
     public static int generateRandom(int min, int max, int seed) {     
         Random generator = new Random(); 
                 if(seed>=0){
                    generator.setSeed(seed);
                 }
         int i = generator.nextInt(max-min-1);
         return i+min+1;
     }
        /**Implements the hash function g(k)*/
        public int probe(int key, int i) {
            //TODO: implement this function and change the return statement.

            // Hash function h
            int hashFunctionH = ((A * key) % power2(w)) >> (w-r);

            // Hash function g
            int hashFunctionG = (hashFunctionH + i) % (power2(r));
        return hashFunctionG;
     }
     
     
     /**Inserts key k into hash table. Returns the number of collisions encountered*/
        public int insertKey(int key){
            //TODO : implement this and change the return statement.

            int numberCollisions = 0;

            for (int i = 0; i < m; i++) {
                int hashIndex = probe(key, i);

                // when an empty slot is found, insert the key and break the loop
                if (Table[hashIndex] == -1) {
                    Table[hashIndex] = key;
                    break;
                }
                // update the number of collisions
                else {
                    numberCollisions++;
                }

            }

            return numberCollisions;
        }
        
        /**Sequentially inserts a list of keys into the HashTable. Outputs total number of collisions */
        public int insertKeyArray (int[] keyArray){
            //TODO
            int collision = 0;
            for (int key: keyArray) {
                collision += insertKey(key);
            }
            return collision;
        }
            
         /**Inserts key k into hash table. Returns the number of collisions encountered*/
        public int removeKey(int key){
            //TODO: implement this and change the return statement
            int numberCollisions = 0;

            for (int i = 0; i < m; i++) {
                int hashIndex = probe(key, i);

                // when the key is found, it is given a value of -1
                if (Table[hashIndex] == key) {
                    Table[hashIndex] = -1;
                    break;
                }

                else {
                    numberCollisions++;
                }

            }

            return numberCollisions;
        }
}
