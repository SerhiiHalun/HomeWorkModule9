package myCollection;

import java.util.LinkedList;

public class MyLinkedList <E> {
    Node<E> first;
    Node<E> last;
    int size;
    public boolean add(E e) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(l,e,null);
        last = newNode;
        if (l==null){
            first = newNode;
        }else {
            l.next = newNode;
        }
        size++;
        return true;
    }
    public boolean remove(Object o) {
        if (o == null) {
            for (MyLinkedList.Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (MyLinkedList.Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }
    public void clear() {
        for (MyLinkedList.Node<E> x = first; x != null; ) {
            MyLinkedList.Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }
    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }
    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }
    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }
    MyLinkedList.Node<E> node(int index) {
        // assert isElementIndex(index);

        if (index < (size >> 1)) {
            MyLinkedList.Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            MyLinkedList.Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }
    public int size() {
        return size;
    }
    E unlink(MyLinkedList.Node<E> x) {
        // assert x != null;
        final E element = x.item;
        final MyLinkedList.Node<E> next = x.next;
        final MyLinkedList.Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;

        return element;
    }
    private static class Node<E>{
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev,E element, Node<E> next){
            this.item = element;
            this.next = next;
            this.prev = prev;
        }

    }
}
