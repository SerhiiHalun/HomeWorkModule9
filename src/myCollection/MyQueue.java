package myCollection;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyQueue<E> {
    private Object[] array;
    private int size;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 10;
    public MyQueue() {
        this.capacity = DEFAULT_CAPACITY;
        this.array = new Object[capacity];
    }
    public void add(E value) {
        if (size == capacity) {
            capacity *= 2;
            array = Arrays.copyOf(array, capacity);
        }
        array[size++] = value;
    }
    public boolean clear() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
        return true;
    }
    public int size() {
        return size;
    }
    public E peek() {
        if (size == 0) {
            throw new NullPointerException();
        }
        return (E)array[0];
    }
    public E poll() {
        if (size == 0) {
            throw new NullPointerException();
        }
        Object result = array[0];
        System.arraycopy(array, 1, array, 0, --size);
        return (E) result;
    }

}
