package binarySearchTree;

public class BinarySearchTree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode.getValue() == temp.getValue()) return false;
            if (newNode.getValue() < temp.getValue()) {
                if (temp.getLeft() == null) {
                    temp.setLeft(newNode);
                    return true;
                } else {
                    temp = temp.getLeft();
                }
            } else if (newNode.getValue() > temp.getValue()) {
                if (temp.getRight() == null) {
                    temp.setRight(newNode);
                    return true;
                } else {
                    temp = temp.getRight();
                }
            }
        }
    }

    public boolean contains(int value) {
        Node temp = root;
        while (temp != null) {
            if (value > temp.getValue()) {
                temp = temp.getRight();
            }
            if (value < temp.getValue()) {
                temp = temp.getLeft();
            }
            if (value == temp.getValue()) return true;
        }
        return false;
    }

    public void remove(int value) {
        root = remove(root, value);
    }

    private Node remove(Node root, int value) {
        if (root == null) return null;
        if (root.getValue() < value) { // let's check the right side
            root.setRight(remove(root.getRight(), value));
        } else if (root.getValue() > value) { // let's check the left side
            root.setLeft(remove(root.getLeft(), value));
        } else { // Ok we have found the node we're looking for => Up to work to remove it.
            if (root.getRight() == null && root.getLeft() == null) { // If this node is a leaf
                root = null; // delete it by setting its value to null.
            } else {
                if (root.getRight() == null) { // If this node is a parent of only a left child
                    root = root.getLeft(); // Replace the node by its left child.
                } else if (root.getLeft() == null) { // If this node is a parent of only a right child
                    root = root.getRight(); // Replace the node by its right child.
                }
            }
            if (root.getLeft() != null && root.getRight() != null) { // If this node is a parent and have both left and right children
                Node minNodeRightSide = root.getRight();
                while (minNodeRightSide.getLeft() != null) { // let's look for the smallest value on the right side
                    minNodeRightSide = minNodeRightSide.getLeft();
                }
                root.setValue(minNodeRightSide.getValue()); // the smallest value found will take the place of the node we need to remove
                root.setRight(remove(minNodeRightSide, minNodeRightSide.getValue())); // Now we need to remove the node with the smallest value, and since it exists
                // on the right side then this latter must be changed also.
            }
        }
        return root;
    }

    public void traverseTree(Node node, String direction) {
        if (node == null) {
            return;
        }
        System.out.println(direction + " : " + node.getValue());
        traverseTree(node.getLeft(), "left of node " + node.getValue());
        traverseTree(node.getRight(), "right of node " + node.getValue());
    }

}
