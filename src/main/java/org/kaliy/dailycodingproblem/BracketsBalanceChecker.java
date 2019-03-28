package org.kaliy.dailycodingproblem;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;

import java.util.LinkedList;

/**
 * Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).
 */
public class BracketsBalanceChecker {

    private static final BiMap<Character, Character> BRACKETS = ImmutableBiMap.of('(', ')', '[', ']', '{', '}');

    public boolean isBalanced(String input) {
        if (null == input || input.isBlank()) {
            throw new IllegalArgumentException();
        }
        var stack = new LinkedList<Character>();
        for (char c : input.toCharArray()) {
            if (isOpenBracket(c)) {
                stack.addLast(c);
            } else if (isClosedBracker(c)) {
                var previousBracket = stack.pollLast();
                if (previousBracket == null || !BRACKETS.inverse().get(c).equals(previousBracket)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isOpenBracket(char c) {
        return BRACKETS.containsKey(c);
    }

    private boolean isClosedBracker(char c) {
        return BRACKETS.containsValue(c);
    }
}
