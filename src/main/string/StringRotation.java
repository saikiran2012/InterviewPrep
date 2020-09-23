package main.string;

import org.apache.tools.ant.util.StringUtils;

/*
 Assume you have a method isSubstring which checks if one word is a substring
 of another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one
 call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat").
 */
public class StringRotation {

    public boolean isRotation(String s1, String s2) {
        String s1s1 = s1 + s1;
        if(s1.length() == s2.length() && s1s1.contains(s2)) {
            return true;
        }
        return false;
    }
}

