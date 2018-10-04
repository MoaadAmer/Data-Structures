package datastructures.linkedlist.doubly;

/**
 * Created by MoaadA on 9/2/2018.
 */
public class DoublyLinkedList<T> {

    private DoublyNode head, tail;
    private int count;

    public void addFirst(T item) {
        var node = new DoublyNode<>(item);
        addFirst(node);
    }

    private void addFirst(final DoublyNode<T> node) {

        if (count == 0) {
            head = tail = node;
        } else {
            DoublyNode<T> temp = head;

            head = node;
            head.next = temp;
            temp.previous = head;
        }
        count++;
    }

    public void addLast(T item) {
        var node = new DoublyNode<>(item);
        addLast(node);
    }

    private void addLast(final DoublyNode<T> node) {

        if (count == 0) {
            head = tail = node;
        } else {
            node.previous = tail;
            tail.next = node;
            tail = node;
        }
        count++;
    }

    public void removeFirst() {

        if (count != 0) {
            count--;
            if (count == 0)
                head = tail = null;
            else {
                head = head.next;
                head.previous = null;
            }
        }
    }

    public void removeLast() {

        if (count != 0) {
            count--;
            if (count == 0) {
                head = tail = null;
            } else {
                tail = tail.previous;
                tail.next = null;
            }
        }

    }

    public boolean remove(T item) {

        for (DoublyNode<T> currentDoublyNode = head; currentDoublyNode != null; currentDoublyNode = currentDoublyNode.next) {
            if (currentDoublyNode.value.equals(item)) {
                if (currentDoublyNode.getPrevious() == null) {
                    removeFirst();
                } else if (currentDoublyNode.next == null) {
                    removeLast();
                } else {
                    currentDoublyNode.getPrevious().setNext(currentDoublyNode.getNext());
                    count--;
                }

                return true;
            }
        }

        return false;
    }


    public DoublyNode<T> getHead() {
        return head;
    }

    public DoublyNode<T> getTail() {
        return tail;
    }

    public int getCount() {
        return count;
    }

    public boolean contains(T item) {

        for (DoublyNode<T> currentDoublyNode = head; currentDoublyNode != null; currentDoublyNode = currentDoublyNode.next) {
            if (currentDoublyNode.value.equals(item))
                return true;
        }

        return false;
    }

    public void clear() {

        head = tail = null;
        count = 0;
    }

}
