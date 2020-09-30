package main.StackAndQueue;

/**
 * Sort Stack: Write a program to sort a stack such that the smallest items are on the top. You can
 * use an additional temporary stack, but you may not copy the elements into any other data
 * structure (such as an array). The stack supports the following operations: push, pop, peek, and
 * isEmpty.
 */
public class SortStack<T extends Comparable<T>> {
    Stack<T> stack;
    Stack<T> tempStack;

    public SortStack() {
        stack = new Stack<T>();
        tempStack = new Stack<T>();
    }

    public void push(T data) {
        stack.push(data);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public T pop() {
        return sortStack().pop();
    }

    public T peek() {
        return sortStack().peek();
    }

    private Stack<T> sortStack() {
        if (stack == null && tempStack == null) {
            return null;
        }
        while (!stack.isEmpty()) {
            T temp = stack.pop();
            while( !tempStack.isEmpty() && tempStack.peek().compareTo(temp) < 0) {
                stack.push(tempStack.pop());
            }
            tempStack.push(temp);
        }
        return tempStack;
    }
}
