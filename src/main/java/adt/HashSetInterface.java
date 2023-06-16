/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;

/**
 *
 * @author Bryan
 */

//Done by: Loo Seng Xian
public interface HashSetInterface<T> {
    
    public boolean add(T value);
    
    public boolean remove(T value);
    
    public void clear();
    
    public boolean contains(T value);
    
    public boolean isEmpty();
    
    public int size();
    
    public String[] toArray();
 
    public Integer[] toIntArray();
    
    public String toString();
}
