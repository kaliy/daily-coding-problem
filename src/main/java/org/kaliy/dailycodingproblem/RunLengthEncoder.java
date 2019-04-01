package org.kaliy.dailycodingproblem;

import java.util.stream.IntStream;

/**
 * Run-length encoding is a fast and simple method of encoding strings. The basic idea is to represent repeated
 * successive characters as a single count and character. For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".
 */
public class RunLengthEncoder {
    public String encode(String input) {
        var sb = new StringBuilder();
        int currentCount = 0;
        char previousCharacter = input.charAt(0);

        for (char c : input.toCharArray()) {
            if (c != previousCharacter) {
                sb.append(currentCount).append(previousCharacter);
                currentCount = 0;
            }
            previousCharacter = c;
            currentCount++;
        }
        sb.append(currentCount).append(previousCharacter);

        return sb.toString();
    }

    public String decode(String input) {
        var sb = new StringBuilder();
        int i = 0;
        while (i < input.length()) {
            int number = Character.getNumericValue(input.charAt(i++));
            char c = input.charAt(i++);
            IntStream.range(0, number).forEach((j) -> sb.append(c));
        }
        return sb.toString();
    }
}
