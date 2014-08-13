package com.company;


public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, World");
        LinkedList<Object> linkedList = new LinkedList<Object>();
        System.out.println(linkedList.isEmpty());
        linkedList.add("Cero");
        linkedList.add("Uno");
        linkedList.add("Dos");
        linkedList.add("Dos");
        linkedList.add("Dos");
        linkedList.add("Dos");
        linkedList.add("Dos");
        linkedList.add(null);
        linkedList.add("Tres");
        linkedList.add("Cuatro");
        linkedList.add(2, "Dos wannabe");
        System.out.println("Uno está en:"+linkedList.indexOf("Uno"));
        linkedList.remove(0);
        System.out.println("'Uno' tras borrar 0 está en:"+linkedList.indexOf("Uno"));
        linkedList.remove("Dos");
        linkedList.remove("Dos");
        System.out.println("'Uno' tras borrar 'Dos' está en:"+linkedList.indexOf("Uno"));
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.getItem(i));
        }
    }
}
