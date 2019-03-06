# Daily Coding Problem

[![Build Status](https://travis-ci.com/kaliy/daily-coding-problem.svg?branch=master)](https://travis-ci.com/kaliy/daily-coding-problem)
[![codecov](https://codecov.io/gh/kaliy/daily-coding-problem/branch/master/graph/badge.svg)](https://codecov.io/gh/kaliy/daily-coding-problem)

Once I decided to solve one coding problem a day (or at least try to).

This repository contains my solutions to these coding problems. All of them were provided by [dailycodingproblem.com](https://www.dailycodingproblem.com)

## Find a sum in array (SumInArray.java)

This problem was recently asked by Google.

Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus: Can you do this in one pass?

## Serialize and deserialize binary tree (NodeSerialization.java)

This problem was asked by Google.

Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.

For example, given the following Node class

~~~~
class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
~~~~
        
The following test should pass:

~~~~
node = Node('root', Node('left', Node('left.left')), Node('right'))
assert deserialize(serialize(node)).left.left.val == 'left.left'
~~~~

## Multiply each array element with every other element (ArrayMultiplication.java)

This problem was asked by Uber.

Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?

## Functional pairs (FunctionalPairs.java)

This problem was asked by Jane Street.

cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair. For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.

Given this implementation of cons:

~~~~
def cons(a, b):
    def pair(f):
        return f(a, b)
    return pair
~~~~

Implement car and cdr.

