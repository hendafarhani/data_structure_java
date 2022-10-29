package stack;

public class Stack {

    private Node top;
    private int height;

    public Stack(int value) {
        Node top = new Node(value);
        height = 1;
    }

    public Node getTop() {
        return top;
    }

    public void setTop(Node top) {
        this.top = top;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    // Time complexity of prepend is O(1)
    public void push(int value) {
        Node newNode = new Node(value);
        if (height > 0) {
            newNode.setNext(top);
        }
        top = newNode;
        height++;
    }

    public Node pop() {
        if (height == 0) return null;
        Node nodeToRemove = top;
        if (height == 1) {
            top = null;
        }else {
            top.setNext(null);
            top = nodeToRemove.getNext();
        }
        height--;
        return nodeToRemove;
    }


}
