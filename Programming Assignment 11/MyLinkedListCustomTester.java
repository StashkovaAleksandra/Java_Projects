
/**
 * Name: Aleksandra Stashkova
 * ID: A16559377
 * Email: astashko@ucsd.edu
 * Sources used: Zybooks and Lecture Slides
 * 
 * This file includes the custom tests written by myself in order to test edge-cases for methods implemented in
 * MyLinkedList. These tests do NOT cover any of the tests provided in the Public Tester.
 *
 */

import static org.junit.Assert.*;
import org.junit.*;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * The class includes such variables as threeElem, and emptyList being a part of MyLinkedList and two iterators.
 * 
 * IMPORTANT: Do not change the method headers and points are awarded
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class MyLinkedListCustomTester {
    MyLinkedList <Integer> threeElem, emptyList;
    ListIterator <Integer> threeElemIter, emptyListIter;

    /**
     * This sets up the test fixture. JUnit invokes this method before
     * every testXXX method. The @Before tag tells JUnit to run this method
     * before each test.
     */
    @Before
    public void setUp() throws Exception {
        threeElem = new MyLinkedList<>();
        threeElem.add(1);
        threeElem.add(2);
        threeElem.add(3);
        threeElemIter = threeElem.listIterator();
        emptyList = new MyLinkedList<>();
        emptyListIter = emptyList.listIterator();
    }

    /**
     * Tests the hasNext method when we are checking if an empty list does not actually have a next element.
     */
    @Test
    public void testHasNext() {
        assertFalse("Checking if an empty list doesn't have a next element", emptyListIter.hasNext());
    }

    /**
     * Tests the next method on an empty list. The tester will return fail if we are trying to call a method on an empty
     * list.
     */
    @Test
    public void testNext() {
        try {
            emptyListIter.next();
            fail();
        }
        catch (NoSuchElementException e){
            //
        }

    }

    /**
     * Tests the hasPrevious method when the method hasPrevious is being called on an empty list.
     */
    @Test
    public void testHasPrevious() {
        assertFalse("Checking if an empty list doesn't have a previous element", emptyListIter.hasPrevious());
    }

    /**
     * Tests the previous method when a method testPrevious is being called on iterator of an empty list.
     */
    @Test
    public void testPrevious() {
        try {
            emptyListIter.previous();
            fail();
        }
        catch (NoSuchElementException e){
            //
        }
    }

    /**
     * Tests the testNextIndex method when it is being called on an empty list.
     */
    @Test
    public void testNextIndex() {
        assertEquals("Checks if there is no next index", 0, emptyListIter.nextIndex());
    }

    /**
     * Tests the testPreviousIndex method when it is being called on an empty list.
     */
    @Test
    public void testPreviousIndex() {
        assertEquals("Checks if there is no next index", -1, emptyListIter.previousIndex());
    }

    /**
     * Testing two possible exceptions of a set method.
     */
    @Test
    public void testSet() {
        try {
            threeElemIter.set(5);
            fail();
        }
        catch (IllegalStateException e){
            //
        }
        try {
            threeElemIter.next();
            threeElemIter.set(null);
            fail();
        }
        catch (NullPointerException e){
            //
        }
    }

    /**
     * Test a method if we dont specify what to remove.
     */
    @Test
    public void testRemoveTestOne() {
        try {
            threeElemIter.remove();
            fail();
        }
        catch (IllegalStateException e){
            //
        }
    }

    /**
     * Tests how a method would behave when we remove right after adding.
     */
    @Test
    public void testRemoveTestTwo() {
        try {
            threeElemIter.next();
            threeElemIter.add(5);
            threeElemIter.remove();
            fail();
        }
        catch (IllegalStateException e){
            //
        }
    }

    /**
     * Testing how a method would behave if we add a null.
     */
    @Test
    public void testAdd() {
        try {
            threeElemIter.add(null);
            fail();
        }
        catch (NullPointerException e){
            //
        }
    }

}