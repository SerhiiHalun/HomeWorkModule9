package myCollection;

import java.util.Arrays;

public class MyStack<E> {
    private Object[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyStack() {
        this.array = new Object[DEFAULT_CAPACITY];
    }
    public void push(E value) {
        if (size == array.length) {
            array = Arrays.copyOf(array, size * 2);
        }
        array[size++] = value;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Недопустимий індекс");
        }
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
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
            return null;
        }
        return (E) array[size - 1];
    }

    public E pop() {
        if (size == 0) {
            return null;
        }
        Object result = array[--size];
        array[size] = null;
        return (E) result;
    }




}
