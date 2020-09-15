package main.basics;

/*
    This class tests out basic string buffer.
 */
public class SampleStringBuilder {
    private static int INITIAL_CAPACITY = 32;
    private char currentStr [];
    private int end_count;

    public SampleStringBuilder() {
        new SampleStringBuilder(INITIAL_CAPACITY);
    }

    public SampleStringBuilder(int intialCapacity) {
        currentStr = new char[intialCapacity];
        end_count = 0;
        appenNull();
    }

    // lets make the intial capacity 2x the string length.
    public SampleStringBuilder(String str) {
        int len = str.length();
        int capacity = 0;
        if (len < Integer.MAX_VALUE - 2*len) {
            capacity = 2*len;
        } else {
            capacity = Integer.MAX_VALUE;
        }
        currentStr = new char[capacity];
        append(str);
    }

    public void append(String str) {
        if (str.isEmpty() || str == null) {
            appenNull();
        }
        ensureCapacity(str);
        System.arraycopy(str.toCharArray(),0, currentStr,end_count, str.length());
        end_count = end_count + str.length();
    }

    public String getString() {
        return new String(currentStr, 0, end_count);
    }

    private void appenNull() {
        int count = this.end_count;
        char[] currentStr = this.currentStr;
        currentStr[count++] = 'n';
        currentStr[count++] = 'u';
        currentStr[count++] = 'l';
        currentStr[count++] = 'l';
        end_count = count;
    }

    public void ensureCapacity(String str) {
        int len;
        if (currentStr == null && str != null) {
            len = 2*str.length();
            currentStr = new char[len];
        } else {
            len = currentStr.length;
        }
        if((end_count + str.length()) > len) {
            int newLength = 2*(end_count + str.length());
            char[] tempStr = new char[newLength];
            System.arraycopy(currentStr, 0, tempStr, 0,
                    Math.min(currentStr.length, newLength));
            currentStr = tempStr;
        }
    }

}
