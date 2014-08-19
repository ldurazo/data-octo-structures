package com.company;

public class LinkedList<Item> {
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

    public void add(Item item) {
        if (isEmpty()) {
            head = back = new Node<Item>();
            head.item = item;
            head.next = back;
            back = head;
        } else {
            back.next = new Node<Item>();
            back = back.next;
            back.item = item;
        }
        counter++;
    }

    public void add(int index, Item item) {
        if (index == size()) {
            add(item);
            return;
        } else if (index == 0) {
            holder = new Node<Item>();
            holder.item = item;
            holder.next = head;
            head = holder;
            counter++;
            return;
        }
        holder = head;
        for (int i = 0; i < index - 1; i++) {
            holder = holder.next;
        }
        Node<Item> node = new Node<Item>();
        node.item = item;
        node.next = holder.next;
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
        holder = head;
        for (int i = 0; i < size(); i++) {
            if (holder.item.equals(item)) return i;
            holder = holder.next;
        }
        return -1;
    }

    public Item remove(int index) {
        if (index >= 0 && index < size()) {
            holder = head;
            if (index == 0) {
                Item item = head.item;
                head = head.next;
                counter--;
                return item;
            } else if (index == size()) {
                counter--;
                return back.item;
            }
            for (int i = 0; i < index - 1; i++) {
                holder = holder.next;
            }
            Node<Item> temporaryNode = holder.next;
            holder.next = temporaryNode.next;
            Item item = temporaryNode.item;
            temporaryNode = null;
            counter --;
            return item;
        }
        return null;
    }

    public Item remove(Item item){
        holder = head;
        Node<Item> temporaryNode=null;
        if(head.item.equals(item)){
            head = head.next;
            counter--;
            return item;
        }
        else if(back.item.equals(item)){
            back.next = null;
            counter--;
            return item;
        }
        while(holder != null && !holder.item.equals(item)){
            temporaryNode = holder;
            holder = holder.next;
        }
        if(holder !=null && temporaryNode!=null){
            temporaryNode.next= holder.next;
            Item recycledItem = holder.item;
            holder = null;
            counter--;
            return recycledItem;
        }

        return null;
    }
}
