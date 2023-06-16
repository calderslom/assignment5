package graphs;

import java.util.ArrayList;
/**
 * Class that contains the implementation of Dijkstra's algorithm. The dijkstra method contained in this class
 * should be accessed statically.
 * 
 * @author Calder Sloman
 *
 */
public class DijkstrasAlgorithm {

	/**
	 * Method which uses Dijkstra's APSP algorithm to determine the shortest path between 
	 * a vertex s and all other vertices in a graph.
	 * 
	 * @param g an adjacency matrix of Class type AdjListGraph
	 * @param s the starting Vertex, which must be an element in G
	 * @return an array of floats representing the lowest cost to travel from the vertex s to all other vertices in g
	 */
	public static DijkstraOutput dijkstra(AdjMatrixGraph g, int s) {
		boolean[] S = new boolean[g.size];						// Array containing boolean values that indicate vertices for which the shortest path has already been calculated.
		float[] D = new float[g.size];							// Array containing the cost of shortest path that only goes through vertices in S
		int[] P = new int[g.size];								// Array containing the indices indicating the shortest path
		
		for (int i = 0; i < S.length; i ++) S[i] = false;		// Setting the boolean array to false for all vertices
		S[s] = true;											// Line #1 of the in-class algorithm
		
		int vertices = g.size - 1;								// Vertices are numbered 0 through |V| - 1
		
		/* Lines #2 and #3 of the in-class Algorithm
		 * We must initialize all the cells in D to the shortest path from s to every vertex v in the Graph.
		 * Initially, this is just the direct path from s to v (which is found in the adjacency matrix).
		 */
		for (int v = 0; v <= vertices; v ++) {
			P[v] = s;
			Node node = g.getNode(s, v);
			if (node != null) {
				float weight = node.getWeight();	 
				D[v] = weight;
			}
			else D[v] = Integer.MAX_VALUE;								// MAXIMUM represents the fact that there is no edge from s to v 	
		}
		
		D[s] = 0;														// The shortest path from from a vertex to itself is 0
		
		
		for (int n = 0; n <= vertices; n++) {							// Line #4 of the in-class algorithm
			int w = findMinimum(D, S);									// Line #5 of the in-class algorithm
			if (w > 0) {
				S[w] = true;											// Line #6 of the in-class algorithm
				for (int v = 0; v <= vertices; v++) {					// Lines #7 and #8 of the in-class algorithm
					Node tmp = g.getNode(w,v);
					if (D[v] > 0 && tmp != null) {
						D[v] = Math.min(D[v], D[w] + tmp.getWeight());
						P[v] = w;
					}
					else if (tmp != null) {
						D[v] = D[w] + tmp.getWeight();
						P[v] = w;
					}
				}
			}
		}	

		return new DijkstraOutput(D, P);										// Returning both D and P as specified in the APSP algorithm given in class.
	
	} // End of dijkstra
	
	
	/**
	 * 
	 * @param D
	 * @param S
	 * @return the index in D that represents the shortest
	 */
	public static int findMinimum(float[] D, boolean[] S) {
		float min = Integer.MAX_VALUE;
		int minIndex = -1;
		for (int i = 0; i < D.length; i++) {
			float tmp = D[i];
			if(!S[i] && tmp < min) {
				min = tmp;
				minIndex = i;
			}
		}
		return minIndex;
	}
	
} // End of Class
