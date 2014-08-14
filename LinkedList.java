package com.company;

public class LinkedList<Item> {
    //Nodes, head will point to the first in the list, back to the newest one, and holder may come handy
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
            //if the list is empty, head and back are the same, but then the back is passed forward to a new node
            head = back = new Node<Item>();
            head.item = item;
            head.next = back;
            //back becomes the head and there is an empty node next to it
            back = head;
        } else {
            //back.next creates a new node, with an empty item but ready to be filled
            back.next = new Node<Item>();
            //sets the value of the node to the newly created node
            back = back.next;
            back.item = item;
        }
        //the size increases
        counter++;
    }

    public void add(int index, Item item) {
        if (index == size()) {
            //if the requests item is at the current size, we simply add a new one.
            add(item);
            return;
        } else if (index == 0) {
            //the holder creates a new node and gets filled with the item, to replace first position
            holder = new Node<Item>();
            holder.item = item;
            //the holder sets after the head. so the head can take the value of the holder and become the new head
            holder.next = head;
            head = holder;
            counter++;
            return;
        }
        //if the new item isnt either on the first or last place, holder becomes first and we start moving
        //it until it finds the desired index.
        holder = head;
        for (int i = 0; i < index - 1; i++) {
            holder = holder.next;
        }
        // we now have holder exactly on the desired index value, then we create the new node
        Node<Item> node = new Node<Item>();
        node.item = item;
        node.next = holder.next;
        holder.next = node;
        counter++;
    }

    public Item getItem(int index) {
        //we simply get the index of a value by going through the list
        //if the index is out of bounds, we will give them a null so they can hate us, yey!
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
        //we now search an item in the nodes and return the index of the node where it was, if it isnt there
        //we give them a -1, bitches love -1's
        holder = head;
        for (int i = 0; i < size(); i++) {
            if (holder.item.equals(item)) return i;
            holder = holder.next;
        }
        return -1;
    }

    public Item remove(int index) {
        //the remove is tricky, if they give us invalid index, we give them a null
        if (index >= 0 && index < size()) {
            holder = head;
            if (index == 0) {
                //if they want the first index, we take head and point to the next one, no turn back now.
                //but we still return the value that was deleted because we are merciful gods.
                Item item = head.item;
                head = head.next;
                counter--;
                return item;
            } else if (index == size()) {
                //if they want the last one added, the same.
                counter--;
                return back.item;
            }
            //if they want to give us some headaches, we search for the index desired and put the holder in
            // the desired position, then we create a new node a make a transaction to nulify that node.
            for (int i = 0; i < index - 1; i++) {
                holder = holder.next;
            }
            Node<Item> temporaryNode = holder.next;
            //here we make the holder skip the node that wants to be deleted, thats the way it rolls
            //so that node will be lost into oblivion, and then uninitialized to point to a null
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
        //the head has the item they desire? burn it.
        if(head.item.equals(item)){
            head = head.next;
            counter--;
            return item;
        }
        //the tails does? burn it then.
        else if(back.item.equals(item)){
            back.next = null;
            counter--;
            return item;
        }
        //not the back nor the head? search for that motherfucker
        while(holder != null && !holder.item.equals(item)){
            temporaryNode = holder;
            holder = holder.next;
        }
        //have we found it? great, move the temporary node two nodes forward of its current position
        //then recycle the item to show it back, dead of course.
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
