/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameofthronesnetwork;

import java.util.ArrayList;

/**
 *
 * @author Ozay
 * @param <Key>
 */


public class LinearProbingHash<Key> {

    Key[] table;
    int M;
    int N; // number of full elements

    public LinearProbingHash(int M) {
        table = (Key[]) new Object[M];
        this.M = M;
    }
    
    public int hash(String t) {
        int sum =0;
        for (int i = 0; i < ((String)t).length(); i++) {
            char a = t.charAt(i);
            int b = a;
            sum += b;
        }
        int hash = 17;
        hash =  31 * hash * sum * 101;
        return hash; //will result in a positive integer.(all 1 except the sign bit.)*/
        //return ((t.hashCode() & 0x7fffffff) % M);
    }

    /*public boolean insert2(Key key) {
        int i;
        int h = hash((String)key);
        System.out.print(" hash: " + h);
        for (i = h; table[i] != null; i = (i + 1) % M) {
            if (table[i].equals(key)) {
                return true;
            }
            if (i + 1 == h) {
                return false; // table is full
            }
        }
        table[i] = key;
        N++; // increase number of stored items
        return true;
    }*/

    //contains method returns true if hash map contains the Key
    public int contains(String key) {
        int ix = hash(key)%M;
        //System.out.print(" hash : " + ix);
        int startIx = ix;

        while (table[ix] != null && (ix + 1 != startIx)) {
            if (table[ix].equals(key)) {
                return ix; //found
            }            //if (ix + 1 == startIx) return false; // starting point
            ix = (ix + 1) % M; // cycle through
            //System.out.print(" ix : " + ix);
        }
        return -1;
    }

    public boolean insert2(Key key) {
        int i;
        int h = hash((String)key)%M;
        //System.out.print(" hash: " + h);
        for (i = h; table[i] != null; i = (i + 1) % M) {
            if (table[i].equals(key)) {
                return true;
            }
            if (i + 1 == h) {
                return false; // table is full
            }
        }
        table[i] = key;
        N++; // increase number of stored items
        return true;
    }

    public String toString() {
        String s = "[";
        for (int i = 0; i < M; i++) {
            s += table[i] + ",";
        }
        return s + "]";
    }
}
