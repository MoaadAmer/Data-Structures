package linkedlist.doubly;

/**
 * Created by MoaadA on 9/2/2018.
 */
public class DoublyNode<T> {

    public DoublyNode previous, next;
    public T value;

    public DoublyNode(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "DoublyNode{" +
                "previous=" + previous +
                ", next=" + next +
                ", value=" + value +
                '}';
    }

    public DoublyNode getPrevious() {
        return previous;
    }

    public void setPrevious(DoublyNode previous) {
        this.previous = previous;
    }

    public DoublyNode getNext() {
        return next;
    }

    public void setNext(DoublyNode next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
