package cs445.rec9.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import cs445.rec9.ListInterface;
import cs445.rec9.DoublyLinkedList;

/**
 * A class that provides sample tests of the Doubly-LinkedList
 * @author William C. Garrison III
 * @author Brian T. Nixon
 * @author Norhan Abbas
 */
public class DoubleListTest {
	ListInterface<String> stringList;
	ListInterface<Integer> intList;
	final String[] testStrings = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};

    @BeforeEach
    public void setup() {
	    stringList = new DoublyLinkedList<String>();
	    intList = new DoublyLinkedList<Integer>();
    }

    @AfterEach
    public void teardown() {
	    stringList = null;
	    intList = null;
    }

    @Test
    @DisplayName("Test add(newEntry)")
    void testAdd() {
        assertTrue(stringList.isEmpty(), "Doubly-LinkedList should be empty");
        assertTrue(intList.isEmpty(), "Doubly-LinkedList should be empty");
        for (String str : testStrings) {
            stringList.add(str);
        }
        for (int i = 0; i < 500; i++) {
            intList.add(i);
        }
        assertFalse(stringList.isEmpty(), "Doubly-LinkedList should not be empty");
        assertFalse(intList.isEmpty(), "Doubly-LinkedList should not be empty");
        assertEquals(testStrings.length, stringList.getSize(), "Doubly-LinkedList has unexpected number of elements");
        assertEquals(500, intList.getSize(), "Doubly-LinkedList has unxpected number of elements");
        for (int i = 0; i < testStrings.length; i++) {
            assertTrue(stringList.contains(testStrings[i]), "Doubly-LinkedList missing expected string");
            assertEquals(testStrings[i], stringList.get(i), "Doubly-LinkedList content in incorrect order");
        }
        for (int i = 0; i < 500; i++) {
            assertTrue(intList.contains(i), "Doubly-LinkedList missing expected int");
            assertEquals(i, intList.get(i), "Doubly-LinkedList content in incorrect order");
        }
    }

    @Test
    @DisplayName("Test add(position, newEntry)")
    void testAddAt() {
        assertTrue(stringList.isEmpty(), "Doubly-LinkedList should be empty");
        assertTrue(intList.isEmpty(), "Doubly-LinkedList should be empty");
        for (String str : testStrings) {
            stringList.add(0, str);
        }
        for (int i = 0; i < 500; i++) {
            intList.add(0, i);
        }
        assertFalse(stringList.isEmpty(), "Doubly-LinkedList should not be empty");
        assertFalse(intList.isEmpty(), "Doubly-LinkedList should not be empty");
        assertEquals(testStrings.length, stringList.getSize(), "Doubly-LinkedList has unexpected number of elements");
        assertEquals(500, intList.getSize(), "Doubly-LinkedList has unxpected number of elements");
        for (int i = testStrings.length - 1; i >= 0; i--) {
            assertTrue(stringList.contains(testStrings[i]), "Doubly-LinkedList missing expected string");
            int index = (testStrings.length - 1) - i; //needed to check in reverse order
            assertEquals(testStrings[i], stringList.get(index), "Doubly-LinkedList content in incorrect order");
        }
        for (int i = 499; i >= 0; i--) {
            assertTrue(intList.contains(i), "Doubly-LinkedList missing expected int");
            int index = (500 - 1) - i;
            assertEquals(i, intList.get(index), "Doubly-LinkedList content in incorrect order");
        }
    }

    @Test
    @DisplayName("Test remove(position)")
    void testRemove() {
        assertTrue(stringList.isEmpty(), "Doubly-LinkedList should be empty");
        assertTrue(intList.isEmpty(), "Doubly-LinkedList should be empty");
        for (String str : testStrings) {
            stringList.add(str);
        }
        for (int i = 0; i < 500; i++) {
            intList.add(i);
        }
        for (int i = 0; i < testStrings.length; i++) {
            stringList.remove(0);
            assertFalse(stringList.contains(testStrings[i]), "Doubly-LinkedList contained element that should have been removed");
        }
        for (int i = 0; i < 500; i++) {
            intList.remove(0);
            assertFalse(intList.contains(i), "Doubly-LinkedList contained element that should have been removed");
        }
        assertTrue(stringList.isEmpty(), "Doubly-LinkedList should be empty");
        assertTrue(intList.isEmpty(), "Doubly-LinkedList should be empty");
    }
}
