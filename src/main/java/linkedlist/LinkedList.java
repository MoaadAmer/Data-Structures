package linkedlist;

public class LinkedList<T> {


    private Node<T> head, tail;
    private int count;

    public void addFirst(T item) {
        var node = new Node<>(item);
        addFirst(node);
    }

    public void addFirst(final Node<T> node) {

        if (count == 0) {
            head = tail = node;
        } else {
            Node<T> temp = head;

            head = node;
            head.next = temp;
        }
        count++;
    }


    public void addLast(T item) {
        var node = new Node<>(item);
        addLast(node);
    }

    public void addLast(final Node<T> node) {

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

    public boolean remove(T item) {

        Node<T> prevNode = null;
        for (Node<T> currentNode = head; currentNode != null; currentNode = currentNode.next) {
            if (currentNode.value.equals(item)) {
                if (prevNode == null) {
                    removeFirst();
                } else {
                    prevNode.next = currentNode.next;
                    if (currentNode.next == null) {
                        tail = prevNode;
                    }
                    count--;
                }

                return true;
            }
            prevNode = currentNode;
        }

        return false;
    }


    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public int getCount() {
        return count;
    }


    public boolean contains(T item) {

        for (Node<T> currentNode = head; currentNode != null; currentNode = currentNode.next) {
            if (currentNode.value.equals(item))
                return true;
        }

        return false;
    }

    public void clear() {

        head = tail = null;
        count = 0;
    }
}
