import java.util.*;

public class Graph {
    private Set<String> vertices;
    private List<Edge> edges;

    public Graph() {
        this.vertices = new HashSet<>();
        this.edges = new ArrayList<>();
    }

    public void addVertex(String v) {
        vertices.add(v);
    }

    public void addEdge(String id, String start, String end) {
        if (vertices.contains(start) && vertices.contains(end)) {
            edges.add(new Edge(id, start, end));
        } else {
            System.out.println("Error: One or both vertices do not exist.");
        }
    }

    public List<Edge> getEdges() { return edges; }
    
    public Edge findEdge(String id, String start, String end) {
        for (Edge e : edges) {
            if (e.getId().equals(id) && 
               (e.getStartNode().equals(start) && e.getEndNode().equals(end))) {
                return e;
            }
        }
        return null;
    }
}