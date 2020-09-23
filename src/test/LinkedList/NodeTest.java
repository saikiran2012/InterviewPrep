package test.LinkedList;

import main.LinkedList.Node;
import org.junit.Assert;
import org.junit.Test;

import java.util.Hashtable;

public class NodeTest {

    @Test
    public void testLinkedList() {
        Node head = new Node(1);
        for (int i = 2; i< 10; i++) {
            head.append(i);
        }
        Node n = head;
        for(int i=1; i<10; i++) {
            Assert.assertEquals(i,n.data());
            n = n.next();
        }

        Node deletedNode = head.deleteNode(5,head);
        Assert.assertEquals(5, deletedNode.data());
    }

    @Test
    public void testDuplicates() {
        Node head = new Node(1);
        for (int i = 2; i< 10; i++) {
            head.append(i);
            head.append(i+2);
        }
        head.removeDuplicates(head);


        Hashtable hashtable = new Hashtable();
        hashtable.put(head.data(), true);
        while (head.next() != null) {
            head = head.next();
            if(hashtable.containsKey(head.data())) {
                Assert.assertFalse(true);
            } else {
                hashtable.put(head.data(), true);
                head = head.next();
            }
        }
    }
}
