/**
 * Tests to check the implementation of reverseRegion method in MyArrayList.java
*/

//other import statements

import org.junit.*;
import static org.junit.Assert.*;

//IMPORTANT: DO NOT MODIFY THE TEST HEADERS!
/**
 * This class contains various test cases to test the reverseRegion method
 */
public class ReverseArrayListTester {
    MyArrayList <Integer> first;
    MyArrayList <String> second;
    /**
     * Run before every test
     */
    @Before
    public void setUp(){
        Integer[] arr = new Integer[6];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;
        arr[5] = 6;
        first = new MyArrayList<>(arr);

        String[] strArr = new String[4];
        strArr[0] = "Hello";
        strArr[1] = ",";
        strArr[2] = "world";
        strArr[3] = "!!!";
        second = new MyArrayList<>(strArr);
    }


    /**
     * Tests reverseRegion method when either fromIndex or toIndex
     * or both are out of bounds.
     */
    @Test
    public void testReverseIndexOutOfBounds(){
        try {
            first.reverseRegion(-100, 5);
            fail();
        }
        catch (IndexOutOfBoundsException e){
            //
        }
        try {
            first.reverseRegion(1, 5000);
            fail();
        }
        catch (IndexOutOfBoundsException e){
            //
        }
        try {
            first.reverseRegion(-100, 5000);
            fail();
        }
        catch (IndexOutOfBoundsException e){
            //
        }

    }

    /**
     * Tests reverseRegion method when
     * fromIndex > toIndex
     */
    @Test
    public void testReverseFromIndexGreater(){
        first.reverseRegion(3, 1);
        assertEquals("Checking the 2nd element", first.get(1), Integer.valueOf(2));
        assertEquals("Checking the 3d element", first.get(2), Integer.valueOf(3));
        assertEquals("Checking the 4th element", first.get(3), Integer.valueOf(4));
    }

    /**
     * Tests reverseRegion method when
     * fromIndex and toIndex are within bounds
    */
    @Test
    public void testReverseIndexWithinBounds(){
        first.reverseRegion(1, 4);
        assertEquals("Checking the 2nd element", first.get(1), Integer.valueOf(5));
        assertEquals("Checking the 3d element", first.get(2), Integer.valueOf(4));
        assertEquals("Checking the 4th element", first.get(3), Integer.valueOf(3));
        assertEquals("Checking the 5th element", first.get(4), Integer.valueOf(2));
    }

    /**
     * Testing edge cases where toIndex is equal to fromIndex.
     * Testing when both indexes are on the edge.
     * */
    @Test
    public void testReverseCustom(){
        first.reverseRegion(0, 0);
        assertEquals("Checking the 1st element remained unchanged", first.get(0), Integer.valueOf(1));
        assertEquals("Checking the 2nd element remained unchanged", first.get(1), Integer.valueOf(2));
        first.reverseRegion(0, 5);
        assertEquals("Checking the 1st element changed", first.get(0), Integer.valueOf(6));
        assertEquals("Checking the 2nd element changed", first.get(1), Integer.valueOf(5));
        assertEquals("Checking the 1st element changed", first.get(2), Integer.valueOf(4));
        assertEquals("Checking the 2nd element changed", first.get(3), Integer.valueOf(3));
        assertEquals("Checking the 1st element changed", first.get(4), Integer.valueOf(2));
        assertEquals("Checking the 2nd element changed", first.get(5), Integer.valueOf(1));
    }


}
