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
        int w1 = 1, w2 = 1;
        for (int i = 1; i < chars.length; i++) {
            if (isInAlphabet(chars[i - 1], chars[i])) {
                int currentWays = w1 + w2;
                w1 = w2;
                w2 = currentWays;
            } else {
                w1 = w2;
            }
        }
        return w2;
    }
    private boolean isInAlphabet(char a, char b) {
        return (a - '0') * 10 + b - '0' <= 26;
    }
}
