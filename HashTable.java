package com.company;

public class HashTable<Item> {

    private final int tableSize = 12;
    private int numElements = 0;
    private Object[] table;

    public HashTable() {
        table = new Object[tableSize];
        numElements = 0;
    }

    private int hash(Object key) {
        int result = 1;
        String inputString = key.toString().toLowerCase();
        char[] characters = inputString.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            char currentChar = characters[i];
            int j = (int) currentChar;
            result += j;
        }
        //with this we ensure that the hash will be somewhere in our table and never outside.
        return (result % this.tableSize);
    }

    public void add(Object key, Object data) {
        if (data == null || key == null)
            throw new NullPointerException("Either key or object can not be null");

        if (contains(key))
            return;

        int position = hash(key);

        if (table[position] == null) table[position] = new LinkedList<Item>();

        ((LinkedList) table[position]).add(new HashTableNode(key, data));

        numElements++;
    }

    public boolean contains(Object key) {
        boolean result = false;
        int hash = hash(key);

        if (this.table[hash] != null) {
            HashTableNode node = new HashTableNode();
            node.setKey(key);
            if (((LinkedList) table[hash]).indexOf(node) > -1) {
                result = true;
            }
        }

        return result;
    }

    public void remove(Object key) {
        int hashVal = hash(key);
        if (table[hashVal] != null) {
            HashTableNode node = new HashTableNode();
            node.setKey(key);
            if (((LinkedList) table[hashVal]).indexOf(node) > -1) {
                ((LinkedList) table[hashVal]).remove(node);
                numElements--;
            }
        }
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();

        buffer.append(System.getProperty("line.separator"));
        buffer.append("{");
        buffer.append(System.getProperty("line.separator"));

        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                buffer.append("\t"+(table[i]));
                buffer.append(System.getProperty("line.separator"));
            }
        }

        buffer.append("}");

        return buffer.toString();
    }

    public int getSize() {
        return numElements;
    }

    public Object getItem(Object key){
        int position = hash(key);
        LinkedList list = (LinkedList) table[position];
        HashTableNode node = new HashTableNode();
        node.setKey(key);
        return ((HashTableNode) list.getItem(list.indexOf(node))).getData();
    }

    private class HashTableNode {
        private Object key;
        private Object data;

        public HashTableNode() {
            this.key = null;
            this.data = null;
        }

        public HashTableNode(Object inKey, Object inData) {
            this.key = inKey;
            this.data = inData;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Object getKey() {
            return key;
        }

        public void setKey(Object key) {
            this.key = key;
        }

        public boolean equals(Object obj) {
            HashTableNode node = (HashTableNode) obj;
            return this.key.equals(node.getKey());
        }
    }
}
