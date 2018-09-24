package trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T extends Comparable> {
    private Node root;

    private int size;

    public BinaryTree() {
    }

    public void add(final T value) {
        if (root == null) {
            root = new Node(value);
        } else {
            add(root, value);
        }
        size++;
    }

    public boolean contains(final T value) {

        return find(root, value) != null;

    }

    public boolean remove(T value) {
        return remove(root, value);
    }

    private void add(final Node current, final T value) {
        if (value.compareTo(current.getValue()) > 0) {
            if (current.rightNode == null) {
                current.setRightNode(new Node(value));
            } else {
                add(current.rightNode, value);
            }
        } else if (value.compareTo(current.getValue()) < 0) {
            if (current.leftNode == null) {
                current.setLeftNode(new Node(value));
            } else {
                add(current.leftNode, value);
            }
        }

    }


    Node find(final Node current, final T value) {

        if (current == null) return null;
        if (current.getValue() == value) return current;

        if (value.compareTo(current.getValue()) > 0)
            return find(current.rightNode, value);
        else return find(current.leftNode, value);

    }

    NodeWithParent findWithParent(Node current, final T value) {
        if (current == null) return null;

        var foundNode = new NodeWithParent(current, null);

        while (foundNode.node != null) {
            if (value.compareTo(foundNode.node.getValue()) > 0) {
                foundNode = new NodeWithParent(foundNode.node.rightNode, foundNode.node);
            } else if (value.compareTo(foundNode.node.getValue()) < 0) {
                foundNode = new NodeWithParent(foundNode.node.leftNode, foundNode.node);
            } else {
                break;
            }

        }
        return foundNode;
    }


    private boolean remove(Node current, T value) {
        NodeWithParent foundNode = findWithParent(current, value);
        if (foundNode.node == null) return false;

        boolean isRight = isRight(foundNode, value);
        boolean isRoot = foundNode.node == root;

        //LeafNode
        if (foundNode.node.rightNode == null && foundNode.node.leftNode == null) {
            if (isRoot)
                root = null;
            else {
                if (isRight) {
                    foundNode.parent.rightNode = null;
                } else {
                    foundNode.parent.leftNode = null;
                }
            }
        }
        //one chile node
        else if (foundNode.node.rightNode == null) {
            if (isRoot) {
                root = foundNode.node.leftNode;
            } else if (isRight) {
                foundNode.parent.rightNode = foundNode.node.leftNode;
            } else {
                foundNode.parent.leftNode = foundNode.node.leftNode;
            }

        } else if (foundNode.node.leftNode == null) {
            if (foundNode.node == root) {
                root = foundNode.node.rightNode;
            } else if (isRight) {
                foundNode.parent.rightNode = foundNode.node.rightNode;
            } else {
                foundNode.parent.leftNode = foundNode.node.rightNode;
            }

        } else {
            //Two childs Node
            NodeWithParent smallestNode = findSmallestNode(new NodeWithParent(foundNode.node.rightNode, foundNode.node));

            //detach the smallest node from its old parent
            if (smallestNode.node.getValue() == foundNode.node.rightNode.getValue()) {
                smallestNode.parent.rightNode = null;
            } else {
                smallestNode.parent.leftNode = null;
            }

            if (isRoot) {
                root = smallestNode.node;
            }
            //set parent new child
            else if (isRight) {
                foundNode.parent.rightNode = smallestNode.node;
            } else {
                foundNode.parent.leftNode = smallestNode.node;
            }

            smallestNode.node.rightNode = foundNode.node.leftNode;
            smallestNode.node.leftNode = foundNode.node.rightNode;

        }
        size--;
        return true;
    }

    private boolean isRight(NodeWithParent foundNode, T value) {

        if (foundNode.parent == null)
            return false;
        return foundNode.parent.rightNode != null && foundNode.parent.rightNode.getValue() == value ? true : false;

    }

    private NodeWithParent findSmallestNode(NodeWithParent current) {


        while (current.node.leftNode != null) {
            current.parent = current.node;
            current.node = current.node.leftNode;
        }
        return current;
    }


    public Node getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }

    public List<T> preOrderTraversal() {

        return preOrderTraversal(root, new ArrayList<>());
    }

    private List<T> preOrderTraversal(Node current, List<T> list) {
        if (current != null) {
            list.add((T) current.getValue());
            preOrderTraversal(current.getLeftNode(), list);
            preOrderTraversal(current.getRightNode(), list);
        }

        return list;
    }

    public List<T> inOrderTraversal() {

        return inOrderTraversal(root, new ArrayList<>());
    }

    private List<T> inOrderTraversal(Node current, List<T> list) {
        if (current != null) {
            inOrderTraversal(current.getLeftNode(), list);
            list.add((T) current.getValue());
            inOrderTraversal(current.getRightNode(), list);
        }

        return list;
    }

    public List<T> postOrderTraversal() {

        return postOrderTraversal(root, new ArrayList<>());

    }

    private List<T> postOrderTraversal(Node current, List<T> list) {

        if (current != null) {
            postOrderTraversal(current.getLeftNode(), list);
            postOrderTraversal(current.getRightNode(), list);
            list.add((T) current.getValue());

        }

        return list;

    }

    class NodeWithParent {
        Node node;
        Node parent;

        public NodeWithParent(Node node, Node parent) {
            this.node = node;
            this.parent = parent;
        }

    }

}
