package main.string;

import java.util.Arrays;

public class OneAway {

    /*
    One Away: There are three types of edits that can be performed on strings: insert a character,
    remove a character, or replace a character. Given two strings, write a function to check if they are
    one edit (or zero edits) away.
    EXAMPLE
    pale, ple -> true
    pales. pale -> true
    pale. bale -> true
    pale. bake -> false
     */
    public boolean isOneAway(String a, String b) {
        char[] strA = a.toLowerCase().toCharArray();
        char[] strB = b.toLowerCase().toCharArray();
        Arrays.sort(strA);
        Arrays.sort(strB);
        if(a.length() == b.length()) {
            Arrays.sort(strA);
            Arrays.sort(strB);
            if(Arrays.equals(strA,strB)) {
                return true;
            }
            return false;
        } else if (a.length() - b.length() == -1 || a.length() - b.length() == 1) {
            // b is larger than a by 1 char
            if(arraydiff(strA, strB).length == 1) {
                return true;
            }
            return false;
        }
        return false;
    }

    private char[] arraydiff(char[] arrayA, char[] arrayB) {
        char[] diff = new char[arrayA.length + arrayB.length];
        //assume both arrays are sorted.
        int firstIndex = 0;
        int secondIndex = 0;
        int i = 0;
        while (firstIndex < arrayA.length && secondIndex < arrayB.length) {
            if(arrayA[firstIndex] != arrayB[secondIndex]) {
                if(arrayA[firstIndex] < arrayB[secondIndex]) {
                    diff[i++] = arrayA[firstIndex];
                    firstIndex++;
                    continue;
                } else {
                    diff[i++] = arrayB[secondIndex];
                    secondIndex++;
                    continue;
                }
            }
            firstIndex++;
            secondIndex++;
        }
        if(firstIndex < arrayA.length) {
            System.arraycopy(arrayA,firstIndex, diff,i,arrayA.length - firstIndex);
            i += arrayA.length - firstIndex;
        }
        if (secondIndex < arrayB.length) {
            System.arraycopy(arrayB,secondIndex, diff,i,arrayB.length - secondIndex);
            i += arrayB.length - secondIndex;
        }
        return Arrays.copyOf(diff, i);
    }
}
