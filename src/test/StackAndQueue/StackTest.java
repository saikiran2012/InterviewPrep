package test.StackAndQueue;

import main.StackAndQueue.SortStack;
import main.StackAndQueue.Stack;
import org.junit.Assert;
import org.junit.Test;

public class StackTest {
    @Test
    public void testStack() {
        Stack<Integer> stack = new Stack<Integer>();
        Assert.assertTrue(stack.isEmpty());
        stack.push(5);
        Assert.assertEquals(Integer.valueOf(5), stack.peek());
        stack.push(15);
        Assert.assertEquals(Integer.valueOf(15), stack.peek());
        Assert.assertEquals(Integer.valueOf(15), stack.pop());
        Assert.assertEquals(Integer.valueOf(5), stack.peek());
    }

    @Test
    public void testSortedStack() {
        SortStack<Integer> sortStack = new SortStack<Integer>();
        sortStack.push(10);
        sortStack.push(4);
        sortStack.push(15);
        sortStack.push(19);
        sortStack.push(9);
        Assert.assertEquals(Integer.valueOf(4),sortStack.peek());
        sortStack.push(3);
        sortStack.push(22);
        Assert.assertEquals(Integer.valueOf(3),sortStack.pop());
    }
}
