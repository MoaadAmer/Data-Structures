package linkedlist.doubly;

import linkedlist.LinkedList;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by MoaadA on 9/2/2018.
 */
public class DoublyLinkedListTests {

    private DoublyLinkedList doublyLinkedList;

    @BeforeMethod
    public void setup() {
        doublyLinkedList = new DoublyLinkedList<>();

    }

    @Test
    public void addFirstOnce() {

        //Given
        var item = "Moaad";

        //When
        doublyLinkedList.addFirst(item);

        //Then
        Assert.assertEquals(doublyLinkedList.getCount(), 1);
        Assert.assertEquals(doublyLinkedList.getHead().getValue(), item);
        Assert.assertEquals(doublyLinkedList.getTail().value, item);

        Assert.assertNull(doublyLinkedList.getHead().previous);
        Assert.assertNull(doublyLinkedList.getHead().next);

        Assert.assertNull(doublyLinkedList.getTail().previous);
        Assert.assertNull(doublyLinkedList.getTail().next);
    }


    @Test
    public void addFirstMulti() {

        //Given
        var item1 = "Moaad";
        var item2 = "Amer";
        var item3 = " :) ";

        //When
        doublyLinkedList.addFirst(item1);
        doublyLinkedList.addFirst(item2);
        doublyLinkedList.addFirst(item3);

        //Then
        Assert.assertEquals(doublyLinkedList.getCount(), 3);
        Assert.assertEquals(doublyLinkedList.getHead().value, item3);
        Assert.assertEquals(doublyLinkedList.getTail().value, item1);

        Assert.assertEquals(doublyLinkedList.getHead().next.getValue(), item2);
        Assert.assertNull(doublyLinkedList.getHead().previous);


        Assert.assertEquals(doublyLinkedList.getTail().previous.getValue(), item2);
        Assert.assertNull(doublyLinkedList.getTail().next);


    }


    @Test
    public void addLastOnce() {

        //Given
        var item = "Moaad";

        //When
        doublyLinkedList.addLast(item);

        //Then
        Assert.assertEquals(doublyLinkedList.getCount(), 1);
        Assert.assertEquals(doublyLinkedList.getHead().getValue(), item);
        Assert.assertEquals(doublyLinkedList.getTail().getValue(), item);


        Assert.assertNull(doublyLinkedList.getHead().previous);
        Assert.assertNull(doublyLinkedList.getHead().next);

        Assert.assertNull(doublyLinkedList.getTail().previous);
        Assert.assertNull(doublyLinkedList.getTail().next);
    }


    @Test
    public void addLastMulti() {

        //Given
        var item1 = "Moaad";
        var item2 = "Amer";
        var item3 = " :) ";

        //When
        doublyLinkedList.addLast(item1);
        doublyLinkedList.addLast(item2);
        doublyLinkedList.addLast(item3);

        //Then
        Assert.assertEquals(doublyLinkedList.getCount(), 3);
        Assert.assertEquals(doublyLinkedList.getHead().getValue(), item1);
        Assert.assertEquals(doublyLinkedList.getTail().getValue(), item3);


        Assert.assertEquals(doublyLinkedList.getHead().next.getValue(), item2);
        Assert.assertNull(doublyLinkedList.getHead().previous);


        Assert.assertEquals(doublyLinkedList.getTail().previous.getValue(), item2);
        Assert.assertNull(doublyLinkedList.getTail().next);
    }


    @Test
    public void removeFirst() {

        //Given
        var item1 = "Moaad";
        var item2 = "Amer";
        var item3 = " :) ";

        //When
        doublyLinkedList.addLast(item1);
        doublyLinkedList.addLast(item2);
        doublyLinkedList.addLast(item3);

        doublyLinkedList.removeFirst();

        //Then
        Assert.assertEquals(doublyLinkedList.getCount(), 2);
        Assert.assertEquals(doublyLinkedList.getHead().getValue(), item2);
        Assert.assertEquals(doublyLinkedList.getTail().getValue(), item3);


        Assert.assertEquals(doublyLinkedList.getHead().next.getValue(), item3);
        Assert.assertNull(doublyLinkedList.getHead().previous);


        Assert.assertEquals(doublyLinkedList.getTail().previous.getValue(), item2);
        Assert.assertNull(doublyLinkedList.getTail().next);
    }


    @Test
    public void removeLast() {

        //Given
        var item1 = "Moaad";
        var item2 = "Amer";
        var item3 = " :) ";

        //When
        doublyLinkedList.addLast(item1);
        doublyLinkedList.addLast(item2);
        doublyLinkedList.addLast(item3);

        doublyLinkedList.removeLast();

        //Then
        Assert.assertEquals(doublyLinkedList.getCount(), 2);
        Assert.assertEquals(doublyLinkedList.getHead().getValue(), item1);
        Assert.assertEquals(doublyLinkedList.getTail().getValue(), item2);


        Assert.assertEquals(doublyLinkedList.getHead().getNext().getValue(), item2);
        Assert.assertNull(doublyLinkedList.getHead().getPrevious());


        Assert.assertEquals(doublyLinkedList.getTail().getPrevious().getValue(), item1);
        Assert.assertNull(doublyLinkedList.getTail().getNext());
    }

    @Test
    public void removeSpecificItem() {
        //Given
        final int item1 = 1;
        final int item2 = 2;
        final int item3 = 11;
        final int item4 = 0;

        //When
        doublyLinkedList.addFirst(item1);
        doublyLinkedList.addFirst(item2);
        doublyLinkedList.addFirst(item3);

        //Then
        Assert.assertEquals(doublyLinkedList.remove(item1), true);
        Assert.assertEquals(doublyLinkedList.remove(item4), false);

        Assert.assertEquals(doublyLinkedList.getHead().getValue(), item3);
        Assert.assertEquals(doublyLinkedList.getTail().getValue(), item2);


        Assert.assertEquals(doublyLinkedList.getHead().getNext().getValue(), item2);
        Assert.assertNull(doublyLinkedList.getHead().getPrevious());


        Assert.assertEquals(doublyLinkedList.getTail().getPrevious().getValue(), item3);
        Assert.assertNull(doublyLinkedList.getTail().getNext());

    }


    @Test
    public void shouldNotFailWhenTryingToRemove() {

        doublyLinkedList.removeLast();
        doublyLinkedList.removeLast();
        doublyLinkedList.remove(1);

    }


    @Test
    public void contains() {
        //Given
        int item = 1;

        //When
        doublyLinkedList.addFirst(item);

        //Then
        Assert.assertEquals(doublyLinkedList.contains(item), true);

        Assert.assertEquals(doublyLinkedList.contains(item + 1), false);


    }

    @Test
    public void clear() {

        //Given
        doublyLinkedList.addFirst("Moaad");
        doublyLinkedList.addFirst("Amer");

        //When
        doublyLinkedList.clear();

        //Then
        Assert.assertEquals(doublyLinkedList.getHead(), null);
        Assert.assertEquals(doublyLinkedList.getTail(), null);
        Assert.assertEquals(doublyLinkedList.getCount(), 0);


    }

}
