package org.kaliy.dailycodingproblem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root to a binary tree, implement serialize(root), which serializes the tree into a string,
 * and deserialize(s), which deserializes the string back into the tree.
 */
public class NodeSerialization {
    public static class Node {
        private final String val;
        private final Node left;
        private final Node right;

        public Node(String val) {
            this(val, null, null);
        }

        public Node(String val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public String serialize() {
            return String.format("%s\t%s\t%s", val, serialize(left), serialize(right));
        }

        private String serialize(Node node) {
            return null == node ? "" : node.serialize();
        }

        public static Node from(String serialized) {
            String[] vals = serialized.split("\t", -1);
            Queue<String> queue = new LinkedList<>(Arrays.asList(vals));
            String val = queue.poll();
            return new Node(val, from(queue.poll(), queue), from(queue.poll(), queue));
        }

        private static Node from(String val, Queue<String> queue) {
            if (null == val || val.isEmpty()) {
                return null;
            }
            return new Node(val, from(queue.poll(), queue), from(queue.poll(), queue));
        }

        public String getVal() {
            return val;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        @Override
        public String toString() {
            return serialize();
        }
    }
}
