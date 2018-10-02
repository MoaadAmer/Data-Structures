package hashtable;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by MoaadA on 9/25/2018.
 */
public class HashTablesTests {

    HashTable hashTable;

    @BeforeMethod
    public void init() {
        hashTable = new HashTable<String, String>();
    }

    @Test
    public void whenHashIsEmptyShouldReturnTrue() {
        Assert.assertTrue(hashTable.isEmpty());
    }

    @Test
    public void callingAddValueShouldBeAddedToTheHash() {

        hashTable.add("Israel", "Jerusalem");
        hashTable.add("United States of America", "Washington, D.C.");
        hashTable.add("Egypt", "Cairo");


        assertEquals(hashTable.getSize(), 3);
        assertEquals(hashTable.get("Israel"), "Jerusalem");
        assertEquals(hashTable.get("United States of America"), "Washington, D.C.");
        assertEquals(hashTable.get("Egypt"), "Cairo");

    }

    @Test
    public void addingValueWithPresentKeyShouldOverrideItWithTheNewValue() {
        hashTable.add("Moaad", "A");
        hashTable.add("Moaad", "Amer");

        assertEquals(hashTable.getSize(), 1);
        assertEquals(hashTable.get("Moaad"), "Amer");
    }


    @Test
    public void callingGetByKeyShouldReturnTheItsValue() {

        hashTable.add("Israel", "Jerusalem");
        hashTable.add("United States of America", "Washington, D.C.");
        hashTable.add("Egypt", "Cairo");
        hashTable.add("Moaad", "A");
        hashTable.add("Moaad", "Amer");

        assertEquals(hashTable.get("Israel"), "Jerusalem");
        assertEquals(hashTable.get("United States of America"), "Washington, D.C.");
        assertEquals(hashTable.get("Egypt"), "Cairo");
        assertEquals(hashTable.get("Moaad"), "Amer");

        assertEquals(hashTable.getSize(), 4);

    }


    @Test
    public void removeShouldReturnInCaseOfSuccess() {


    }

    @Test
    public void removeShouldReturnFalseInCaseTheKeyDoesNotExist() {


    }
}
