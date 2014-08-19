package com.company;


public class Main {

    public static void main(String[] args) {
        IStack iStack = new IStack();
        iStack.push("One");
        iStack.push("Two");
        iStack.push("Three");
        iStack.push("Four");
        iStack.push("Five");
        iStack.push("Six");
        for (int i = 0; i < iStack.size(); i++) {
            System.out.println(iStack.getItem(i));
        }
        System.out.println("<------------->");
        System.out.println(iStack.peek());
        System.out.println(iStack.search("Two"));
        System.out.println("<------------->");
        iStack.pop();
        for (int i = 0; i < iStack.size(); i++) {
            System.out.println(iStack.getItem(i));
        }
        System.out.println("<------------->");
        System.out.println(iStack.size());
        System.out.println(iStack.isEmpty());
    }
}
