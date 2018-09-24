package trees;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class BinaryTreeTests {

    BinaryTree<Integer> binaryTree;

    @BeforeMethod
    public void init() {
        binaryTree = new BinaryTree();

    }

    @Test
    public void whenAddingFirstElementShouldBeAParentNode() {

        //When
        binaryTree.add(1);

        //Then
        assertEquals(binaryTree.getRoot().getValue(), 1);
    }


    @Test
    public void biggerValueShouldGoToTheRight() {

        //When
        binaryTree.add(1);
        binaryTree.add(2);


        //Then
        assertEquals(binaryTree.getRoot().getRightNode().getValue(), 2);

    }

    @Test
    public void smallerValueShouldGoToTheLeft() {

        //When
        binaryTree.add(1);
        binaryTree.add(0);


        //Then
        assertEquals(binaryTree.getRoot().getLeftNode().getValue(), 0);

    }

    @Test
    public void whenAddingValueSizeShouldIncreaseByOne() {

        //When
        binaryTree.add(2);

        //Then
        assertEquals(binaryTree.getSize(), 1);

        //When
        binaryTree.add(1);

        //Then
        assertEquals(binaryTree.getSize(), 2);

        //When
        binaryTree.add(0);

        //Then
        assertEquals(binaryTree.getSize(), 3);
    }

    @Test
    public void contains() {

        assertFalse(binaryTree.contains(0));

        binaryTree.add(2);
        binaryTree.add(1);
        binaryTree.add(3);

        assertTrue(binaryTree.contains(1));
        assertTrue(binaryTree.contains(2));
        assertTrue(binaryTree.contains(3));


    }


    @Test
    public void removeValueThatDoesNotExistWillReturnFalse() {
        //Given
        binaryTree.add(5);
        binaryTree.add(3);
        binaryTree.add(2);
        binaryTree.add(6);
        binaryTree.add(4);


        //When
        boolean status = binaryTree.remove(7);

        //Then
        assertFalse(status);
    }

    @Test
    public void removeNodeWhichIsALeafShouldUpdateParentNode() {
        //Given
        binaryTree.add(1);
        binaryTree.add(0);
        binaryTree.add(2);

        //When & Then
        assertEquals(binaryTree.remove(0), true);
        assertEquals(binaryTree.remove(2), true);

        //Then
        assertEquals(binaryTree.getRoot().getLeftNode(), null);
        assertEquals(binaryTree.getRoot().getRightNode(), null);
        assertEquals(binaryTree.getRoot().getValue(), 1);
        assertEquals(binaryTree.getSize(), 1);


    }

    @Test
    public void removeNodeWhichHasOneChildOnlyShouldReplaceIt() {

        //Given
        binaryTree.add(6);
        binaryTree.add(5);
        binaryTree.add(3);
        binaryTree.add(7);
        binaryTree.add(8);

        //When & Then
        assertEquals(binaryTree.remove(5), true);
        assertEquals(binaryTree.remove(7), true);

        //Then
        assertEquals(binaryTree.getRoot().getValue(), 6);
        assertEquals(binaryTree.getRoot().getLeftNode().getValue(), 3);
        assertEquals(binaryTree.getRoot().getRightNode().getValue(), 8);
        assertFalse(binaryTree.contains(5));
        assertFalse(binaryTree.contains(7));
    }

    @Test
    public void removeNodeWhichHasTwoChildsShouldBeReplacedWithItsRightLeftMostChild() {
        //Given
        binaryTree.add(6);
        binaryTree.add(8);
        binaryTree.add(7);
        binaryTree.add(9);

        binaryTree.add(4);
        binaryTree.add(5);
        binaryTree.add(3);

        //When & Then
        assertEquals(binaryTree.remove(4), true);
        assertEquals(binaryTree.remove(8), true);

        //Then
        assertEquals(binaryTree.getRoot().getValue(), 6);
        assertEquals(binaryTree.getRoot().getLeftNode().getValue(), 5);
        assertEquals(binaryTree.getRoot().getRightNode().getValue(), 9);
        assertFalse(binaryTree.contains(4));
        assertFalse(binaryTree.contains(8));
    }

    @Test
    public void removeValueDecreaseSize() {
        //Given
        binaryTree.add(6);
        binaryTree.add(8);
        binaryTree.add(7);
        binaryTree.add(9);


        //When & Then
        assertEquals(binaryTree.remove(7), true);
        assertEquals(binaryTree.remove(9), true);

        //Then
        assertEquals(binaryTree.getSize(), 2);

    }


    @Test
    public void preOrderTraversal() {
        //Given
        binaryTree.add(5);

        binaryTree.add(3);
        binaryTree.add(4);
        binaryTree.add(2);

        binaryTree.add(7);
        binaryTree.add(6);
        binaryTree.add(8);

        //When
        List<Integer> actual = binaryTree.preOrderTraversal();
        var expected = List.of(5, 3, 2, 4, 7, 6, 8);

        assertEquals(actual, expected);

    }

    @Test
    public void inOrderTraversal() {
        //Given
        binaryTree.add(5);

        binaryTree.add(3);
        binaryTree.add(4);
        binaryTree.add(2);

        binaryTree.add(7);
        binaryTree.add(6);
        binaryTree.add(8);

        //When
        List<Integer> actual = binaryTree.inOrderTraversal();
        var expected = List.of(2, 3, 4, 5, 6, 7, 8);

        assertEquals(actual, expected);

    }


    @Test
    public void postOrderTraversal() {
        //Given
        binaryTree.add(5);

        binaryTree.add(3);
        binaryTree.add(4);
        binaryTree.add(2);

        binaryTree.add(7);
        binaryTree.add(6);
        binaryTree.add(8);

        //When
        List<Integer> actual = binaryTree.postOrderTraversal();
        var expected = List.of(2, 4, 3, 6, 8, 7, 5);

        assertEquals(actual, expected);
    }
}
