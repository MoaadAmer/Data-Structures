package trees;

public class BinaryTree {
    private BinaryTreeNode root;

    private int size;

    public BinaryTree() {
    }

    public void add(final int value) {
        if (root == null) {
            root = new BinaryTreeNode(value);
        } else {
            add(root, value);
        }
        size++;
    }

    private void add(final BinaryTreeNode current, final int value) {
        if (value > current.getValue()) {
            if (current.getRightNode() == null) {
                current.setRightNode(new BinaryTreeNode(value));
            } else {
                add(current.getRightNode(), value);
            }
        } else if (value < current.getValue()) {
            if (current.getLeftNode() == null) {
                current.setLeftNode(new BinaryTreeNode(value));
            } else {
                add(current.getLeftNode(), value);
            }
        }

    }


    public BinaryTreeNode find(final int value) {

        return find(root, value);

    }

    private BinaryTreeNode find(final BinaryTreeNode current, final int value) {

        if (current == null) return null;
        if (current.getValue() == value) return current;

        if (value > current.getValue())
            return find(current.getRightNode(), value);
        else return find(current.getLeftNode(), value);

    }

    public boolean remove(int value) {
        BinaryTreeNode foundNode = find(value);
        if (foundNode == null) throw new IllegalArgumentException("value : " + value + " Does not exist");
//        if (foundNode.getLeftNode() == null && foundNode.getRightNode() == null)
        return false;
    }


    public BinaryTreeNode getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }
}
