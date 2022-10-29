package linkedList;

public class Node {

    private int value;
    private  Node next;

    Node(int value) {
        this.value = value;
    }

    Node getNext() {
        return this.next;
    }

    void setNext(Node node) {
        this.next = node;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
