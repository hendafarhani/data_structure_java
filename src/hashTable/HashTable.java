package hashTable;

import java.util.ArrayList;

public class HashTable {

    private int size = 7;
    private Node[] dataMap;

    public HashTable() {
        dataMap = new Node[size];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Node[] getDataMap() {
        return dataMap;
    }

    public void setDataMap(Node[] dataMap) {
        this.dataMap = dataMap;
    }

    private int hashMethod(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int i = 0; i < keyChars.length; i++) {
            int asciiValue = keyChars[i];
            hash += asciiValue * 23;
            hash %= dataMap.length; // modulo of the division of hash number by the dataMap's length,
            // is used in order to have always a number = [0..dataMap.length]
        }
        return hash;
    }

    //Time complexity is O(1)
    public void set(String key, int value) {
        int index = hashMethod(key);
        Node newNode = new Node(key, value);
        if (dataMap[index] == null) {
            dataMap[index] = newNode;
        } else {
            Node temp = dataMap[index];
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
    }

    //Time complexity is O(1)
    public Node get(String key) {
        int index = hashMethod(key);
        Node temp = dataMap[index];
        while (temp != null) {
            if (temp.getKey().equals(key)) return temp;
            temp = temp.getNext();
        }
        return null;
    }

    //Time complexity is O(n) because we need to iterate over all the linkedlist
    public ArrayList keys() {
        ArrayList listOfKeys = new ArrayList<String>();
        for (int i = 0; i < size; i++) {
            if (dataMap[i] != null) {
                listOfKeys.add(dataMap[i].getKey());
                Node temp = dataMap[i].getNext();
                while (temp != null) {
                    listOfKeys.add(temp.getKey());
                    temp = temp.getNext();
                }
            }
        }
        return listOfKeys;
    }

}
