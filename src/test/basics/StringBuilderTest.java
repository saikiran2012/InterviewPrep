package test.basics;

import main.basics.SampleStringBuilder;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class StringBuilderTest {

    @Test
    public void testStringBuilder() {
        SampleStringBuilder sb = new SampleStringBuilder("sai");
        assertTrue(sb.getString().equals("sai"));
        sb.append(" ");
        sb.append("kiran");
        assertTrue(sb.getString().equals("sai kiran"));
    }

    @Test(expected = NullPointerException.class)
    public void testEmptyStringBuilder() {
        SampleStringBuilder sb = new SampleStringBuilder();
        sb.getString();
    }

    @Test
    public void testAppendToEmpthString() {
        SampleStringBuilder sb = new SampleStringBuilder();
        sb.append("Hello");
        sb.append(" ");
        sb.append("World");
        assertTrue(sb.getString().equals("Hello World"));
    }

}
