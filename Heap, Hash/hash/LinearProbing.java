package hash;

import java.util.Arrays;

public class LinearProbing<K,V> {
    int mod = 11;		// table size
     K[] a = (K[]) new Object[mod];
     V[] d = (V[]) new Object[mod];
     double loadfactor = 0.7;
     double arraysize = mod;
     double count = 0;

    //deciding where the value is going to be placed
    private int hash(K key)
    {
        return (key.hashCode() & 0x7fffffff) % mod;
    }


    public void add(K key, V data) {

        count++;
        //if number of element divide the arraysize is bigger than load factor, expand the capacity
        if(count / arraysize > loadfactor)
            expandCapacity();


        int position = hash(key);
        int i = position, j = 1;
        do {
            //if i spot is empty put key and value in the hash table
            if (a[i] == null ) {
                a[i] = key;
                d[i] = data;
                return;
            }

            //if key is the same store that value in i
            if (a[i].equals(key) ) {
                d[i] = data;
                return;
            }

            i = (position + j++ ) % mod;
            //move to the next location
        }while( i != position);

    }



    //if element is found, return that key value, if not return null
    public V find(K key) {
        int position = hash(key);
        int i = position, j = 1;
        //run until at the end of the hash table
        do {
            if( a[i].equals(key) ) return d[i];
            i = (position + j++) % mod;
        } while(a[i] != null &&
                i != position);
        return null;
    }

    //remove the key and the value
    public void remove(K key) {
        int position = hash(key);
        int i = position;
        if( a[i].equals(key) )
        {
            a[i] = null;
            d[i] = null;
        }
    }

    public String toString() {

        String result = "";
        for(int i =0; i< a.length; i++ ) {
            result += i + " key " + a[i] + "   ISBN " + d[i] + "\n";
        }
        return result;
    }

    //expanding the capacity of the key array and the value array and the arraysize
    private void expandCapacity()
    {
        a = Arrays.copyOf(a, a.length * 2);
        d = Arrays.copyOf(d, d.length * 2);
        arraysize *= 2;
    }

}