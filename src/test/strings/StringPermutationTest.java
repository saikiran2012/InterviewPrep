package test.strings;

import main.string.StringPermutation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringPermutationTest {
    private StringPermutation stringPermutation;

    @Before
    public void init() {
        stringPermutation = new StringPermutation();
    }

    @Test
    public void testPermutation() {
        Assert.assertFalse(stringPermutation.checkPermutation("bad", "dam"));
        Assert.assertFalse(stringPermutation.checkPermutation("bad", "boy"));
        Assert.assertTrue(stringPermutation.checkPermutation("sai", "ias"));
    }

    @Test
    public void testPermutationByComparison() {
        Assert.assertFalse(stringPermutation.chekPerumutationCharCount("bad", "dam"));
        Assert.assertFalse(stringPermutation.chekPerumutationCharCount("bad", "boy"));
        Assert.assertTrue(stringPermutation.chekPerumutationCharCount("sai", "ias"));
    }
}
