package trees;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class BinaryTreeTests {

    BinaryTree binaryTree;
    List<Integer> data = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

    @BeforeMethod
    public void init() {
        binaryTree = new BinaryTree();

    }

    @Test
    public void whenAddingFirstElementShouldBeAParentNode() {

        //When
        binaryTree.add(data.get(0));

        //Then
        Assert.assertEquals(binaryTree.getRoot().getValue(), data.get(0).intValue());
    }


    @Test
    public void biggerValueShouldGoToTheRight() {

        //When
        binaryTree.add(data.get(1));
        binaryTree.add(data.get(2));


        //Then
        Assert.assertEquals(binaryTree.getRoot().getRightNode().getValue(), data.get(2).intValue());

    }

    @Test
    public void smallerValueShouldGoToTheLeft() {

        //When
        binaryTree.add(data.get(1));
        binaryTree.add(data.get(0));


        //Then
        Assert.assertEquals(binaryTree.getRoot().getLeftNode().getValue(), data.get(0).intValue());

    }

    @Test
    public void whenAddingValueSizeShouldIncreaseByOne() {

        //When
        binaryTree.add(data.get(2));

        //Then
        Assert.assertEquals(binaryTree.getSize(), 1);

        //When
        binaryTree.add(data.get(1));

        //Then
        Assert.assertEquals(binaryTree.getSize(), 2);

        //When
        binaryTree.add(data.get(0));

        //Then
        Assert.assertEquals(binaryTree.getSize(), 3);
    }

    @Test
    public void searchingForNonExistingValueShouldReturnNull() {
        //When
        BinaryTreeNode node = binaryTree.find(3);

        //Then
        Assert.assertEquals(null, node);

    }


    @Test
    public void searchingForExistingValueShouldReturnIt() {

        //Given
        binaryTree.add(data.get(1));
        binaryTree.add(data.get(2));
        binaryTree.add(data.get(0));


        //When
        BinaryTreeNode node = binaryTree.find(data.get(1));

        //Then
        var rootNode = new BinaryTreeNode(data.get(1));
        rootNode.setLeftNode(new BinaryTreeNode(data.get(0)));
        rootNode.setRightNode(new BinaryTreeNode(data.get(2)));

        Assert.assertEquals(node.getValue(), rootNode.getValue());
        Assert.assertEquals(node.getRightNode().getValue(), rootNode.getRightNode().getValue());
        Assert.assertEquals(node.getLeftNode().getValue(), rootNode.getLeftNode().getValue());


        //When
        node = binaryTree.find(data.get(2));

        //Then
        Assert.assertEquals(node.getValue(), data.get(2).intValue());
        Assert.assertEquals(node.getRightNode(), null);
        Assert.assertEquals(node.getLeftNode(), null);

        //When
        node = binaryTree.find(data.get(0));

        //Then
        Assert.assertEquals(node.getValue(), data.get(0).intValue());
        Assert.assertEquals(node.getRightNode(), null);
        Assert.assertEquals(node.getLeftNode(), null);

    }
/*

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void removingValueThatDoesNotExistWillThrowException() {
        //Given
        binaryTree.add(data.get(4));
        binaryTree.add(data.get(3));
        binaryTree.add(data.get(2));
        binaryTree.add(data.get(1));
        binaryTree.add(data.get(0));
        binaryTree.add(data.get(5));

        //When
        binaryTree.remove(data.get(6));
    }*/

}
