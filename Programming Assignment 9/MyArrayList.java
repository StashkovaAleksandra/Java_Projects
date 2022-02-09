/**
 * Name: Aleksandra Stashkova
 * ID: A16559377
 * Email: astashko@ucsd.edu
 * Sources used:  Zybooks and Lecture Slides
 * File includes 3 constructors and methods.
 */


public class MyArrayList<E> implements MyList<E> {
    Object[] data;
    int size;
    static final int DEFAULT_CAPACITY = 5;

    public MyArrayList() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity >= 0) {
            data = new Object[initialCapacity];
        } else
            throw new IllegalArgumentException();
    }

    public MyArrayList(E[] arr) {
        if (arr == null) {
            data = new Object[DEFAULT_CAPACITY];
            size = 0;
        } else {
            data = new Object[arr.length];
            for (int i = 0; i < arr.length; i++) {
                data[i] = arr[i];
            }
            size = arr.length;
        }
    }

    public void expandCapacity(int requiredCapacity) {
        if (requiredCapacity < data.length) {
            throw new IllegalArgumentException();
        } else if (data.length != 0) {
            if (data.length * 2 < requiredCapacity) {
                Object[] data2 = new Object[requiredCapacity];
                for (int i = 0; i < data.length; i++) {
                    data2[i] = data[i];
                }
                data = data2;
            } else {
                Object[] data2 = new Object[data.length * 2];
                for (int i = 0; i < data.length; i++) {
                    data2[i] = data[i];
                }
                data = data2;
            }
        } else {
            if (DEFAULT_CAPACITY > requiredCapacity) {
                data = new Object[DEFAULT_CAPACITY];
            } else {
                data = new Object[requiredCapacity];
            }
        }

    }

    public int getCapacity() {
        return data.length;
    }

    public void insert(int index, E element) {
        if (index < 0 || index > data.length) {
            throw new IndexOutOfBoundsException();
        } else if (data.length == size) {
            expandCapacity(size + 1);
            Object[] data2 = new Object[data.length];
            for (int i = 0; i < data.length; i++) {
                if (i < index) {
                    data2[i] = data[i];
                } else if (i == index) {
                    data2[i] = element;
                } else {
                    data2[i] = data[i - 1];
                }
            }
            data = data2;
        } else {
            if (index < size) {
                Object[] data2 = new Object[data.length];
                for (int i = 0; i < data.length; i++) {
                    if (i < index) {
                        data2[i] = data[i];
                    } else if (i == index) {
                        data2[i] = element;
                    } else {
                        data2[i] = data[i - 1];
                    }
                }
                data = data2;
            } else {
                data[index] = element;
            }
        }
        size++;
    }

    public void append(E element) {
        if (data.length == size) {
            expandCapacity(size + 1);
        }
        data[size] = element;
        size++;
    }

    public void prepend(E element) {
        if (data.length == size) {
            expandCapacity(size + 1);
        }
        Object[] data2 = new Object[data.length];
        data2[0] = element;
        for (int i = 1; i < data.length; i++) {
            data2[i] = data[i - 1];
        }
        data = data2;
        size++;
    }

    public E get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IndexOutOfBoundsException();
        } else {
            return (E) data[index];
        }
    }

    public E set(int index, E element) {
        if (index < 0 || index >= data.length) {
            throw new IndexOutOfBoundsException();
        } else {
            data[index] = element;
            return (E) data[index];
        }
    }

    public E remove(int index) {
        if (index < 0 || index >= data.length) {
            throw new IndexOutOfBoundsException();
        } else {
            E deleted = (E) data[index];
            for (int i = 0; i < size - 1; i++) {
                if (i >= index) {
                    data[i] = data[i + 1];
                }
            }
            size--;
            return deleted;
        }
    }

    public int size() {
        return size;
    }
}

// Hint: the 'capacity' (length of data array) is not the same as the 'size'
// Size is the number of elements in the ArrayList, i.e., the number of valid elements in the array
