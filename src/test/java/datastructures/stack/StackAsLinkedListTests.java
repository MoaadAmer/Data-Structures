package datastructures.stack;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.EmptyStackException;

public class StackAsLinkedListTests {

    StackAsLinkedList stackAsLinkedList;

    @Test
    public void sizeShouldIncreaseByOneAfterPush() {
        //Given
        stackAsLinkedList = new StackAsLinkedList<String>();
        var string = "Moaad";

        //When
        stackAsLinkedList.push(string);

        //Then
        Assert.assertEquals(stackAsLinkedList.getSize(), 1);

    }

    @Test
    public void valueShouldBeStoredAfterPush() {
        //Given
        stackAsLinkedList = new StackAsLinkedList<String>();
        var string = "Moaad";

        //When
        stackAsLinkedList.push(string);

        //Then
        Assert.assertEquals(stackAsLinkedList.peek(), string);
    }


    @Test
    public void valuesShouldBeStoredAfterPush() {
        //Given
        stackAsLinkedList = new StackAsLinkedList<String>();
        var firstName = "Moaad";
        var lastName = "Amer";
        var smiley = ":)";

        //When
        stackAsLinkedList.push(firstName);
        stackAsLinkedList.push(lastName);
        stackAsLinkedList.push(smiley);


        //Then
        Assert.assertEquals(stackAsLinkedList.peek(), smiley);
    }

    @Test
    public void peekShouldReturnLastPushedValue() {

        //Given
        stackAsLinkedList = new StackAsLinkedList<String>();
        var firstName = "Moaad";
        var lastName = "Amer";

        //When
        stackAsLinkedList.push(firstName);
        stackAsLinkedList.push(lastName);

        //Then
        Assert.assertEquals(stackAsLinkedList.peek(), lastName);
    }

    @Test(expectedExceptions = EmptyStackException.class)
    public void peekShouldThrowEmptyStackExceptionWhenEmpty() {
        //given
        stackAsLinkedList = new StackAsLinkedList<String>();

        //When
        stackAsLinkedList.peek();
    }

    @Test
    public void sizeShouldDecreaseByOneAfterPop() {
        //Given
        stackAsLinkedList = new StackAsLinkedList<String>();
        var string = "Moaad";

        //When
        stackAsLinkedList.push(string);
        stackAsLinkedList.pop();

        //Then
        Assert.assertEquals(stackAsLinkedList.getSize(), 0);

    }

    @Test(expectedExceptions = EmptyStackException.class)
    public void popShouldThrowEmptyStackExceptionWhenEmpty() {
        //given
        stackAsLinkedList = new StackAsLinkedList();

        //When
        stackAsLinkedList.pop();
    }

    @Test
    public void popShouldReturnLastPushedValue() {

        //Given
        stackAsLinkedList = new StackAsLinkedList<String>();
        var firstName = "Moaad";
        var lastName = "Amer";

        //When
        stackAsLinkedList.push(firstName);
        stackAsLinkedList.push(lastName);

        //Then
        Assert.assertEquals(stackAsLinkedList.peek(), lastName);
    }


    @Test
    public void clearShouldSetSizeToZero() {

        //Given
        stackAsLinkedList = new StackAsLinkedList<String>();
        var firstName = "Moaad";
        var lastName = "Amer";

        //When
        stackAsLinkedList.push(firstName);
        stackAsLinkedList.push(lastName);
        stackAsLinkedList.clear();

        //Then
        Assert.assertEquals(stackAsLinkedList.getSize(), 0);
    }

    @Test(expectedExceptions = EmptyStackException.class)
    public void clearShouldRemoveAllValues() {

        //Given
        stackAsLinkedList = new StackAsLinkedList<String>();
        var firstName = "Moaad";
        var lastName = "Amer";

        //When
        stackAsLinkedList.push(firstName);
        stackAsLinkedList.push(lastName);
        stackAsLinkedList.clear();

        //Then
        Assert.assertEquals(stackAsLinkedList.getSize(), 0);
        stackAsLinkedList.pop();
    }

}
