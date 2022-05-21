package preparation.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private static Map<Integer, List<Integer>> undirectedGraph = new HashMap<>();
    private static Map<Integer, List<Integer>> directedGraph = new HashMap<>();
    private static final List<int[]> edges = new ArrayList<>();
    static{
        edges.add(new int[]{1, 2, 2});
        edges.add(new int[]{2, 3, 1});
        edges.add(new int[]{1, 3, 4});
        edges.add(new int[]{2, 4, 2});
        edges.add(new int[]{3, 4, 3});
        edges.add(new int[]{4, 5, 9});
    }
    public static void main(String[] args) {
        createUndirectedGraph();
        createDirectedGraph();
    }

    private static void createUndirectedGraph() {
        for(int[] edge: edges){
            List<Integer> nodeEdgeList = undirectedGraph.getOrDefault(edge[0], new ArrayList<>());
            nodeEdgeList.add(edge[1]);
            undirectedGraph.put(edge[0], nodeEdgeList);
            nodeEdgeList = undirectedGraph.getOrDefault(edge[1], new ArrayList<>());
            nodeEdgeList.add(edge[0]);
            undirectedGraph.put(edge[1], nodeEdgeList);
        }
    }

    private static void createDirectedGraph() {

    }

    private static Map<Integer, List<Integer>> getMinimumSpanningTree() {
        return null;
    }
}
