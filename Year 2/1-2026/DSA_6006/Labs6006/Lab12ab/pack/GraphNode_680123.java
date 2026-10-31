package Lab12ab.pack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphNode_680123 {

    public static class Node {
        int value;
        List<Node> neighbors;

        Node(int value) {
            this.value = value;
            this.neighbors = new ArrayList<>();
        }

        void addNeighbor(Node node) {
            if (!neighbors.contains(node)) {
                neighbors.add(node);
            }
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    private final List<Node> nodes;

    public GraphNode_680123(int n, List<int[]> edges) {
        this.nodes = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            addNode(i);
        }

        if (edges != null) {
            for (int[] edge : edges) {
                if (edge != null && edge.length == 2) {
                    addEdge(edge[0], edge[1]);
                }
            }
        }
    }

    public Node addNode(int value) {
        Node node = getNode(value);
        if (node != null) {
            return node;
        }
        Node newNode = new Node(value);
        nodes.add(newNode);
        return newNode;
    }

    public void addEdge(int a, int b) {
        if (a == b) {
            return;
        }

        Node nodeA = addNode(a);
        Node nodeB = addNode(b);
        nodeA.addNeighbor(nodeB);
        nodeB.addNeighbor(nodeA);
    }

    public List<Node> neighborsOf(int value) {
        Node node = getNode(value);
        if (node == null) {
            return Collections.emptyList();
        }
        return node.neighbors;
    }

    public boolean hasEdge(int a, int b) {
        Node nodeA = getNode(a);
        Node nodeB = getNode(b);
        return nodeA != null && nodeB != null && nodeA.neighbors.contains(nodeB);
    }

    public boolean hasPath(int start, int target) {
        Node startNode = getNode(start);
        Node targetNode = getNode(target);

        if (startNode == null || targetNode == null) {
            return false;
        }

        return hasPathDfs(startNode, targetNode, new HashSet<>());
    }

    private boolean hasPathDfs(Node current, Node target, Set<Node> visited) {
        if (current == target) {
            return true;
        }

        visited.add(current);
        for (Node neighbor : current.neighbors) {
            if (!visited.contains(neighbor) && hasPathDfs(neighbor, target, visited)) {
                return true;
            }
        }
        return false;
    }

    public void dfs(int start) {
        Node startNode = getNode(start);
        if (startNode == null) {
            return;
        }

        dfs(startNode, new HashSet<>());
        System.out.println();
    }

    private void dfs(Node current, Set<Node> visited) {
        visited.add(current);
        System.out.print(current + " ");

        for (Node neighbor : current.neighbors) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited);
            }
        }
    }

    public void printGraph() {
        for (Node node : nodes) {
            System.out.print(node + " -> ");
            for (Node neighbor : node.neighbors) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    private Node getNode(int value) {
        for (Node node : nodes) {
            if (node.value == value) {
                return node;
            }
        }
        return null;
    }
}