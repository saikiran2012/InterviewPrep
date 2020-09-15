package test.strings;

import main.string.UniqueChars;
import org.junit.Assert;
import org.junit.Test;

public class UniqueCharsTest {
    @Test
    public void testString() {
        UniqueChars str = new UniqueChars();
        //Assert.assertTrue(str.isUnique("abcd"));
        Assert.assertFalse(str.isUnique("dbcba"));
    }
}
