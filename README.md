# BinaryTreeADT_JAVA
Assignement 1 for Algorithms and Data Structure. Th purpose is to create a binary tree and binary search tree in JAVA and unit test all the methods.


---
In this assignment you Will implement a binary search tree with one special
operation: rebalance.
Before you start coding consider the ADT and make sure you know exactly what to
do. You are going to make a generic tree, that is a tree that can store any kind of
type (but for the BST it must implement the comparable interface).
The traversals return an ArrayList of the objects in the tree, you don't need to return an iterator.
You don't need to support more than one occurrence of each element either.

It's recommended to build the tree in phases:

- [x] Abinary tree
- [x] A binary search tree with add and remove
- [x] A binary search tree with rebalance (not to be mistaken with a self-balancing tree)

Test driven development is well suited for the project since it can be broken into
smaller bits that can be test on their own. Besides, it is a requirement that all parts
of the code are well tested. When you encounter errors, it can be useful to see a
graphical representation of the tree.
To that end I have uploaded the source code for a simple ascii code printout of a
tree, but you are welcome to make a nicer graphical presentation (it is not a
requirement).
Remember that in phase one there are no add or delete methods. This is because a
general binary tree does not have a specific ordering. In order to create a tree, you
must manually do it by creating and combining nodes.
