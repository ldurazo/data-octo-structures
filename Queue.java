package com.company;

import java.util.EmptyStackException;

public class Queue<Item> {
    private LinkedList<Item> linkedList = new LinkedList<Item>();

    public boolean isEmpty() {
        return linkedList.size() == 0;
    }

    public int size() {
        return linkedList.size();
    }

    public void enqueue(Item element) {
        linkedList.add(element);
    }

    public Item dequeue() {
        if(linkedList.size() == 0) throw new EmptyStackException();
        return linkedList.remove(0);
    }

    public int search(Item element) {
        return linkedList.indexOf(element);
    }

    public Item getItem(int index){
        return linkedList.getItem(index);
    }
}
