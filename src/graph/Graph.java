package graph;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    private HashMap<String, ArrayList<String>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    public HashMap<String, ArrayList<String>> getAdjList() {
        return adjList;
    }

    public void setAdjList(HashMap<String, ArrayList<String>> adjList) {
        this.adjList = adjList;
    }

    // Time complexity is O(1)
    public boolean addVertex(String vertex) {
        if (adjList.get(vertex) == null) { //check if this vertex is not already existing in the graph
            adjList.put(vertex, new ArrayList<>());
            return true;
        }
        return false;
    }

    //Time complexity is O(1)
    public boolean addEdge(String vertex1, String vertex2) {
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
            return true;
        }
        return false;
    }

    // Time Complexity is O(n)
    public boolean removeEdge(String vertex1, String vertex2) {
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).remove(vertex2);
            adjList.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }

    //Time complexity ??
    public boolean removeVertex(String vertex) {
        if (adjList.get(vertex) == null) return false;
        for (String v : adjList.get(vertex)) {
            adjList.get(v).remove(vertex);
        }
        adjList.remove(vertex);
        return true;
    }

}
