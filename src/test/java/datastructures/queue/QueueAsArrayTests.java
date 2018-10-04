package datastructures.queue;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class QueueAsArrayTests {

    private QueueAsArray queueAsArray;
    private List<String> data;

    @BeforeClass
    public void setup() {

        queueAsArray = new QueueAsArray<String>();
        data = List.of("Moaad", "Amer", "loves", "java", ":)");

    }


    @Test
    public void whenAddingDataThenSizeIncreaseByOne() {
        //When
        queueAsArray.add(data.get(0));

        //Then
        Assert.assertEquals(queueAsArray.getSize(), 1);

        //When
        queueAsArray.add(data.get(1));

        //Then
        Assert.assertEquals(queueAsArray.getSize(), 2);

    }

    @Test
    public void whenAddingDataThenPollingItShouldBeReturnedFromFirstToLast() {
        //Given
        queueAsArray = new QueueAsArray<String>();

        //When
        queueAsArray.add(data.get(0));
        queueAsArray.add(data.get(1));

        //Then
        Assert.assertEquals(queueAsArray.poll(), data.get(0));

        //when
        queueAsArray.add(data.get(0));
        queueAsArray.add(data.get(2));


        //Then
        Assert.assertEquals(queueAsArray.poll(), data.get(1));
        Assert.assertEquals(queueAsArray.poll(), data.get(0));
        Assert.assertEquals(queueAsArray.poll(), data.get(2));


    }

    @Test
    public void whenPollingDataThenSizeDecreaseByOne() {
        //Given
        queueAsArray = new QueueAsArray<String>();
        var firstName = "Moaad";

        //When
        queueAsArray.add(firstName);
        queueAsArray.poll();

        //Then
        Assert.assertEquals(queueAsArray.getSize(), 0);

    }

    @Test(expectedExceptions = QueueEmptyException.class)
    public void pollShouldThrowQueueEmptyException() {
        //Given
        queueAsArray = new QueueAsArray<String>();

        //When
        queueAsArray.poll();

        //Then

    }


    @Test
    public void peekShouldReturnFirstValueInserted() {
        //Given
        queueAsArray = new QueueAsArray<String>();
        var firstName = "Moaad";
        var lastName = "Amer";

        //When
        queueAsArray.add(firstName);
        queueAsArray.add(lastName);

        //Then
        Assert.assertEquals(queueAsArray.peek(), firstName);

    }


    @Test
    public void peekShouldNotChangeSize() {
        //Given
        queueAsArray = new QueueAsArray<String>();
        var firstName = "Moaad";

        //When
        queueAsArray.add(firstName);
        queueAsArray.peek();

        //Then
        Assert.assertEquals(queueAsArray.getSize(), 1);

    }

    @Test(expectedExceptions = QueueEmptyException.class)
    public void peekShouldThrowQueueEmptyException() {
        //Given
        queueAsArray = new QueueAsArray<String>();

        //When
        queueAsArray.peek();
    }


    @Test
    public void clearShouldSetSizeToZero() {

        //Given
        queueAsArray = new QueueAsArray<String>();
        var firstName = "Moaad";
        var lastName = "Amer";

        //When
        queueAsArray.add(firstName);
        queueAsArray.add(lastName);
        queueAsArray.clear();

        //Then
        Assert.assertEquals(queueAsArray.getSize(), 0);
    }

    @Test(expectedExceptions = QueueEmptyException.class)
    public void clearShouldRemoveAllValues() {

        //Given
        queueAsArray = new QueueAsArray<String>();
        var firstName = "Moaad";
        var lastName = "Amer";

        //When
        queueAsArray.add(firstName);
        queueAsArray.add(lastName);
        queueAsArray.clear();


        //Then
        Assert.assertEquals(queueAsArray.getSize(), 0);
        queueAsArray.poll();

    }

}
