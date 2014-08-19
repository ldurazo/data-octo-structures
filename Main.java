package com.company;


public class Main {

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.add(1, "One");
        hashTable.add(2, "Two");
        hashTable.add(3, "Three");
        hashTable.add(4, "Four");
        hashTable.add(5, "Five");
        hashTable.add(6, "six");
        hashTable.add(7, "Seven");
        hashTable.add(8, "Eight");
        hashTable.add(9, "Neun");
        hashTable.add(10, "Zhen");
        hashTable.add(11, "Elf");
        hashTable.add(12, "Zwölf");
        hashTable.add(13, "Trece");
        hashTable.add(14, "Catorce");
        hashTable.add(15, "Quince");
        hashTable.add(16, "Sixteen");
        hashTable.remove(3);
        System.out.println(hashTable.toString());
        System.out.println(hashTable.getItem(1));
    }
}
