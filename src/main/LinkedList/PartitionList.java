package main.LinkedList;

/**
 * Partition: Write code to partition a linked list around a value x, such that all nodes less than
 * x come before all nodes greater than or equal to x. lf x is contained within the list, the values
 * of x only need to be after the elements less than x (see below). The partition element x can
 * appear anywhere in the "right partition"; it does not need to appear between the left and right
 * partitions. EXAMPLE Input: 3 -> 5 -> 8 -> 5 - > 10 -> 2 -> 1 [partition = 5) Output: 3 -> 1 -> 2
 * -> 10 -> 5 -> 5 -> 8
 */
public class PartitionList {
    public Node partition(Node node, int partition) {
        Node lessThenStart = null;
        Node lessThenEnd = null;
        Node greaterThanStart = null;
        Node greaterThanEnd = null;
        Node next = null;
        Node pNodeStart = null;
        Node pNodeEnd = null;

        while (node != null) {
            next = node.next();
            node.setNext(null);
            if(node.data() < partition) {
                if (lessThenStart == null) {
                    lessThenStart = node;
                    lessThenEnd = node;
                } else {
                    lessThenEnd.setNext(node);
                    lessThenEnd = lessThenEnd.next();
                }
            } else if(node.data() == partition) {
                if(pNodeStart == null) {
                    pNodeStart = node;
                    pNodeEnd = node;
                }
                pNodeEnd.setNext(node);
            } else {
                if(greaterThanStart == null) {
                    greaterThanStart = node;
                    greaterThanEnd = node;
                } else {
                    greaterThanEnd.setNext(node);
                    greaterThanEnd = greaterThanEnd.next();
                }
            }
            node = next;
        }
        lessThenEnd.setNext(pNodeStart);
        lessThenEnd = pNodeEnd;
        lessThenEnd.setNext(greaterThanStart);
        return lessThenStart;
    }
}
