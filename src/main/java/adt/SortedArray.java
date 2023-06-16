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
public class SortedArray<T extends Comparable<T>> implements SortedArrayInterface<T> {

    private T[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 30;

    public SortedArray() {
        this(DEFAULT_CAPACITY);
    }

    public SortedArray(int capacity) {
        size = 0;
        array = (T[]) new Comparable[capacity];
    }

    //Adds elements into the array in a sorted order
    public boolean add(T newData) {
        int i = 0;
        while (i < size && newData.compareTo(array[i]) < 0) {
            i++;
        }
        makeRoom(i + 1);
        array[i] = newData;
        size++;
        return true;
    }

    //Removes all elements from array
    public void clear() {
        size = 0;
    }

    //Check array if it contains the element
    public boolean contains(T element) {
        boolean found = false;
        for (int index = 0; !found && (index < size); index++) {
            if (element.equals(array[index])) {
                found = true;
            }
        }
        return found;
    }
    
    //Returns n elements of entries
    public int getNumberOfEntries() {
        return size;
    }

    //Check if array is empty
    public boolean isEmpty() {
        return size == 0;
    }

    //Return the array in integer type
    public Integer[] getSortedArr(){
        Object[] arr = new Object[size];
        for (int i = 0; i < size; ++i) {
            arr[i]= array[i];
        }
        Integer[] result = new Integer[size];
        for (int i=0; i<size; i++){
            result[i] = (Integer) arr[i];
        }
        return result;
    }

    public String toString() {
        String outputStr = "";
        for (int index = 0; index < size; ++index) {
            outputStr += array[index] + "\n";
        }

        return outputStr;
    }
    
    //Check if array is full
    public boolean isFull() {
        return size == array.length;
    }

    //Shifts elements to make space for new element in a specific position
    private void makeRoom(int newPosition) {
        int newIndex = newPosition - 1;
        int lastIndex = size - 1;

        for (int index = lastIndex; index >= newIndex; index--) {
            array[index + 1] = array[index];
        }
    }
    
    //Removes an element from the array
    public boolean remove(T element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(array[i])) {
                removeGap(i + 1);
                size--;
                return true;
            }
        }
        return false;
    }
    
    //Removes element at specified position and shifts remaining elements to
    //fill gap
    private void removeGap(int givenPosition) {
        int removedIndex = givenPosition - 1;
        int lastIndex = size - 1;

        for (int index = removedIndex; index < lastIndex; index++) {
            array[index] = array[index + 1];
        }
        array[lastIndex] = null;
    }
    
    //Replace first occurance of oldData to newData in the array
    public boolean replace(T oldData, T newData) {
        boolean found = false;
        int i = 0;
        while (!found && i < size) {
            int comparison = oldData.compareTo(array[i]);
            if (comparison == 0) {
                found = true;
            } else if (comparison < 0) {
                // < array[i] means not in array
                return false;
            } else {
                i++;
            }
        }
        if (found) {
            array[i] = newData;
            return true;
        } else {
            return false;
        }
    }
    
    
    @Override
    public boolean replace() {
        return false;
    }
}
