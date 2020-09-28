package main.LinkedList;
/*
    Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting node. Note that the intersection is defined based on reference, not value. That is, if the kth
    node of the first linked list is the exact same node (by reference) as the jth node of the second
    linked list, then they are intersecting.
 */
public class Intersection {

    /* one way is use hashtable - put the nodes in hashtable and check for contains,
       lets try to do it in a different way :).
     */
    public Node hasIntersection(Node node1, Node node2) {
        Node t = node2;
        while (node1 != null) {
            while (t != null) {
                if(node1 == t) {
                    return node1;
                }
                t = t.next();
            }
            node1 = node1.next();
            t = node2.next();
        }
        return null;
    }

    public boolean hasIntersection2(Node node1, Node node2) {
        while (node1.next() != null) {
            node1 = node1.next();
        }
        while (node2.next() != null) {
            node2 = node2.next();
        }
        if (node1.next() == null && node2.next() == null && node1 == node2) {
            return true;
        }
        return false;
    }
}
