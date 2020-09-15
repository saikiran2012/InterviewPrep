package test.strings;

import main.string.OneAway;
import org.junit.Assert;
import org.junit.Test;

public class OneAwayTest {

    @Test
    public void testOneAway() {
        OneAway oneAway = new OneAway();
        Assert.assertTrue(oneAway.isOneAway("pale", "Pal"));
        Assert.assertTrue(oneAway.isOneAway("pale", "Pale"));
        Assert.assertTrue(oneAway.isOneAway("pale", "Pales"));
        Assert.assertFalse(oneAway.isOneAway("pale", "Paless"));
        Assert.assertFalse(oneAway.isOneAway("pppale", "Pales"));
    }
}
