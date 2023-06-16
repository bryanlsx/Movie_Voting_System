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
public class HashSet<T> implements HashSetInterface<T>{
 
    private int capacity;
    private int size;
    private Node<T>[] table;

    private static final int DEFAULT_CAPACITY = 20;
    private static final double CAP_THRESH = 0.75;

    private static class Node<T> {

        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    public HashSet() {
        this(DEFAULT_CAPACITY);
    }

    public HashSet(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        table = (Node<T>[]) new Node[capacity];
    }
    
    private int getIndex(T value) {
        return Math.abs(value.hashCode() % capacity);
    }

    //Check if not enough space then increase size
    private boolean shouldResize() {
        double loadFactor = (double) size / capacity;
        return loadFactor >= CAP_THRESH;
    }
    
    //Change size of set
    private void resizeSet() {
        int newCapacity = capacity * 2;
        Node<T>[] newTable = (Node<T>[]) new Node[newCapacity];

        for (int i = 0; i < capacity; i++) {
            Node<T> current = table[i];
            while (current != null) {
                Node<T> next = current.next;
                int newIndex = Math.abs(current.value.hashCode() % newCapacity);
                current.next = newTable[newIndex];
                newTable[newIndex] = current;
                current = next;
            }
        }

        capacity = newCapacity;
        table = newTable;
    }

    //Add value of set
    @Override
    public boolean add(T value) {
        if (contains(value)) {
            return false;
        }

        if (shouldResize()) {
            resizeSet();
        }

        int index = getIndex(value);
        Node<T> newNode = new Node<>(value);

        if (table[index] == null) {
            table[index] = newNode;
        } else {
            Node<T> current = table[index];
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        size++;
        return true;
    }

    @Override
    public boolean contains(T value) {
        int index = getIndex(value);

        Node<T> current = table[index];
        while (current != null) {
            if (current.value.equals(value)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    @Override
    public boolean remove(T value) {
        int index = getIndex(value);

        Node<T> current = table[index];
        Node<T> previous = null;

        while (current != null) {
            if (current.value.equals(value)) {
                if (previous == null) {
                    table[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            table[i] = null;
        }
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    //returns a string array
    public String[] toArray() {
        Object[] arr = new Object[size];
        int i = 0;
        for (Node<T> node : table) {
            while (node != null) {
                arr[i] = node.value;
                node = node.next;
                i++;
            }
        }
        String[] result = new String[size];
        for (i = 0; i < size; i++) {
            result[i] = (String) arr[i];
        }
        return result;
    }

    @Override
    //Returns an integer array
    public Integer[] toIntArray() {
        Object[] arr = new Object[size];
        int i = 0;
        for (Node<T> node : table) {
            while (node != null) {
                arr[i] = node.value;
                node = node.next;
                i++;
            }
        }
        Integer[] result = new Integer[size];
        for (i = 0; i < size; i++) {
            result[i] = (Integer) arr[i];
        }
        return result;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        int count = 0;
        for (Node<T> element : table) {
            if (element != null){
                sb.append(element.value);
                if (++count < size()) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
