package org.kaliy.dailycodingproblem;

/**
 * Implement a stack that has the following methods:
 * <ul><li>push(val), which pushes an element onto the stack</li>
 * <li>pop(), which pops off and returns the topmost element of the stack. If there are no elements in the stack, then it should throw an error or return null.</li>
 * <li>max(), which returns the maximum value in the stack currently. If there are no elements in the stack, then it should throw an error or return null.</li></ul>
 * Each method should run in constant time.
 */
public class StackWithMax<T extends Comparable<T>> {
    private Node first;

    public void push(T value) {
        var firstNode = new Node();
        firstNode.val = value;
        firstNode.next = first;
        firstNode.max = null == first ? value : (value.compareTo(first.max) > 0 ? value : first.max);
        first = firstNode;
    }

    public T pop() {
        if (null == first) {
            return null;
        }
        var node = first;
        first = first.next;
        return node.val;
    }

    public T max() {
        return null == first ? null : first.max;
    }

    private class Node {
        T val;
        T max;
        Node next;
    }
}
