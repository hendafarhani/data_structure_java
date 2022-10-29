package doublyLinkedList;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public int getLength() {
        return length;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    // Time Complexity is O(1)
    public boolean append(int value) {
        if (length == 0) return false;
        Node newNode = new Node(value);
        if (length == 1) {
            head.setNext(newNode);
            newNode.setPrev(head);
            tail = newNode;
            length++;
            return true;
        }
        tail.setNext(newNode);
        newNode.setPrev(tail);
        tail = newNode;
        length++;
        return true;
    }

    // Time complexity O(1)
    // Unlikely linkedList we don't have to iterate over all elements to find the node that comes just before the tail.
    // Since here each node points to both next and previous nodes we can simply
    // find the element that comes before the tail via gerPrev() method.
    public Node removeLast() {
        if (length == 0) return null;
        Node nodeToRemove = tail;
        if (length == 1) {
            head = tail = null;
            length = 0;
            return nodeToRemove;
        }
        tail = nodeToRemove.getPrev();
        tail.setNext(null);
        nodeToRemove.setPrev(null);
        length--;
        return nodeToRemove;
    }

    // Time Complexity is O(1)
    public boolean prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            tail = head = newNode;
            length++;
            return true;
        }
        head.setPrev(newNode);
        newNode.setNext(head);
        newNode.setPrev(null);
        head = newNode;
        length++;
        return true;
    }

    // Time Complexity is O(1)
    public Node removeFirst() {
        if (length == 0) return null;
        Node nodeToRemove = head;
        if (length == 1) {
            head = tail = null;
            length = 0;
            return nodeToRemove;
        }
        head = head.getNext();
        head.setPrev(null);
        nodeToRemove.setNext(null);
        length--;
        return nodeToRemove;
    }

    // Time complexity is O(n)
    public Node get(int index) {
        if (index < 0 || index > length - 1) return null;
        Node node;
        int i;
        if (index > length / 2) {
            node = tail;
            i = length - 1;
            while (i > index) {
                node = node.getPrev();
                i--;
            }
        } else {
            node = head;
            i = 0;
            while (i < index) {
                node = node.getNext();
                i++;
            }
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
        newNode.setPrev(prev);
        newNode.setNext(prev.getNext());
        prev.setNext(newNode);
        newNode.getNext().setPrev(newNode);
        length++;
        return true;
    }

    // Time complexity is O(n)
    public Node remove(int index) {
        if (index < 0 || index > length - 1) return null;
        if (index == 0) {
            return removeFirst();
        }
        if (index == length - 1) {
            return removeLast();
        }
        Node nodeToRemove = get(index);
        Node prev = nodeToRemove.getPrev();
        Node next = nodeToRemove.getNext();
        prev.setNext(next);
        next.setPrev(prev);
        nodeToRemove.setPrev(null);
        nodeToRemove.setNext(null);
        length --;
        return nodeToRemove;
    }

}
