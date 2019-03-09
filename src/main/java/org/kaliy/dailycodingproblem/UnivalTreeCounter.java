package org.kaliy.dailycodingproblem;

public class UnivalTreeCounter {

    public int count(Node root) {
        if (null == root) {
            return 0;
        }
        int count = 0;
        count += count(root.getLeft());
        count += count(root.getRight());
        if (isUnival(root)) {
            count += 1;
        }
        return count;
    }

    private boolean isUnival(Node node) {
        Object left = node.getLeft() == null ? node.getVal() : node.getLeft().getVal();
        Object right = node.getRight() == null ? node.getVal() : node.getRight().getVal();
        return node.getVal().equals(left) && node.getVal().equals(right);
    }
}
