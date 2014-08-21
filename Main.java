package com.company;

public class Main {
    public static void main(String args[]) {
        BigONotation bigONotation=new BigONotation(100);
        bigONotation.generateRandomArray();
        bigONotation.quickSort(0, bigONotation.itemsInArray);
    }
}
