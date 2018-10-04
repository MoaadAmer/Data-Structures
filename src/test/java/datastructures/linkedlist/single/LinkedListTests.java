package datastructures.linkedlist.single;

import datastructures.linkedlist.LinkedList;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinkedListTests {

    private LinkedList linkedList;

    @BeforeMethod
    public void setup() {
        linkedList = new LinkedList<>();

    }

    @Test
    public void addFirstOnce() {

        //Given
        var item = "Moaad";

        //When
        linkedList.addFirst(item);

        //Then
        Assert.assertEquals(linkedList.getCount(), 1);
        Assert.assertEquals(linkedList.getHead().value, item);
        Assert.assertEquals(linkedList.getTail().value, item);

    }


    @Test
    public void addFirstMulti() {

        //Given
        var item1 = "Moaad";
        var item2 = "Amer";
        var item3 = " :) ";

        //When
        linkedList.addFirst(item1);
        linkedList.addFirst(item2);
        linkedList.addFirst(item3);

        //Then
        Assert.assertEquals(linkedList.getCount(), 3);
        Assert.assertEquals(linkedList.getHead().value, item3);
        Assert.assertEquals(linkedList.getTail().value, item1);
    }


    @Test
    public void addLastOnce() {

        //Given
        var item = "Moaad";

        //When
        linkedList.addLast(item);

        //Then
        Assert.assertEquals(linkedList.getCount(), 1);
        Assert.assertEquals(linkedList.getHead().value, item);
        Assert.assertEquals(linkedList.getTail().value, item);
    }


    @Test
    public void addLastMulti() {

        //Given
        var item1 = "Moaad";
        var item2 = "Amer";
        var item3 = " :) ";

        //When
        linkedList.addLast(item1);
        linkedList.addLast(item2);
        linkedList.addLast(item3);

        //Then
        Assert.assertEquals(linkedList.getCount(), 3);
        Assert.assertEquals(linkedList.getHead().value, item1);
        Assert.assertEquals(linkedList.getTail().value, item3);
    }


    @Test
    public void removeFirst() {

        //Given
        var item1 = "Moaad";
        var item2 = "Amer";
        var item3 = " :) ";

        //When
        linkedList.addLast(item1);
        linkedList.addLast(item2);
        linkedList.addLast(item3);

        linkedList.removeFirst();

        //Then
        Assert.assertEquals(linkedList.getCount(), 2);
        Assert.assertEquals(linkedList.getHead().value, item2);
        Assert.assertEquals(linkedList.getTail().value, item3);
    }


    @Test
    public void removeLast() {

        //Given
        var item1 = "Moaad";
        var item2 = "Amer";
        var item3 = " :) ";

        //When
        linkedList.addLast(item1);
        linkedList.addLast(item2);
        linkedList.addLast(item3);

        linkedList.removeLast();

        //Then
        Assert.assertEquals(linkedList.getCount(), 2);
        Assert.assertEquals(linkedList.getHead().value, item1);
        Assert.assertEquals(linkedList.getTail().value, item2);
    }

    @Test
    public void removeSpecificItem() {
        //Given
        int item = 1;

        //When
        linkedList.addFirst(item);
        linkedList.addFirst(item + 1);
        linkedList.addFirst(item + 10);

        //Then
        Assert.assertEquals(linkedList.remove(item), true);
        Assert.assertEquals(linkedList.remove(item + 3), false);
        Assert.assertEquals(linkedList.getHead().value, item + 10);
        Assert.assertEquals(linkedList.getTail().value, item + 1);

    }


    @Test
    public void shouldNotFailWhenTryingToRemove() {

        linkedList.removeLast();
        linkedList.removeLast();
        linkedList.remove(1);

    }


    @Test
    public void contains() {
        //Given
        int item = 1;

        //When
        linkedList.addFirst(item);

        //Then
        Assert.assertTrue(linkedList.contains(item));

        Assert.assertFalse(linkedList.contains(item + 1));


    }

    @Test
    public void clear() {

        //Given
        linkedList.addFirst("Moaad");
        linkedList.addFirst("Amer");

        //When
        linkedList.clear();

        //Then
        Assert.assertNull(linkedList.getHead());
        Assert.assertNull(linkedList.getTail());
        Assert.assertEquals(linkedList.getCount(), 0);


    }

}
