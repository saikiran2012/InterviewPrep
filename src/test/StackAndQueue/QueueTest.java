package test.StackAndQueue;


import main.StackAndQueue.Queue;
import org.junit.Assert;
import org.junit.Test;

public class QueueTest {
    @Test
    public void testQueue() {
        Queue<String> queue = new Queue<String>();
        Assert.assertTrue(queue.isEmpty());
        queue.add("a");
        Assert.assertEquals("a", queue.peek());
        queue.add("b");
        queue.add("c");
        Assert.assertEquals("a", queue.peek());
        Assert.assertEquals("a", queue.remove());
        Assert.assertEquals("b", queue.remove());
        Assert.assertEquals("c", queue.peek());
        Assert.assertEquals("c", queue.remove());
        Assert.assertNull(queue.remove());
    }

}
