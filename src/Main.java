import myCollection.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Test MyArray
        String s = " fdd";
//        MyArrayList<String> arr= new MyArrayList<>();
//        arr.add(s);
//        System.out.println(arr.get(0));
//        arr.add("434");
//        arr.remove("434");
//        System.out.println(arr.get(1)+" ");
//        arr.clear();
//        System.out.println(arr.size());

        //Test MyLinekedList
//        LinkedList<String> linkedList = new LinkedList<>();
//        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
//        myLinkedList.add(s);
//        System.out.println(myLinkedList.get(0));
        //Test MyQueue
//        MyQueue<String> queue = new MyQueue<>();
//        queue.add(s);
//        queue.add("54583");
//        System.out.println(queue.peek()+ queue.poll()+" "+queue.peek());
//        queue.clear();
//        System.out.println(queue.peek());
        //Test Stack
//        MyStack<String> stack= new MyStack<>();
//        stack.push(s);
//        stack.push("dfs");
//        stack.push("acs");
//        System.out.println(stack.pop()+" "+stack.peek()+" "+stack.peek()+" "+ stack.pop());
//        stack.clear();
//        System.out.println(stack.pop());
        //Test HashMap
        HashMap<String,String> hashMap = new HashMap<>();
        System.out.println(hashMap.put("key","Value")+" "+ hashMap.put("key","text"));
        MyHashMap<String,String> myHashMap= new MyHashMap<>();
        System.out.println(myHashMap.put("key","Value")+" "+ myHashMap.get("key")+" " );
        myHashMap.remove("key");
        System.out.println(myHashMap.get("key")+" " );
        myHashMap.put("key","Value");
        myHashMap.put("tey","Value");
        myHashMap.put("qey","Value");
        System.out.println(myHashMap.size());
        myHashMap.clear();
        System.out.println(myHashMap.size());
    }
}