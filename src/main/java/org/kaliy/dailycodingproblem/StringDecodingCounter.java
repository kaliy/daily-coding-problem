package org.kaliy.dailycodingproblem;

public class StringDecodingCounter {
    public int count(String string) {
        if (null == string || string.length() == 0) {
            return 0;
        }
        for (char c : string.toCharArray()) {
            assert c >= '1' && c <= '9';
        }
        char[] chars = string.toCharArray();
        return count(chars, 0);
    }

    private int count(char[] chars, int fromIndex) {
        int count = 1;
        for (int i = fromIndex + 2; i <= chars.length; i++) {
            if (isInAlphabet(chars[i - 2], chars[i - 1])) {
                count += count(chars, i);
            }
        }
        return count;
    }

    private boolean isInAlphabet(char a, char b) {
        return (a - '0') * 10 + b - '0' <= 26;
    }
}
