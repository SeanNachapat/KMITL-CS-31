import java.util.*;

public class Path {
    
    public static void analyzePath(Graph graph, String[] sequence) {
        if (sequence.length < 3 || sequence.length % 2 == 0) {
            System.out.println("Invalid sequence format.");
            return;
        }

        boolean isValidWalk = true;
        List<String> visitedEdges = new ArrayList<>();

        for (int i = 0; i < sequence.length - 2; i += 2) {
            String currentV = sequence[i];
            String edgeId = sequence[i + 1];
            String nextV = sequence[i + 2];

            Edge e = graph.findEdge(edgeId, currentV, nextV);
            if (e == null) {
                isValidWalk = false;
                break;
            }
            visitedEdges.add(edgeId);
        }

        if (!isValidWalk) {
            System.out.println("Result: Not a valid walk.");
        } else {
            System.out.println("Result: This is a valid Walk.");
            
            Set<String> uniqueEdges = new HashSet<>(visitedEdges);
            if (uniqueEdges.size() == visitedEdges.size()) {
                System.out.println("- It is a Trail.");
            }

            if (sequence[0].equals(sequence[sequence.length - 1])) {
                System.out.println("- It is a Circuit.");
            }
        }
    }
}