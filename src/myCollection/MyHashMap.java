package myCollection;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public class MyHashMap<K, V> {


    static final  int DEFAULT_CAPACITY = 16;
    Node<K, V>[] table;
    int size;
    public MyHashMap() {
        table = new Node[DEFAULT_CAPACITY];
    }
    static class Node<K, V>{
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
        public final String toString() { return key + "=" + value; }
        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;

            return o instanceof Map.Entry<?, ?> e
                    && Objects.equals(key, e.getKey())
                    && Objects.equals(value, e.getValue());
        }
    }

    public boolean put(K key, V value) {
        int hash = hash(key);
        int index = getIndex(hash, table.length);

        Node<K, V> newNode = new Node<>(hash, key, value, null);
        if (table[index] == null) {
            table[index] = newNode;
            size++;
        } else {
            Node<K, V> current = table[index];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return false;
                }
                current = current.next;
            }
            if (current.key.equals(key)) {
                current.value = value;
            } else {
                current.next = newNode;
                size++;
            }
        }
        return false;
    }


    public void remove(K key) {
        int hash = hash(key);
        int index = getIndex(hash, table.length);

        Node<K, V> current = table[index];
        Node<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }


    public void clear() {
        Arrays.fill(table, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        int hash = hash(key);
        int index = getIndex(hash, table.length);

        Node<K, V> current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }

    private int hash(K key) {
        return key == null ? 0 : key.hashCode();
    }

    private int getIndex(int hash, int tableLength) {
        return hash & (tableLength - 1);
    }
}
