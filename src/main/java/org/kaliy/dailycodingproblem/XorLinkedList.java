package org.kaliy.dailycodingproblem;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.Optional;
import java.util.Random;

/**
 * An XOR linked list is a more memory efficient doubly linked list. Instead of each node holding next and prev fields,
 * it holds a field named both, which is an XOR of the next node and the previous node. Implement an XOR linked list;
 * it has an add(element) which adds the element to the end, and a get(index) which returns the node at index.
 * <p>
 * The implementation is not thread safe
 */
public class XorLinkedList<T> {
    // I've implemented only addLast and get(index) operations as they were the only ones required in the problem.
    // Maybe someday in the future I will implement the Deque interface :)
    // As java has no pointers (only references), let's emulate the memory with a map of an integer to an object.
    // integer here is an emulation of intptr_t - integer representation of pointer.
    private final BiMap<Integer, Node> memory = HashBiMap.create();
    private Integer first;
    private Integer last;
    private int size = 0;

    private final static int ZERO = 0;

    private class Node {
        private int both;
        private T value;

        public Node getOther(int pointer) {
            int otherPointer = pointer ^ both;
            return dereference(otherPointer);
        }

        private Node(T value) {
            this.value = value;
        }
    }

    public void addLast(T element) {
        Node node = new Node(element);
        int lastPointer = addToMemory(node);
        if (null == last) {
            first = last = lastPointer;
            node.both = ZERO;
        } else {
            Node previous = dereference(last);
            previous.both = previous.both ^ lastPointer;
            node.both = last;
            last = lastPointer;
        }
        size++;
    }

    public Optional<T> get(int index) {
        if (index >= size || index < 0) {
            return Optional.empty();
        } else if (index == size - 1) {
            return Optional.of(dereference(last).value);
        } else if (index == 0) {
            return Optional.of(dereference(first).value);
        } else {
            int pointer = first, numberOfIterations = index;
            if (index > size / 2) {
                pointer = last;
                numberOfIterations = size - 1 - index;
            }
            int previous = ZERO;
            for (int i = 1; i <= numberOfIterations; i++) {
                Node next = dereference(pointer).getOther(previous);
                previous = pointer;
                pointer = getPointer(next);
            }
            return Optional.of(dereference(pointer).value);
        }
    }

    private Node dereference(int pointer) {
        return memory.get(pointer);
    }

    private int getPointer(Node node) {
        return memory.inverse().get(node);
    }

    private int addToMemory(Node node) {
        int address = new Random().ints().filter(i -> i != ZERO && !memory.containsKey(i)).findFirst().getAsInt();
        memory.put(address, node);
        return address;
    }
}
