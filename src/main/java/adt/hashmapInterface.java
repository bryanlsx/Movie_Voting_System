/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;


/**
 *
 *@ Done By LEE PEI YEE
 * @param <K>
 * @param <V>
 * 
 */
public interface hashmapInterface<K,V> {
    
    public void put(K key, V value);
    
    public void remove(K key);
    
    public V replace(K key, V value);
    
    public V get(K key);
    
    public HashSet<K> getKeys();
    
    public boolean containsKey(K key);
     
    public int size();
    
    public boolean isEmpty();
    
    public void clear();
    
    public String toString();

    
}
