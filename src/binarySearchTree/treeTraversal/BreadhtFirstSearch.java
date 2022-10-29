package binarySearchTree.treeTraversal;


import binarySearchTree.BinarySearchTree;
import binarySearchTree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class BreadhtFirstSearch {

    // Visit the node, then its left child after that visit its right child. Repeat.
    public static void breadthFirstSearch(BinarySearchTree bst) {
        // Use a queue for breadth first search.
        // Each time pop a node and push its left and right children.
        Queue<Node> queue = new LinkedList<>();
        queue.add(bst.getRoot());
        while (queue.size() > 0) {
            Node temp = queue.poll();
            if (temp.getLeft() != null) {
                queue.add(temp.getLeft());
            }
            if (temp.getRight() != null) {
                queue.add(temp.getRight());
            }
            System.out.println(temp.getValue());
        }
    }
}