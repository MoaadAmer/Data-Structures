package datastructures.queue;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by MoaadA on 9/5/2018.
 */
public class QueueAsLinkedListTests {


    QueueAsLinkedList queueAsLinkedList;


    @Test
    public void addShouldIncreaseSizeByOne() {
        //Given
        queueAsLinkedList = new QueueAsLinkedList<String>();
        var firstName = "Moaad";
        var lastName = "Amer";

        //When
        queueAsLinkedList.add(firstName);

        //Then

        Assert.assertEquals(queueAsLinkedList.getSize(), 1);

        //When
        queueAsLinkedList.add(lastName);

        //Then

        Assert.assertEquals(queueAsLinkedList.getSize(), 2);
    }

    @Test
    public void addShouldStoreValue() {
        //Given
        queueAsLinkedList = new QueueAsLinkedList<String>();
        var firstName = "Moaad";

        //When
        queueAsLinkedList.add(firstName);

        //Then

        Assert.assertEquals(queueAsLinkedList.poll(), firstName);

    }

    @Test
    public void pollShouldReturnFirstValueInserted() {
        //Given
        queueAsLinkedList = new QueueAsLinkedList<String>();
        var firstName = "Moaad";
        var lastName = "Amer";

        //When
        queueAsLinkedList.add(firstName);
        queueAsLinkedList.add(lastName);

        //Then
        Assert.assertEquals(queueAsLinkedList.poll(), firstName);

    }


    @Test
    public void pollShouldDecreaseSizeByOne() {
        //Given
        queueAsLinkedList = new QueueAsLinkedList<String>();
        var firstName = "Moaad";
        var lastName = "Amer";

        //When
        queueAsLinkedList.add(firstName);
        queueAsLinkedList.poll();

        //Then
        Assert.assertEquals(queueAsLinkedList.getSize(), 0);

    }

    @Test(expectedExceptions = QueueEmptyException.class)
    public void pollShouldThrowQueueEmptyException() {
        //Given
        queueAsLinkedList = new QueueAsLinkedList<String>();

        //When
        queueAsLinkedList.poll();
    }


    @Test
    public void peekShouldReturnFirstValueInserted() {
        //Given
        queueAsLinkedList = new QueueAsLinkedList<String>();
        var firstName = "Moaad";
        var lastName = "Amer";

        //When
        queueAsLinkedList.add(firstName);
        queueAsLinkedList.add(lastName);

        //Then
        Assert.assertEquals(queueAsLinkedList.peek(), firstName);

    }


    @Test
    public void peekShouldNotChangeSize() {
        //Given
        queueAsLinkedList = new QueueAsLinkedList<String>();
        var firstName = "Moaad";

        //When
        queueAsLinkedList.add(firstName);
        queueAsLinkedList.peek();

        //Then
        Assert.assertEquals(queueAsLinkedList.getSize(), 1);

    }

    @Test(expectedExceptions = QueueEmptyException.class)
    public void peekShouldThrowQueueEmptyException() {
        //Given
        queueAsLinkedList = new QueueAsLinkedList<String>();

        //When
        queueAsLinkedList.peek();
    }


    @Test
    public void clearShouldSetSizeToZero() {

        //Given
        queueAsLinkedList = new QueueAsLinkedList<String>();
        var firstName = "Moaad";
        var lastName = "Amer";

        //When
        queueAsLinkedList.add(firstName);
        queueAsLinkedList.add(lastName);
        queueAsLinkedList.clear();

        //Then
        Assert.assertEquals(queueAsLinkedList.getSize(), 0);
    }

    @Test(expectedExceptions = QueueEmptyException.class)
    public void clearShouldRemoveAllValues() {

        //Given
        queueAsLinkedList = new QueueAsLinkedList<String>();
        var firstName = "Moaad";
        var lastName = "Amer";

        //When
        queueAsLinkedList.add(firstName);
        queueAsLinkedList.add(lastName);
        queueAsLinkedList.clear();

        //Then
        Assert.assertEquals(queueAsLinkedList.getSize(), 0);
        queueAsLinkedList.poll();

    }


}
