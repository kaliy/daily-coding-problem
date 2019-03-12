package org.kaliy.dailycodingproblem;

import java.util.Collection;
import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * Implement an autocomplete system. That is, given a query string s and a set of all possible query strings,
 * return all strings in the set that have s as a prefix.
 */
public class AutoComplete {
    //Java doesn't have standard trie implementation and TreeSet is good enough for this task
    private NavigableSet<String> dictionary;

    public AutoComplete(Collection<String> dictionary) {
        if (null == dictionary || dictionary.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.dictionary = new TreeSet<>(dictionary);
    }

    public Collection<String> complete(String start) {
        if (null == start || start.isEmpty()) {
            throw new IllegalArgumentException();
        }
        String until = new StringBuilder(start)
                .replace(
                        start.length() - 1,
                        start.length(),
                        Character.toString(start.charAt(start.length() - 1) + 1)
                ).toString();
        return dictionary.subSet(start, true, until, false);
    }
}
