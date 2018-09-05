package linkedlist;

public class Node<T> {

    public T value;
    public Node next;

    public Node(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }

    public T getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }
}
