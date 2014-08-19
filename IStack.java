package com.company;


import java.util.EmptyStackException;

public class IStack<Item> {
    private LinkedList<Item> linkedList = new LinkedList<Item>();

    public boolean isEmpty() {
        return linkedList.size() == 0;
    }

    public int size() {
        return linkedList.size();
    }

    public void push(Item element) {
        linkedList.add(element);
    }

    public Item pop() {
        if(linkedList.size() == 0) throw new EmptyStackException();
        return linkedList.remove(linkedList.size()-1);
    }

    public Item peek() {
        return linkedList.getItem(linkedList.size()-1);
    }

    public int search(Item element) {
        return linkedList.indexOf(element);
    }

    public Item getItem(int index){
        return linkedList.getItem(index);
    }
}
