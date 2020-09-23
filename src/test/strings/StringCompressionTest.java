package test.strings;

import main.string.StringCompression;
import org.junit.Assert;
import org.junit.Test;

public class StringCompressionTest {

    @Test
    public void testStringCompression() {
        StringCompression stringCompression = new StringCompression();
        Assert.assertEquals("aabcd",stringCompression.compressString("aabcd"));
        Assert.assertEquals("a2b7c1d7e1f5z4",stringCompression.compressString("aabbbbbbbcdddddddefffffzzzz"));
        Assert.assertEquals("a2b2a5d2b2d3",stringCompression.compressString("aabbaaaaaddbbddd"));
    }
}
