package main.string;

/**
 * Determine if all the characters in a string are unique
 */
public class UniqueChars {

    public boolean isUnique(String str) {
        int checker = 0;
        for (int i =0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }
}
