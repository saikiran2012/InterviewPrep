package test.StackAndQueue;

import main.StackAndQueue.StackOfPlates;
import org.junit.Assert;
import org.junit.Test;

public class StackOfPlatesTest {
    @Test
    public void testStackOffPlates() {
        StackOfPlates stackOfPlates = new StackOfPlates(3);
        for (int i =0; i< 13; i++) {
            stackOfPlates.push(i + 3);
        }
        for (int i =12; i>0; i--) {
            Assert.assertEquals(i+3, stackOfPlates.pop());
        }
    }
}
