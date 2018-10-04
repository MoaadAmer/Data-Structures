package datastructures.queue;

import datastructures.linkedlist.LinkedList;

/**
 * Created by MoaadA on 9/5/2018.
 */
public class QueueAsLinkedList<T> {

    private LinkedList<T> linkedList;

    public QueueAsLinkedList() {
        this.linkedList = new LinkedList<>();
    }


    public void add(T value) {
        linkedList.addLast(value);
    }


    public int getSize() {
        return linkedList.getCount();
    }

    public T poll() {
        if (linkedList.getCount() == 0)
            throw new QueueEmptyException();
        T value = peek();
        linkedList.removeFirst();
        return value;

    }

    public T peek() {
        if (linkedList.getCount() == 0)
            throw new QueueEmptyException();
        return linkedList.getHead().getValue();

    }

    public void clear() {
        linkedList.clear();
    }
}
