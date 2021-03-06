package datastructures.stack;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.EmptyStackException;

/**
 * Created by MoaadA on 9/3/2018.
 */
public class StackAsArrayTests {

    private StackAsArray stackAsArray;

    @Test
    public void countShouldIncreaseByOneAfterPush() {
        //Given
        stackAsArray = new StackAsArray<String>();
        var string = "Moaad";

        //When
        stackAsArray.push(string);

        //Then
        Assert.assertEquals(stackAsArray.getSize(), 1);

    }

    @Test
    public void valueShouldBeStoredAfterPush() {
        //Given
        stackAsArray = new StackAsArray<String>();
        var string = "Moaad";

        //When
        stackAsArray.push(string);

        //Then
        Assert.assertEquals(stackAsArray.peek(), string);
    }


    @Test
    public void valuesShouldBeStoredAfterPush() {
        //Given
        stackAsArray = new StackAsArray<String>();
        var firstName = "Moaad";
        var lastName = "Amer";
        var smiley = ":)";

        //When
        stackAsArray.push(firstName);
        stackAsArray.push(lastName);
        stackAsArray.push(smiley);


        //Then
        Assert.assertEquals(stackAsArray.peek(), smiley);
    }

    @Test
    public void peekShouldReturnLastPushedValue() {

        //Given
        stackAsArray = new StackAsArray<String>();
        var firstName = "Moaad";
        var lastName = "Amer";

        //When
        stackAsArray.push(firstName);
        stackAsArray.push(lastName);

        //Then
        Assert.assertEquals(stackAsArray.peek(), lastName);
    }

    @Test(expectedExceptions = EmptyStackException.class)
    public void peekShouldThrowEmptyStackExceptionWhenEmpty() {
        //given
        stackAsArray = new StackAsArray();

        //When
        stackAsArray.peek();
    }

    @Test
    public void countShouldDecreaseByOneAfterPop() {
        //Given
        stackAsArray = new StackAsArray<String>();
        var string = "Moaad";

        //When
        stackAsArray.push(string);
        stackAsArray.pop();

        //Then
        Assert.assertEquals(stackAsArray.getSize(), 0);

    }

    @Test(expectedExceptions = EmptyStackException.class)

    public void popShouldThrowEmptyStackExceptionWhenEmpty() {
        //given
        stackAsArray = new StackAsArray();

        //When
        stackAsArray.pop();
    }


    @Test
    public void popShouldReturnLastPushedValue() {

        //Given
        stackAsArray = new StackAsArray();
        var firstName = "Moaad";
        var lastName = "Amer";

        //When
        stackAsArray.push(firstName);
        stackAsArray.push(lastName);

        //Then
        Assert.assertEquals(stackAsArray.peek(), lastName);
    }


    @Test
    public void clearShouldSetSizeToZero() {

        //Given
        stackAsArray = new StackAsArray();
        var firstName = "Moaad";
        var lastName = "Amer";

        //When
        stackAsArray.push(firstName);
        stackAsArray.push(lastName);
        stackAsArray.clear();

        //Then
        Assert.assertEquals(stackAsArray.getSize(), 0);
    }

    @Test(expectedExceptions = EmptyStackException.class)
    public void clearShouldRemoveAllValues() {

        //Given
        stackAsArray = new StackAsArray();
        var firstName = "Moaad";
        var lastName = "Amer";

        //When
        stackAsArray.push(firstName);
        stackAsArray.push(lastName);
        stackAsArray.clear();

        //Then
        Assert.assertEquals(stackAsArray.getSize(), 0);
        stackAsArray.pop();
    }

}
