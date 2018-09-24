package trees;

public class Node<T extends Comparable<T>> {
    T value;
    Node leftNode;
    Node rightNode;

    public Node(T value) {
        this.value = value;
    }


    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public int compareTo(T other) {
        return this.value.compareTo(other);

    }

}
