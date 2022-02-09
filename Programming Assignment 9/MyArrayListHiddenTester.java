/**
 * Name: Aleksandra Stashkova
 * ID: A16559377
 * Email: astashko@ucsd.edu
 * Sources used:  Zybooks and Lecture Slides
 * Contains only the headers and description to the hidden test cases we will use to grade
 * your MyArrayList implementation
 */

 //IMPORTANT: Do not change the headers!

import static org.junit.Assert.*;

import org.junit.*;

public class MyArrayListHiddenTester {
    MyArrayList invalidArg, fullArr, nullArr;

    /**
     * This sets up the test fixture. JUnit invokes this method before
     * every testXXX method. The @Before tag tells JUnit to run this method
     * before each test */
    @Before
    public void setUp() throws Exception {
        Object[] array = {1,2,3};
        fullArr = new MyArrayList(array);
    }

    /**
     * Aims to test the capacity argument constructor when the input
     * is not valid
     */
    @Test
    public void testConstructorInvalidArg(){
        try {
            invalidArg = new MyArrayList(-100);
        }
        catch (Exception exception) {
            assertTrue(exception instanceof IllegalArgumentException);
            return;
        }
        fail();
    }

    /**
     * Aims to test the Array argument constructor when the input
     * is null
     */
    @Test
    public void testConstructorNullArg(){
        nullArr = new MyArrayList(null);
        assertEquals("Check if array's size is zero", 0, nullArr.size);
        assertEquals("Check if array's length is zero", 5, nullArr.data.length);
    }

    /**
     * Aims to test the append method when an element is added to a full list
     * Check reflection on size and capacity
     */
    @Test
    public void testAppendAtCapacity(){
        fullArr.append(Integer.valueOf(4));
        assertEquals("Check if array's size is 4", 4, fullArr.size);
        assertEquals("Check if array's length is 3*2=6", 6, fullArr.data.length);
        assertEquals("Check if the element added after is null ", null, fullArr.data[4]);
        assertEquals("Check if the element added last", 4, fullArr.data[3]);
    }

    /**
     * Aims to test the prepend method when a null element is added
     * Checks reflection on size and capacity
     * Checks whether null was added successfully
     */
    @Test
    public void testPrependNull(){
        fullArr.prepend(null);
        assertEquals("Check if array's size is 4", 4, fullArr.size);
        assertEquals("Check if array's length is 3*2=6", 6, fullArr.data.length);
        assertEquals("Check if the first element is null", null, fullArr.data[0]);
        assertEquals("Check if the array shifted correctly", 3, fullArr.data[3]);
    }
    
    /**
     * Aims to test the insert method when input index is out of bounds
     */
    @Test
    public void testInsertOutOfBound(){
        try {
            fullArr.insert(100, 100);
        }
        catch (Exception exception) {
            assertTrue(exception instanceof IndexOutOfBoundsException);
            return;
        }
        fail();
    }

    /**
     * Insert multiple (eg. 1000) elements sequentially beyond capacity -
     * Check reflection on size and capacity
     * Hint: for loop could come in handy
     */
    @Test
    public void testInsertMultiple(){
        for (int i = 0; i < 1000; i++){
            fullArr.insert(1,i);
        }
        assertEquals("Check if array's size is 1003", 1003, fullArr.size);
        assertEquals("Check if array's length is 1536", 1536, fullArr.data.length);
        assertEquals("Check if the first element is 1", 1, fullArr.data[0]);
        assertEquals("Check if the last inserted element is 999", 999, fullArr.data[1]);
        assertEquals("Check if the elements after 1003 are null", null, fullArr.data[1003]);
    }

    /**
     * Aims to test the get method when input index is out of bound
     */
    @Test
    public void testGetOutOfBound(){
        try {
            fullArr.get(100);
        }
        catch (Exception exception) {
            assertTrue(exception instanceof IndexOutOfBoundsException);
            return;
        }
        fail();
    }

    /**
     * Aims to test the set method when input index is out of bound
     */
    @Test
    public void testSetOutOfBound(){
        try {
            fullArr.set(100, 100);
        }
        catch (Exception exception) {
            assertTrue(exception instanceof IndexOutOfBoundsException);
            return;
        }
        fail();
    }


    /**
     * Aims to test the remove method when input index is out of bound
     */
    @Test
    public void testRemoveOutOfBound(){
        try {
            fullArr.remove(100);
        }
        catch (Exception exception) {
            assertTrue(exception instanceof IndexOutOfBoundsException);
            return;
        }
        fail();
    }

    /**
     * Aims to test the expandCapacity method when 
     * requiredCapacity is strictly less than the current capacity
     */
    @Test
    public void testExpandCapacitySmaller(){
        try {
            fullArr.expandCapacity(1);
        }
        catch (Exception exception) {
            assertTrue(exception instanceof IllegalArgumentException);
            return;
        }
        fail();
    }

    /**
     * Aims to test the expandCapacity method when 
     * requiredCapacity is greater than double(2x) the current capacity
     */
    @Test
    public void testExpandCapacityExplode(){
        fullArr.expandCapacity(100);
        assertEquals("Check if array's size is 3", 3, fullArr.size);
        assertEquals("Check if array's length is 100", 100, fullArr.data.length);
        assertEquals("Check if the first element is 1", 1, fullArr.data[0]);
        assertEquals("Check if the 100th element is null", null, fullArr.data[99]);
    }

}
