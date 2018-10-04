package datastructures.stack;

import datastructures.linkedlist.LinkedList;

import java.util.EmptyStackException;

public class StackAsLinkedList<T> {
    private LinkedList linkedList;

    public StackAsLinkedList() {
        linkedList = new LinkedList<T>();
    }

    public void push(T value) {

        linkedList.addFirst(value);
    }

    public int getSize() {
        return linkedList.getCount();
    }

    public T pop() {
        T value = peek();
        linkedList.removeFirst();
        return value;

    }

    public T peek() {
        if (linkedList.getCount() == 0)
            throw new EmptyStackException();
        return (T) linkedList.getHead().getValue();
    }

    public void clear() {
        linkedList.clear();
    }
}
