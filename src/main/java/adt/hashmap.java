/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;
import adt.HashSet;

//import java.util.Arrays;

/**
 *
 * @Done By LEE PEI YEE
 * @param <K>
 * @param <V>
 */
public class hashmap<K,V> implements hashmapInterface<K,V>{

    private int size = 0; // Current size of the map
    private final int SIZE = 16; // initial capacity of the array
    private Entry<K, V>[] table = new Entry[SIZE];//the array to hold the entries

    //Holds KeyValue Pair
    private static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Entry<K, V> getNext() {
            return next;
        }

        public void setNext(Entry<K, V> next) {
            this.next = next;
        }
    }
    
    //Get index of array based on key
    private int getIndex(K key) {
        int hash = key.hashCode();
        return (hash & 0x7FFFFFFF) % SIZE;
    }

    //get entry in the array based on key
    private Entry<K, V> getEntry(K key) {
        int index = getIndex(key);
        Entry<K, V> entry = table[index];

        while (entry != null && !entry.key.equals(key)) {
            entry = entry.next;
        }

        return entry;
    }
    
    //Put key value pair in the hashmap
    @Override
    public void put(K key, V value) {
        //hashcode
        int index = getIndex(key);
        Entry<K, V> entry = table[index];

        //if there is no linked list object (entry) in the array
        //then assign it to the array by hashing
        if (entry == null) {
            table[index] = new Entry<>(key, value);
        } else {
            while (entry.next != null && !entry.key.equals(key)) {
                entry = entry.next;
            }

            if (entry.key.equals(key)) {
                entry.value = value;
            } else {
                entry.next = new Entry<>(key, value);
            }
        }
    }
    
    //Remove entry based on given key
    @Override
    public void remove(K key) {
        int index = getIndex(key);
        Entry<K, V> entry = table[index];

        if (entry == null) {
            return;
        }

        if (entry.key.equals(key)) {
            table[index] = entry.next;
        } else {
            Entry<K, V> prev = entry;
            entry = entry.next;

            while (entry != null) {
                if (entry.key.equals(key)) {
                    prev.next = entry.next;
                    break;
                }

                prev = entry;
                entry = entry.next;
            }
        }
    }
    
    //Repalce key pair value mainly for changing username and password function
    @Override
    public V replace(K key, V value) {
        int keyBucket = getIndex(key);
        Entry<K, V> curr = table[keyBucket];
        while (curr != null) {
            if (curr.key != null && curr.key.equals(key)) {
                V oldValue = curr.value;
                curr.value = value;
                return oldValue;
            }
            curr = curr.next;
        }
        return null;
    }
    
    //Get value based on key
    @Override
    public V get(K key) {
        Entry<K, V> entry = getEntry(key);
        return entry == null ? null : entry.value;
    }
    
    //Get all the keys from the key-pair values and put it in a set
    @Override
    public HashSet<K> getKeys() {
        HashSet<K> keySet = new HashSet<>();
        for (Entry<K, V> entry : table) {
            while (entry != null) {
                keySet.add(entry.key);
                entry = entry.next;
            }
        }
        return keySet;
    }
    
    //Check hashmap whether key is present or not
    @Override
    public boolean containsKey(K key) {
        Entry<K, V> entry = getEntry(key);
        return entry != null;
    }

    //Return size of hashmap
    @Override
    public int size() {
        int size = 0;

        for (Entry<K, V> entry : table) {
            while (entry != null) {
                size++;
                entry = entry.next;
            }
        }

        return size;
    }
    
    //Check whether hashmap is empty or not
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    
    public void clear() {
        for (int i = 0; i < table.length; i++) {
        table[i] = null;
    }
        size = 0;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            Entry<K, V> entry = table[i];
            while (entry != null) {
                sb.append(i + ") " + entry.key + " -> " + entry.value + ",");
                entry = entry.next;
            }
            sb.append(i + ") null " + "\n");
        }
        return sb.toString();
    }



}
