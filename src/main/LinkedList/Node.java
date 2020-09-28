package main.LinkedList;

import java.util.Hashtable;

public class Node {
    private  int data;
    private Node next = null;

    public Node(int data) {
        this.data = data;
    }

    public void append(int data) {
        Node newNode = new Node(data);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = newNode;
    }

    public Node appendBegining(Node node, int data) {
        Node newNode = new Node(data);
        newNode.next = node;
        return newNode;
    }
    public Node getNode(Node node, int data) {
        while(node != null) {
            if (node.data == data) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public Node deleteNode(int data, Node head) {
        Node n = head;
        if (n.data == data) {
            head = n.next;
        }
        while (n.next != null) {
            if(n.next.data == data) {
                Node t = n.next;
                n.next = n.next.next;
                return t;
            } else {
                n = n.next;
            }
        }
        return head;
    }

    public int data() {
        return this.data;
    }

    public Node next() {
        return this.next;
    }

    public void setNext(Node n) {
        this.next = n;
    }

    public void setData(int data, Node n) {
        n.data = data;
    }

    public void deleteMiddleNode(Node n) {
        if (n.next == null) {
            return;
        }
        n.data = n.next.data;
        n.next = n.next.next;
    }

    /*
    code to remove duplicates from an unsorted linked list
    */
    public void removeDuplicates(Node node) {
        Hashtable hashtable = new Hashtable();
        hashtable.put(node.data, true);
        while (node.next != null) {
            node = node.next;
            if(hashtable.containsKey(node.data)) {
                deleteMiddleNode(node);
            } else {
                hashtable.put(node.data, true);
                node = node.next;
            }
        }
    }

}
