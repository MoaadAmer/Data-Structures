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
}
