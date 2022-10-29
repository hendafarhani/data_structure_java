package binarySearchTree.treeTraversal;

import binarySearchTree.BinarySearchTree;
import binarySearchTree.Node;

public class DepthFirstSearch {

    public static void depthFirstSearchPreOrder(BinarySearchTree bst) {
       explorePreOrder(bst.getRoot());
    }

    public static void depthFirstSearchPostOrder(BinarySearchTree bst) {
        explorePostOrder(bst.getRoot());
    }

    public static void depthFirstSearchInOrder(BinarySearchTree bst) {
        exploreInOrder(bst.getRoot());
    }


    private static void explorePreOrder(Node node){
        if(node == null) return;
        System.out.println(node.getValue());
        // Go left left left....
        explorePreOrder(node.getLeft());
        // Reach to this point when we have discovered the left side of a node, and we want to explore its right side as well.
        explorePreOrder(node.getRight());
    }

    private static void explorePostOrder(Node node){
        if(node == null) return;
        // Go left left left....
        explorePostOrder(node.getLeft());
        // Reach to this point when we have discovered the left side of a node, and we want to explore its right side as well.
        explorePostOrder(node.getRight());
        System.out.println(node.getValue());
    }

    private static void exploreInOrder(Node node){
        if(node == null) return;
        // Go left left left....
        exploreInOrder(node.getLeft());
        System.out.println(node.getValue());
        // Reach to this point when we have discovered the left side of a node, and we want to explore its right side as well.
        exploreInOrder(node.getRight());
    }

}
