package org.kaliy.dailycodingproblem;

public class Node<T> {
    private T val;
    private final Node left;
    private final Node right;

    public Node(T val) {
        this(val, null, null);
    }

    public Node(T val, Node left, Node right) {
        assert val != null;
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public T getVal() {
        return val;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}
