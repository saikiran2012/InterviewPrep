package main.string;

import java.util.Arrays;

/*
    Implement a method to perform basic string compression using the counts
    of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
    "compressed" string would not become smaller than the original string, your method should return
    the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 */
public class StringCompression {

    public String compressString(String str) {
        int charCount = 1;
        char[] cstring = str.toCharArray();
        StringBuilder finalString = new StringBuilder().append(cstring[0]);
        for (int i =1; i<cstring.length; i++) {
            if(cstring[i] == cstring[i-1]) {
                charCount++;
            } else {
                finalString.append(charCount);
                finalString.append(cstring[i]);
                charCount = 1;
            }
        }
        finalString.append(charCount);
        return finalString.length() < str.length() ? finalString.toString(): str;
    }
}
