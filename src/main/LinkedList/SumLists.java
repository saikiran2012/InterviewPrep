package main.LinkedList;
/*
Sum Lists: You have two numbers represented by a linked list, where each node contains a single
digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
function that adds the two numbers and returns the sum as a linked list.
EXAMPLE
Input: (7-> 1 -> 6) + (5 -> 9 -> 2).Thatis,617 + 295.
Output: 2 -> 1 -> 9. That is, 912.
FOLLOW UP
Suppose the digits are stored in forward order. Repeat the above problem.
EXAMPLE
Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).Thatis,617 + 295.
Output: 9 -> 1 -> 2. That is, 912.
 */
public class SumLists {

    public int add(Node l1, Node l2) {
        return intializeAndAdd(l1, l2);
    }

    private int intializeAndAdd(Node l1, Node l2) {
        int l1Size = 0;
        int l2Size = 0;
        Node l1t = l1;
        Node l2t = l2;
        while (l1t != null) {
            l1Size++;
            l1t = l1t.next();
        }
        while (l2t != null) {
            l2Size++;
            l2t = l2t.next();
        }
        int diff = l1Size >= l2Size ? l1Size - l2Size : l2Size - l1Size;
        if (l1Size > l2Size) {
            l2 = appendZeros(diff, l2);
        } else if (l2Size > l1Size) {
            l1 = appendZeros(diff, l1);
        }
        sumitup(l1,l2);
        StringBuffer sb = new StringBuffer();
        while (l1 != null) {
            sb = sb.append(l1.data());
            l1 = l1.next();
        }
        return Integer.valueOf(sb.toString());
    }

    private Node appendZeros(int count, Node n) {
        Node node = n;
        for(int i=0; i<count; i++) {
            node = node.appendBegining(node, 0);
        }
        return node;
    }

    private int sumitup(Node l1, Node l2) {
        if(l1.next() == null && l2.next() == null) {
            int t = l1.data() + l2.data();
            l1.setData(t%10, l1);
            return (t -t%10)/10;
        }
        int carry = sumitup(l1.next(), l2.next());
        int t2 = carry + l1.data() + l2.data();
        l1.setData(t2%10, l1);
        return (t2 -t2%10)/10;
    }
}
