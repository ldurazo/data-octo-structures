package com.company;

import java.util.NoSuchElementException;

public class DoubleLinkedList<Item> {
    private Node<Item> head = null;
    private Node<Item> back = null;
    private Node<Item> holder = null;

    private int counter = 0;

    public int size() {
        return counter;
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    public void insertAtStart(Item item) {
        Node<Item> pointer = new Node<Item>();
        pointer.item = item;
        if (isEmpty()) {
            head = pointer;
            back = head;
        } else {
            pointer.next = head;
            head.previous = pointer;
            head = pointer;
        }
        counter++;
    }

    public void insertAtEnd(Item item) {
        Node<Item> pointer = new Node<Item>();
        pointer.item = item;
        if (isEmpty()) {
            head = pointer;
            back = head;
        } else {
            pointer.previous = back;
            back.next = pointer;
            back = pointer;
        }
        counter++;
    }

    public void insertAt(int index, Item item) {
        if(index == 0){
            insertAtStart(item);
            return;
        }
        if(index==size()){
            insertAtEnd(item);
            return;
        }
        holder = head;
        for (int i = 0; i < index ; i++) {
            holder = holder.next;
        }
        Node<Item> pointer = new Node<Item>();
        pointer.item = item;
        pointer.next = holder;
        pointer.previous = holder.previous;
        holder.previous = pointer;
        Node<Item> itemNode;
        itemNode=pointer.previous;
        itemNode.next = pointer;
        counter++;
    }

    public Item getItem(int index){
        if (index >= 0 && index <= size()) {
            holder = head;
            for (int i = 0; i < index; i++) {
                holder = holder.next;
            }
            return holder.item;
        }else{
            throw new IndexOutOfBoundsException();
        }
    }

    public Item getItemInReverse(int index){
        if (index >= 0 && index <= size()) {
            holder = back;
            for (int i = index; i > 0; i--) {
                holder = holder.previous;
            }
            return holder.item;
        }else{
            throw new IndexOutOfBoundsException();
        }
    }

    public int indexOf(Item item){
        holder = head;
        for (int i = 0; i < size(); i++) {
            if (holder.item.equals(item)) return i;
            holder = holder.next;
        }
        throw new NoSuchElementException(" No such element ");
    }

    public Item remove(int index) {
        if (index >= 0 && index <= size()) {
            holder = head;
            if (index == 0) {
                Item item = head.item;
                head = head.next;
                head.previous=null;
                counter--;
                return item;
            } else if (index == size()) {
                Item item = back.item;
                back = back.previous;
                back.next = null;
                counter--;
                return item;
            }
            for (int i = 0; i < index ; i++) {
                holder = holder.next;
            }
            Item item = holder.item;
            Node<Item> nextNode = holder.next;
            nextNode.previous = holder.previous;
            Node<Item> prevNode = holder.previous;
            prevNode.next = holder.next;
            counter--;
            return item;
        }else{
            throw new IndexOutOfBoundsException();
        }
    }

    public Item remove(Item item){
        return remove(indexOf(item));
    }
}
