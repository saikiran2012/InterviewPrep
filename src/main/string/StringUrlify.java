package main.string;

public class StringUrlify {

    public String urlify(char str[], int strlen) {
        if (str.length < 1) return "";
        int spaceCount = 0;
        for (int i= 0; i < strlen; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        int totallen = strlen + 2*spaceCount;
        if (totallen == strlen) {
            return new String(str);
        }

        str[totallen] = '\0';
        for (int i = strlen -1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[totallen -3] = '%';
                str[totallen -2] = '2';
                str[totallen -1] = '0';
                totallen = totallen- 3;
            } else {
                str[totallen -1] = str[i];
                totallen --;
            }
        }
        return new String(str);
    }
}
