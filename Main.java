package com.company;


public class Main {

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");
        queue.enqueue("Last");
        for (int i = 0; i < queue.size(); i++) {
            System.out.println(queue.getItem(i));
        }
        queue.dequeue();
        queue.enqueue("new last");
        System.out.println("<---------------------------->");
        for (int i = 0; i < queue.size(); i++) {
            System.out.println(queue.getItem(i));
        }
    }
}
