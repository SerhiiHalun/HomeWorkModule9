package myCollection;

import jdk.internal.util.ArraysSupport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class MyArrayList<E>{

    Object[] insideArray ;
    private  int size;

    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    public MyArrayList(){
        this.insideArray = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public boolean add(E obj){
        add(obj, insideArray, size);
        return true;
    }

    public void add(E e,Object[] elementData, int s){
        if (s == elementData.length)
            elementData = grow();
        elementData[s] = e;
        size = s + 1;
    }

    public E get(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (E)insideArray[index];
    }
    private Object[] grow(){
        return grow(size+1);
    }
    private Object[] grow(int minCapacity){
        int oldCapacity = insideArray.length;
        if(oldCapacity > 0 || insideArray != DEFAULTCAPACITY_EMPTY_ELEMENTDATA){
            int newCapacity = ArraysSupport.newLength(oldCapacity,
                    minCapacity - oldCapacity, /* minimum growth */
                    oldCapacity >> 1           /* preferred growth */);
            return insideArray= Arrays.copyOf(insideArray, newCapacity);
        } else {
            return insideArray = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
        }
    }
    public boolean remove(Object o) {
        int index = 0;
        int i = 0;
        for (Object temp : insideArray) {
            if (temp == null) {
                break;
            }
            if (!temp.equals(o) && i == 0) {
                i++;
                continue;
            }
            insideArray[index] = (E) temp;
            index++;
        }
        if (i == 0) {
            return false;
        }
        size--;
        insideArray = Arrays.copyOf(insideArray, insideArray.length - 1);
        return true;
    }
    public void clear() {
        final Object[] es = insideArray;
        for (int to = size, i = size = 0; i < to; i++)
            es[i] = null;
    }
    public int  size(){
        return size;
    }


}
