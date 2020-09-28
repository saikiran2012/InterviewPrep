package test.LinkedList;

import main.LinkedList.*;
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

    @Test
    public void testLoops() {
        Node head = new Node(1);
        LoopDedector loopDedector = new LoopDedector();
        for (int i = 2; i< 10; i++) {
            head.append(i);
        }
        loopDedector.createLoopedNode(head, 5);
        Assert.assertTrue(loopDedector.hasLoop(head));
    }

    @Test
    public void testLoopNode() {
        Node head = new Node(1);
        LoopDedector loopDedector = new LoopDedector();
        for (int i = 2; i< 10; i++) {
            head.append(i);
        }
        Node loop = loopDedector.createLoopedNode(head, 5);
        Assert.assertEquals(loop.data(),loopDedector.getLoopStart(head).data());
    }

    @Test
    public void testPalindrome() {
        Node head = new Node(1);
        Palindrome palindrome = new Palindrome();
        Assert.assertTrue(palindrome.isPalindrome(head));
        head.append(2);
        Assert.assertFalse(palindrome.isPalindrome(head));
        head.append(3);
        Assert.assertFalse(palindrome.isPalindrome(head));
        head.append(2);
        head.append(1);
        Assert.assertTrue(palindrome.isPalindrome(head));
        Assert.assertTrue(palindrome.isPalindromeRecursive(head, 5));
    }

    @Test
    public void testIntersection() {
        Node head = new Node(1);
        Intersection intersection = new Intersection();
        for (int i = 2; i< 10; i++) {
            head.append(i);
        }

        Node head2 = new Node(1);
        for (int i = 2; i< 4; i++) {
            head2.append(i);
        }
        head2.setNext(head.getNode(head,5));

        Assert.assertEquals(5, intersection.hasIntersection(head,head2).data());
        Assert.assertTrue(intersection.hasIntersection2(head, head2));
    }

    @Test
    public void testPartition() {
        Node head = new Node(3);
        head.append(5);
        head.append(8);
        head.append(10);
        head.append(2);
        head.append(1);
        PartitionList partitionList = new PartitionList();
        Node pList = partitionList.partition(head, 5);
        Assert.assertEquals(3, head.data());
        Assert.assertEquals(2, head.next().data());
        Assert.assertEquals(1, head.next().next().data());
    }

    @Test
    public void sumLists() {
        Node l1 = new Node(1);
        for (int i = 2; i< 5; i++) {
            l1.append(i);
        }

        Node l2 = new Node(5);
        for (int i = 2; i< 7; i++) {
            l2.append(i+2);
        }
        SumLists sumLists = new SumLists();
        int sum = sumLists.add(l1, l2);
        Assert.assertEquals(546912, sum);
    }
}


