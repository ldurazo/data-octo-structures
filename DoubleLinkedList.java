package com.company;

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

    public void insertAtEnd(Item item) {
        Node<Item> pointer = new Node<Item>();
        pointer.item = item;
        if (isEmpty()) {
            head = pointer;
            back = head;
        } else {
            holder = head.previous;
            head.previous = holder.previous;
            holder.next = head.previous;
            head.next = pointer;
            head = pointer;
        }
        counter++;
    }

    public void insertAtStart(Item item) {
        Node<Item> pointer = new Node<Item>();
        pointer.item = item;
        if (isEmpty()) {
            head = pointer;
            back = head;
        } else {
            pointer.previous = head;
            pointer.next = null;
            head = pointer;
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
        for (int i = 0; i < index - 1; i++) {
            holder = holder.next;
        }
        Node<Item> node = new Node<Item>();
        node.item = item;
        node.next = holder.next;
        node.previous = holder.previous;
        holder.next = node;
        counter++;
    }

    public Item getItem(int index) {
        if (index >= 0 && index < size()) {
            holder = head;
            for (int i = 0; i < index; i++) {
                holder = holder.next;
            }
            return holder.item;
        }
        return null;
    }

    public int indexOf(Item item) {
        holder = back;
        for (int i = size(); i > 0; i--) {
            if (holder.item.equals(item)) return i;
            holder = holder.previous;
        }
        return -1;
    }

    public Item remove(int index) {
        if (index >= 0 && index < size()) {
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
            for (int i = 0; i < index - 1; i++) {
                holder = holder.next;
            }
            Node<Item> temporaryNode = holder.next;
            holder.next = temporaryNode.next;
            temporaryNode.previous = holder.previous;
            holder.previous = temporaryNode.previous;
            Item item = temporaryNode.item;
            temporaryNode = null;
            counter --;
            return item;
        }
        return null;
    }

    public Item remove(Item item){

        return null;
    }
}
