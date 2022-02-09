/**
 * Name: Aleksandra Stashkova
 * ID: A16559377
 * Email: astashko@ucsd.edu
 * File description: In the file there is a class in which it initiates the size of the array. The class consists of
 * variables such as size and method reverseRegion. The class makes sure that the list's default capacity is always at
 * 5. The class also consists of a method that returns an element by its index.
 */

/**
 * The class initializes array data with the size. The default capacity, which is a static variable. is a capacity of
 * the array by default. The class also includes a method that reverses a part of the list given two indexes.  It also
 * includes methods such as get size which returns the size of the list and the elements by its index.
 */
public class MyArrayList<E> implements MyReverseList<E> {
    static final int DEFAULT_CAPACITY = 5;
    
    Object[] data;
    int size;

    //IMPORTANT: DO NOT MODIFY THIS CONSTRUCTOR!
    //IMPORTANT: DO NOT ADD ANY MORE CONSTRUCTORS!

    /**
     * Constructor to create an array list with the given array's elements
     * @param arr - array of elements to be used to construct the ArrayList
     */
    public MyArrayList(E[] arr) {
        if (arr == null) {
            this.data = new Object[DEFAULT_CAPACITY];
        } else {
            this.data = arr.clone();
            this.size = arr.length;
        }
    }

    /**
	 * TODO: Method header comment here
	 */
    public void reverseRegion(int fromIndex, int toIndex){
       if (fromIndex < 0 || toIndex < 0 || fromIndex >= size || toIndex >= size){
           throw new IndexOutOfBoundsException();
       }
       if (fromIndex >= toIndex){
           return;
       }
       Object[] newArray = new Object[toIndex - fromIndex  + 1];
       for (int i = 0, j = toIndex; j >= fromIndex; i++, j--){
           newArray[i] = data[j];
       }
       for (int i = 0; i < newArray.length; i++){
           data[i + fromIndex] = newArray[i];
       }
    }

    @Override
    /**
     * A method that returns the number of valid elements
     * in the ArrayList 
     * @return - number of valid elements in the arraylist
     */
    public int size() {
        return this.size;
    }

    @Override
    /**
     * A method that returns an Element at the specified index
     * @param index - the index of the return Element
     * @return Element at specified index
     */
    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) data[index];
    }
}
