package test.StackAndQueue;

import main.StackAndQueue.Tower;
import org.junit.Test;

public class TowerOfHanoiTest {
    @Test
    public void testHaoi() {
        Tower tower = new Tower();
        tower.move(3, 'a', 'b', 'c');
    }
}
