public class Edge {
    private String id;
    private String startNode;
    private String endNode;

    public Edge(String id, String startNode, String endNode) {
        this.id = id;
        this.startNode = startNode;
        this.endNode = endNode;
    }

    public String getId() { return id; }
    public String getStartNode() { return startNode; }
    public String getEndNode() { return endNode; }
}