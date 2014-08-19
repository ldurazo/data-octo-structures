package com.company;


public class Main {

    public static void main(String[] args) {
        DoubleLinkedList<Object> dlinkedList = new DoubleLinkedList<Object>();
        dlinkedList.insertAtStart("head");
        dlinkedList.insertAtStart("7");
        dlinkedList.insertAtStart("6");
        dlinkedList.insertAtStart("5");
        dlinkedList.insertAtStart("4");
        dlinkedList.insertAtStart("3");
        dlinkedList.insertAtStart("2");
        dlinkedList.insertAtStart("back");
        dlinkedList.insertAt(7, "insertAt");

        System.out.println(String.valueOf(dlinkedList.indexOf("insertAt")));
        dlinkedList.remove("insertAt");
        System.out.println("----------------------------->");
        for (int i = 0; i < dlinkedList.size(); i++) {
            System.out.println(dlinkedList.getItem(i));
        }
        System.out.println("----------------------------->");
        for (int i = 0; i < dlinkedList.size(); i++) {
            System.out.println(dlinkedList.getItemInReverse(i));
        }
    }
}
