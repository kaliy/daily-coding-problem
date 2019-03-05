# Daily Coding Problem

[![Build Status](https://travis-ci.com/kaliy/daily-coding-problem.svg?branch=master)](https://travis-ci.com/kaliy/daily-coding-problem)

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
