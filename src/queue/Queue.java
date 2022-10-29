package queue;

public class Queue {

    private Node first;
    private Node last;
    private int length;

    public Queue(int value) {
        first = last = new Node(value);
        length++;
    }

    // Time complexity of append variable is constant time O(1)
    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            first = newNode;
            last = newNode;
            length++;
            return;
        }
        last.setNext(newNode);
        last = newNode;
        length++;
    }

    // Time complexity of removeFirst is O(1)
    public Node dequeue() {
        if (length == 0) return null;
        Node nodeToRemove = first;
        first = first.getNext();
        nodeToRemove.setNext(null);
        length--;
        if (length == 0) {
            last = null;
        }
        return nodeToRemove;
    }
}
