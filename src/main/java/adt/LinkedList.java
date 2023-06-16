/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;

/**
 *
 * @author enoch
 */
//Done by: Enoch Hii Chen Sheng
public class LinkedList<T> implements LinkedListInterface<T> {

    private Node<T> head;
    private int size;
    
    //Node
    private static class Node<T> {
        private T data;
        private Node<T> next;
        
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedList() {
        head = null;
        size = 0;
    }
       
    
    //iteration method
    //add new node to empty list
    //add new node to the end of linked list
    @Override
    public boolean add(T newEntry) {
        Node<T> newNode = new Node<>(newEntry);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        return true;
    }

    //add new node to existing list
    //also add new node but can be anywhere since using position
    @Override
    public boolean add(int newPosition, T newEntry) {
        boolean success = false;
        if (newPosition >= 1 && newPosition <= size + 1) {
            Node<T> newNode = new Node<>(newEntry);
            if (newPosition == 1) {
                newNode.next = head;
                head = newNode;
            } else {
                Node<T> current = head;
                for (int i = 1; i < newPosition - 1; i++) {
                    current = current.next;
                }
                newNode.next = current.next;
                current.next = newNode;
            }
            size++;
            success = true;
        }
        return success;
    }

    @Override
    public T remove(int givenPosition) {
        T result = null;
        if (givenPosition >= 1 && givenPosition <= size) {
            if (givenPosition == 1) {
                result = head.data;
                head = head.next;
            } else {
                Node<T> current = head;
                for (int i = 1; i < givenPosition - 1; i++) {
                    current = current.next;
                }
                result = current.next.data;
                current.next = current.next.next;
            }
            size--;
        }
        return result;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public boolean replace(int givenPosition, T newEntry) {
        boolean success = false;
        if (givenPosition >= 1 && givenPosition <= size) {
            Node<T> current = head;
            for (int i = 1; i < givenPosition; i++) {
                current = current.next;
            }
            current.data = newEntry;
            success = true;
        }
        return success;
    }

    
    //combine the getEntry and contains class
    //getting position of entry
    @Override
    public T getEntry(int givenPosition) {
        T result = null;
        if (givenPosition >= 1 && givenPosition <= size) {
            Node<T> current = head;
            for (int i = 1; i < givenPosition; i++) {
                current = current.next;
            }
            result = current.data;
        }
        return result;
    }

//    public boolean contains(T anEntry) {
//        boolean found = false;
//        Node<T> current = head;
//        while (!found && current != null) {
//            if (anEntry.equals(current.data)) {
//                found = true;
//            }
//            current = current.next;
//        }
//        return found;
//    }
    
    
    //recursion method
    
    //ADD
    //add into empty list
//    public boolean addR(T newEntry) {
//    head = addRecursive(head, newEntry, 1);
//    size++;
//    return true;
//    }
//
//    //add into existing list
//    public boolean addR(int newPosition, T newEntry) {
//    head = addRecursive(head, newEntry, newPosition);
//    size++;
//    return true;
//    }
//
//    
//    private Node<T> addRecursive(Node<T> current, T newEntry, int newPosition) {
//    //if empty list
//    if (newPosition == 1) {
//        Node<T> newNode = new Node<>(newEntry);
//        newNode.next = current;
//        return newNode;
//    }
//    
//    //if the position is greater than the list size
//    if (current == null) {
//        throw new IndexOutOfBoundsException("Invalid position");
//    }
//    
//    //method calls itself recursively, current.next as new current node, decrement poisiton until 1
//    current.next = addRecursive(current.next, newEntry, newPosition - 1);
//    return current;
//    }
//
//    
//    
//    
//    //REMOVE
//    public T removeR(int givenPosition) {
//    if (givenPosition < 1 || givenPosition > size) {
//        throw new IndexOutOfBoundsException("Invalid position");
//    }
//    return removeRecursive(head, givenPosition);
//}
//
//    private T removeRecursive(Node<T> current, int position) {
//    if (position == 1) {
//        T result = current.data;
//        head = current.next;
//        size--;
//        return result;
//    }
//    current.next = (Node<T>) removeRecursive(current.next, position - 1);
//    return current.data;
//}
//    
    
    @Override
    public boolean contains(T anEntry) {
        return containsRecursive(anEntry, head);
    }

    private boolean containsRecursive(T anEntry, Node<T> current) {
        if (current == null) {
            // Base case: end of the list reached without finding the element
            return false;
        } else if (anEntry.equals(current.data)) {
            // Base case: element found
            return true;
        } else {
            // Recursive case: check the rest of the list
            return containsRecursive(anEntry, current.next);
        }
    }   

    @Override
    public int getNumberOfEntries() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }
    
    public Node<T> getHead(){
        return head;
    }
    
      
}
