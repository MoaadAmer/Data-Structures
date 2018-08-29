package linkedlist;

public class LinkedList<T> {

    private Node<T> head, tail;
    private int count;


    public void addFirst(Node<T> node) {

        if (count == 0) {
            head = tail = node;
        } else {
            Node<T> temp = head;

            head = node;
            head.next = temp;
        }
        count++;
    }


    public void addLast(Node<T> node) {

        if (count == 0) {
            head = tail = node;
        } else {
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
            else
                head = head.next;
        }
    }


    public void removeLast() {

        if (count != 0) {
            count--;
            if (count == 0) {
                head = tail = null;
            } else {
                Node<T> node = head;
                while (node.next != tail) {
                    node = node.next;
                }
                tail = node;
                tail.next = null;
            }
        }

    }
}
