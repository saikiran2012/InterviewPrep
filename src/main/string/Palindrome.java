package main.string;

public class Palindrome {

    public boolean isPalindrome(String str) {
        char []arraystr = str.toLowerCase().replaceAll("\\s+","").toCharArray();
        for (int i = 0, j= arraystr.length-1; i <= arraystr.length/2; i++, j--) {
            if(arraystr[i] != arraystr[j]) {
                return false;
            }
        }
        return true;
    }
}
