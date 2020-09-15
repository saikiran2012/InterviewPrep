package test.strings;

import main.string.StringUrlify;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class testURLify {

    @Test
    public void testUrlify() {
        String teststr1 = "hello";
        char[] teststr2 = ("hello world").toCharArray();
        StringUrlify urlify = new StringUrlify();
        Assert.assertEquals(urlify.urlify(teststr1.toCharArray(), teststr1.length()), teststr1);
        Assert.assertEquals(urlify.urlify(Arrays.copyOf(teststr2, teststr2.length+3*1), teststr2.length).trim(),
                "hello%20world");
    }
}
