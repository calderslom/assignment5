package graphs;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


public class DijkstraAPSP {
    
    public static int[] dijkstra(AdjMatrixGraph graph, int startVertex) {
        int size = graph.size;
        int[] distance = new int[size];
        boolean[] visited = new boolean[size];
        
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(visited, false);
        
        distance[startVertex] = 0;
        
        for (int i = 0; i < size - 1; i++) {
            int minVertex = getMinDistanceVertex(distance, visited);
            visited[minVertex] = true;
            
            for (int j = 0; j < size; j++) {
                if (!visited[j] && graph.getNode(minVertex, j) != null) {
                    Float weight = graph.getNode(minVertex, j).getWeight();
                    distance[j] = (int) Math.min(distance[j], distance[minVertex] + weight);
                }
            }
        }
        
        return distance;
    }
    
    private static int getMinDistanceVertex(int[] distance, boolean[] visited) {
        int minDistance = Integer.MAX_VALUE;
        int minVertex = -1;
        
        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && distance[i] < minDistance) {
                minDistance = distance[i];
                minVertex = i;
            }
        }
	    if(minVertex == -1) {
	        for(int v = 0; v < visited.length; v++) {
	            if(!visited[v]) {
	                minVertex = v;
	                break;
	            }
	        }
	    }

	    return minVertex;
	}
    


    
	public static void main(String[] args) throws IOException {

        FileWriter graph_writer = new FileWriter("graph.txt");
        for (int j = 500; j < 1000; j++) {
        RandomAdjMatrixGraph randomGraph = new RandomAdjMatrixGraph(j, 5);

        int sourceVertex = 0; 
        long start = System.currentTimeMillis();
        int[] distances = dijkstra(randomGraph, sourceVertex);
        long end = System.currentTimeMillis();
        long time = end - start;
        graph_writer.write(time + "ms\n");
        }

        graph_writer.close();
        System.out.println("Output written to file successfully."); 
    }
}
