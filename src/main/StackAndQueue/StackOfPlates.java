package main.StackAndQueue;

import java.util.ArrayList;
import java.util.List;

/*
Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be
composed of several stacks and should create a new stack once the previous one exceeds capacity.
SetOfStacks. push () and SetOfStacks. pop () should behave identically to a single stack
(that is, pop ( ) should return the same values as it would if there were just a single stack).
 */
public class StackOfPlates {
    final int stackSize;
    int plateCount;
    int stackCount;
    List<Stack> stacks;
    Stack<Integer> stack;

    public StackOfPlates(int stackSize) {
        this.stackSize = stackSize;
        this.plateCount = 0;
        this.stackCount = 1;
        stacks = new ArrayList<Stack>();
        stack = new Stack<Integer>();
    }

    public void push(int data) {
        if(plateCount <= stackSize) {
            plateCount++;
            stack.push(data);
            return;
        }
        Stack<Integer>  tstack = stack;
        stacks.add(tstack);
        stackCount++;

        stack = new Stack<Integer>();
        plateCount = 0;
        push(data);
    }

    public int pop() {
        if(isEmpty()) {
            return 0;
        }
        if (!stack.isEmpty()) {
            plateCount --;
            return stack.pop();
        }
        stack = stacks.get(stacks.size() -1);
        stacks.remove(stacks.size() -1);
        stackCount --;
        plateCount = stackSize;
        return pop();
    }

    public boolean isEmpty() {
        return (stackCount == 1 && plateCount == 0);
    }
}
