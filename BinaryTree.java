package com.company;

public class BinaryTree {

    Node root;

    public void addNode(int key, String name) {
        Node newNode = new Node(name, key);
        //no root? the new one is the root.
        if (root == null) {
            root = newNode;
        } else {
            //there is a root? we will begin in the root.
            Node focusNode = root;
            Node parent;
            while (true) {
                //the parent of the node to be added is set.
                //this parents moves down the tree if there is no leaf available until it founds one
                parent = focusNode;
                if (key < focusNode.key) {
                    //if the key is smaller we move the focus node to the left child
                    focusNode = focusNode.leftChild;
                    if (focusNode == null) {
                        //is this slot available? there will be the new node.
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    focusNode = focusNode.rightChild;
                    if (focusNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }

    }

    public void inOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            inOrderTraverseTree(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTraverseTree(focusNode.rightChild);
        }
    }

    public void preOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode);
            preOrderTraverseTree(focusNode.leftChild);
            preOrderTraverseTree(focusNode.rightChild);
        }
    }

    public void postOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            postOrderTraverseTree(focusNode.leftChild);
            postOrderTraverseTree(focusNode.rightChild);
            System.out.println(focusNode);
        }
    }

    public Node findNode(int key){
        Node focusNode=root;
        while(focusNode.key!=key){
            if(key<focusNode.key){
                focusNode=focusNode.leftChild;
            }else{
                focusNode = focusNode.rightChild;
            }

            if(focusNode==null){
                return null;
            }
        }
        return focusNode;
    }

    public boolean remove(int key){
        Node focusNode = root;
        Node parent = root;

        boolean isLeftChild = true;

        while(focusNode.key != key){
            parent = focusNode;
            if(key<focusNode.key){
                isLeftChild=true;
                focusNode=focusNode.leftChild;
            }else{
                isLeftChild=false;
                focusNode = focusNode.rightChild;
            }
            if(focusNode==null)
                return false;
        }

        if(focusNode.leftChild==null && focusNode.rightChild==null){
            if(focusNode == root){
                root=null;
            }else if (isLeftChild){
                parent.leftChild = null;
            }else{
                parent.rightChild = null;
            }
        }

        else if (focusNode.rightChild == null){
            if(focusNode == root){
                root = focusNode.leftChild;
            }else if(isLeftChild){
                parent.leftChild=focusNode.leftChild;
            }else{
                parent.rightChild=focusNode.rightChild;
            }
        }

        else if(focusNode.leftChild==null){
            if(focusNode == root){
                root = focusNode.rightChild;
            }else if(isLeftChild){
                parent.leftChild = focusNode.rightChild;
            }else{
                parent.rightChild = focusNode.leftChild;
            }
        }

        else{
            Node replacement = getReplacementNode(focusNode);
            if(focusNode == root){
                root = replacement;
            }else if(isLeftChild){
                parent.leftChild = replacement;
            }else{
                parent.rightChild = replacement;
                replacement.leftChild = focusNode.leftChild;
            }
        }

        return true;
    }

    public Node getReplacementNode(Node replacedNode){
        Node replacementParent = replacedNode;
        Node replacement = replacedNode;

        Node focusNode = replacedNode.rightChild;

        while(focusNode!=null){
            replacementParent =replacement;
            replacedNode=focusNode;
            focusNode=focusNode.leftChild;
        }

        if(replacement!=replacedNode.rightChild){
            replacementParent.leftChild = replacement.rightChild;
            replacement.rightChild=replacedNode.rightChild;
        }

        return replacement;
    }

    private class Node {
        int key;
        String data;

        Node leftChild;
        Node rightChild;

        private Node(String data, int key) {
            this.data = data;
            this.key = key;
        }

        @Override
        public String toString() {
            return data + " has key " + key;
        }
    }

}
