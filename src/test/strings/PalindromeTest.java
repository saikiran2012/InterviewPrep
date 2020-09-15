package test.strings;

import main.string.Palindrome;
import org.junit.Assert;
import org.junit.Test;

public class PalindromeTest {

    @Test
    public void testPalindrome()  {
        Palindrome palindrome = new Palindrome();
        Assert.assertTrue(palindrome.isPalindrome("aba"));
        Assert.assertFalse(palindrome.isPalindrome("abc"));
        Assert.assertTrue(palindrome.isPalindrome("madam"));
        Assert.assertTrue(palindrome.isPalindrome("Madam"));
        Assert.assertTrue(palindrome.isPalindrome("nurses run"));
    }
}
