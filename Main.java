package com.company;


public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, World");
        DoubleLinkedList<Object> dlinkedList = new DoubleLinkedList<Object>();
        LinkedList<Object> linkedList = new LinkedList<Object>();

        dlinkedList.insertAtStart("head");
        dlinkedList.insertAtStart("one");
        dlinkedList.insertAtStart("two");
        dlinkedList.insertAtStart("back");
        for (int i = 0; i < dlinkedList.size(); i++) {
            System.out.println(dlinkedList.getItem(i));
        }
    }
}
