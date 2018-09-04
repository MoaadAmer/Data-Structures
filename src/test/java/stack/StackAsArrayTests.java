package stack;

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

    @Test
    public void peekShouldThrowEmptyStackExceptionWhenEmpty() {
        //given
        stackAsArray = new StackAsArray();

        //When
        try {
            stackAsArray.peek();
        } catch (Exception e) {
            //Then
            Assert.assertTrue(e instanceof EmptyStackException);
        }


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

    @Test
    public void popShouldThrowEmptyStackExceptionWhenEmpty() {
        //given
        stackAsArray = new StackAsArray();

        //When
        try {
            stackAsArray.pop();
        } catch (Exception e) {
            //Then
            Assert.assertTrue(e instanceof EmptyStackException);
        }


    }

}
