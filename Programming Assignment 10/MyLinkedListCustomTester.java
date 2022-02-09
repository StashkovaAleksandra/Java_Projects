/**
 * Name: Aleksandra Stashkova
 * Email: astashko@ucsd.edu
 * Sources used: none
 *
 * The file contains the custom tests that are written by the author.
 */

import static org.junit.Assert.*;
import org.junit.*;

/**
 * This file contains only generic method headers.
 * 
 * IMPORTANT: Do not change the method headers and points are awarded 
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class MyLinkedListCustomTester {
	MyLinkedList<Integer> fourElem, empty;
	/**
	 * This sets up the test fixture. JUnit invokes this method before
	 * every testXXX method. The @Before tag tells JUnit to run this method
	 * before each test.
	 */
	@Before
	public void setUp() throws Exception {
		fourElem = new MyLinkedList<>();
		empty = new MyLinkedList<>();

		MyLinkedList<Integer>.Node fNode =
				this.fourElem.new Node(1);
		MyLinkedList<Integer>.Node sNode =
				this.fourElem.new Node(2);
		MyLinkedList<Integer>.Node tNode =
				this.fourElem.new Node(3);
		MyLinkedList<Integer>.Node foNode =
				this.fourElem.new Node(4);

		fourElem.head.next = fNode;
		fNode.prev = fourElem.head;
		fNode.next = sNode;
		sNode.prev = fNode;
		sNode.next = tNode;
		tNode.prev = sNode;
		tNode.next = foNode;
		foNode.prev = tNode;
		foNode.next = fourElem.tail;
		fourElem.tail.prev = foNode;
		fourElem.size = 4;
	}

	/**
	 * Tests if we will have a nullpointer if we add null.
	 */
	@Test
	public void testAdd() {
		try {
			fourElem.add(null);
			fail();
		}
		catch (NullPointerException e){
			//
		}
	}

	/**
	 * Tests if we will have a nullpointer if we are adding null to the index 2.
	 */
	@Test
	public void testAddWithIndexTestOne() {
		try {
			fourElem.add(2, null);
			fail();
		}
		catch (NullPointerException e){
			//
		}
	}

	/**
	 * Tests if the list shifts correctly if two elements are added to the same index.
	 */	
	@Test
	public void testAddWithIndexTestTwo() {
		empty.add(0, 1);
		empty.add(0, 2);
		empty.add(2, 3);
		assertEquals("Checking if the 1st element is 2", empty.head.getNext().getElement(), Integer.valueOf(2));
		assertEquals("Checking if the 2nd element is 1", empty.head.getNext().getNext().getElement(), Integer.valueOf(1));
		assertEquals("Checking if the 3rd element is 3", empty.head.getNext().getNext().getNext().getElement(), Integer.valueOf(3));
	}

	/**
	 * Tests that empty list can't return anything.
	 */
	@Test
	public void testGet() {
		try {
			empty.get(0);
			fail();
		}
		catch (IndexOutOfBoundsException e){
			//
		}
	}

	/**
	 * Tests if we reached outer bounds.
	 */
	@Test
	public void testGetNth() {
		try {
			fourElem.getNth(5);
			fail();
		}
		catch (IndexOutOfBoundsException e){
			//
		}
	}

	/**
	 * Tests if we can set any value to an empty list.
	 */
	@Test
	public void testSet() {
		try {
			empty.set(0, 1);
			fail();
		}
		catch (IndexOutOfBoundsException e){
			//
		}
	}

	/**
	 * Test the remove method when removing out of bounds.
	 */
	@Test
	public void testRemoveTestOne() {
		try {
			fourElem.remove(5);
			fail();
		}
		catch (IndexOutOfBoundsException e){
			//
		}
	}
	
	/**
	 * Tests the remove method when removing inside the bounds whilst decreasing the size of the list.
	 */
	@Test
	public void testRemoveTestTwo() {
		Integer temp = fourElem.remove(3);
		assertEquals("Checking if we deleted the right element", temp, Integer.valueOf(4));
		assertEquals("Cheking if the list has the right size", fourElem.size(), 3);
	}

	/**
	 * Test the clear method when empty list is empty.
	 */
	@Test
	public void testClear() {
		empty.clear();
		assertTrue("Checking if the empty list is actually empty", empty.isEmpty());
		assertEquals("Checking if the size is 0", empty.size(), 0);
	}

	/**
	 * Test the size method if the sizes are true
	 */
	@Test
	public void testSize() {
		assertEquals("Checking if the actual sizes correlate", fourElem.size(), 4);
		assertEquals("Checking if the empty list has 0 elements", empty.size(), 0);
	}
}