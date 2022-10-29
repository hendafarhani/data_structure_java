package linkedList;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    // Time complexity of append variable is constant time O(1)
    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
            length++;
            return;
        }
        tail.setNext(newNode);
        tail = newNode;
        length++;
    }

    // Time complexity of removeLast is O(n) we need to iterate over all elements in
    // the linked list to find the node that comes just before the tail
    public Node removeLast() {
        if (length == 0) return null;
        Node temp = head;
        Node nodeToRemove = null;
        while (nodeToRemove.getNext() != null) {
            temp = nodeToRemove;
            nodeToRemove = temp.getNext();
        }
        temp.setNext(null);
        tail = temp;
        length--;
        if (length == 0) {
            tail = null;
            head = null;
        }
        return nodeToRemove;
    }

    // Time complexity of prepend is O(1)
    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            tail = newNode;
        } else {
            newNode.setNext(head);
        }
        head = newNode;
        length++;
    }

    // Time complexity of removeFirst is O(1)
    public Node removeFirst() {
        if (length == 0) return null;
        Node temp = head;
        head = head.getNext();
        temp.setNext(null);
        length--;
        if (length == 0) {
            tail = null;
        }
        return temp;
    }

    // Time complexity is O(n)
    public Node get(int index) {
        if (index < 0 || index >= length) return null;
        int i = 0;
        Node node = head;
        while (i < index) {
            i++;
            node = node.getNext();
        }
        return node;
    }

    // Time complexity is O(n)
    public boolean set(int index, int value) {
        Node node = get(index);
        if (node != null) {
            node.setValue(value);
            return true;
        }
        return false;
    }

    // Time complexity is O(n)
    public boolean insert(int index, int value) {
        if (index < 0 || index > length) return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node prev = get(index - 1);
        newNode.setNext(prev.getNext());
        prev.setNext(newNode);
        length++;
        return true;
    }

    //Time complexity is O(n)
    public Node remove(int index) {
        if (index < 0 || index > length - 1) return null;
        if (index == 0) {
            return removeFirst();
        }
        Node temp = get(index - 1);
        Node nodeToRemove = temp.getNext();
        temp.setNext(nodeToRemove.getNext());
        nodeToRemove.setNext(null);
        return nodeToRemove;
    }

    // Time Complexity is O(n)
    public void reverse() {
        Node temp = get(0);
        Node before = null;
        for (int i = 0; i < length; i++) {
            Node after = temp.getNext();
            temp.setNext(before);
            before = temp;
            temp = after;
        }
        tail = head;
        head = before;
    }
}
