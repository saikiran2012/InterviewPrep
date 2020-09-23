package test.strings;

import main.string.StringRotation;
import org.junit.Assert;
import org.junit.Test;

public class StringRotationTest {
    @Test
    public void testStringRotation() {
        StringRotation stringRotation = new StringRotation();
        Assert.assertTrue(stringRotation.isRotation("waterbottle","erbottlewat"));
    }
}
