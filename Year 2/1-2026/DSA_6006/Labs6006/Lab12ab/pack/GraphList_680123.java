package Lab12ab.pack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GraphList_680123 {
    private List<Integer>[] adjacencyList;

    @SuppressWarnings("unchecked")
    public GraphList_680123(int n, List<int[]> edges) {
        this.adjacencyList = new ArrayList[n];

        for (int vertex = 0; vertex < n; vertex++) {
            this.adjacencyList[vertex] = new ArrayList<>();
        }

        if (edges != null) {
            for (int[] edge : edges) {
                if (edge != null && edge.length == 2) {
                    addEdge(edge[0], edge[1]);
                }
            }
        }
    }

    public void addEdge(int a, int b) {
        if (!isValidVertex(a) || !isValidVertex(b) || a == b) {
            return;
        }
        addNeighbor(a, b);
        addNeighbor(b, a);
    }

    public List<Integer> neighborsOf(int vertex) {
        if (!isValidVertex(vertex)) {
            return Collections.emptyList();
        }
        return adjacencyList[vertex];
    }

    public boolean hasEdge(int a, int b) {
        if (!isValidVertex(a) || !isValidVertex(b)) {
            return false;
        }
        return adjacencyList[a].contains(b);
    }

    public boolean hasPath(int start, int target) {
        if (!isValidVertex(start) || !isValidVertex(target)) {
            return false;
        }

        return hasPathDfs(start, target, new boolean[adjacencyList.length]);
    }

    private boolean hasPathDfs(int current, int target, boolean[] visited) {
        if (current == target) {
            return true;
        }

        visited[current] = true;

        for (int neighbor : adjacencyList[current]) {
            if (!visited[neighbor] && hasPathDfs(neighbor, target, visited)) {
                return true;
            }
        }
        return false;
    }

    public void dfs(int start) {
        if (!isValidVertex(start)) {
            return;
        }

        dfs(start, new boolean[adjacencyList.length]);
        System.out.println();
    }

    private void dfs(int current, boolean[] visited) {
        visited[current] = true;
        System.out.print(current + " ");

        for (int neighbor : adjacencyList[current]) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited);
            }
        }
    }

    public void printGraph() {
        for (int vertex = 0; vertex < adjacencyList.length; vertex++) {
            System.out.print(vertex + " -> ");
            for (int neighbor : adjacencyList[vertex]) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    private void addNeighbor(int source, int destination) {
        if (!adjacencyList[source].contains(destination)) {
            adjacencyList[source].add(destination);
        }
    }

    private boolean isValidVertex(int vertex) {
        return vertex >= 0 && vertex < adjacencyList.length;
    }
}