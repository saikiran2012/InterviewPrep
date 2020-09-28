package main.LinkedList;

/*
    Implement a function to check if a linked list is a palindrome.
 */
public class Palindrome {

    public boolean isPalindrome(Node node) {
        if(node.next() == null) {
            return true;
        }
        Node start = node;
        Node end = null;
        while (node.next() != null) {
            node = node.next();
        }
        end = node;

        while (start != null && end != null) {
            if(start.data() != end.data()) {
                return false;
            }
            start = start.next();
            end = end.next();
        }

        return true;
    }

    public boolean isPalindromeRecursive(Node node, int len) {
        return palindromeRecursive(node, len).result;
    }

    class Result {
        public Node node;
        public boolean result;
        public Result(Node node, boolean result) {
            this.node = node;
            this.result = result;
        }
    }

    private Result palindromeRecursive(Node node, int len) {
        if(len == 0 || node == null) {
            return new Result(null, true);
        }
        if(len == 1) {
            return new Result(node.next(),true);
        }
        if(len == 2) {
            return new Result(node.next().next(), node.data() == node.next().data());
        }
        Result res = palindromeRecursive(node.next(), len - 2);
        if(!res.result || res.node == null) {
            return res;
        } else {
            res.result = (node.data() == res.node.data());
            res.node = res.node.next();
            return res;
        }
    }
}
