package main.LinkedList;

import java.util.Hashtable;

/*
Given a circular linked list, implement an algorithm that returns the node at the
beginning of the loop.
DEFINITION
Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so
as to make a loop in the linked list.
EXAMPLE
Input: A -> B -> C -> 0 -> E - > C (the same C as earlier)
Output: C
 */
public class LoopDedector {

    public boolean hasLoop(Node node) {
        Hashtable hashtable = new Hashtable();
        do {
            if(hashtable.containsKey(node)) {
                return true;
            }
            hashtable.put(node,true);
            node = node.next();
        }while (node.next() != null);
        return false;
    }

    public Node getLoopStart(Node node) {
        Node fast = node;
        Node slow = node;
        while (fast != null && slow != null) {
            fast = fast.next().next();
            slow = slow.next();
            if(slow == fast) {
                break;
            }
        }
        // No loop
        if (slow != fast) {
            return node;
        }
        slow = node;
        while(slow != fast) {
            slow = slow.next();
            fast = fast.next();
        }
        return fast;
    }

    public Node createLoopedNode(Node head, int data) {
        Node temp = null;
        do {
            if(head.data() == data) {
                temp = head;
            }
            head = head.next();
        } while (head.next() != null);
        head.setNext(temp);
        return head.next();
    }
}
