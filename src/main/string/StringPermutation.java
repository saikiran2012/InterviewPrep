package main.string;

import test.basics.ArrayListTest;

import java.util.Arrays;

public class StringPermutation {

    public boolean checkPermutation(String a, String b) {
        if(a.length() != b.length()) {
            return false;
        }
       return sort(a).equals(sort(b));
    }

    public boolean chekPerumutationCharCount(String a, String b) {
        int letters[] = new int[256];
        if(a.length() != b.length()) {
            return false;
        }
        char[] a_array = a.toCharArray();
        for (char ax : a_array) {
            letters[ax]++;
        }

        for (int i = 0; i < b.length(); i++) {
            int t = b.charAt(i);
            if (--letters[t] > 0) {
                return false;
            }
        }
        return true;
    }

    private String sort(String a) {
        char[] sortStr = a.toCharArray();
        Arrays.sort(sortStr);
        return new String(sortStr);
    }
}
