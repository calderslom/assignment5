package graphs;

import java.util.ArrayList;

public class Dijkstras {
	
	private float[] D;										// Array containing the cost of shortest path that only goes through vertices in S
	private int currentMinimum;								// Contains the index of the vertex which represents the minimum cost to get out of s
	
	/**
	 * 
	 * @param g an adjacency matrix of Class type AdjListGraph
	 * @param s the starting Vertex, which must be an element in G
	 * @return
	 */
	public float[] dijkstra(RandomAdjMatrixGraph g, int s) {
		ArrayList<Integer> S = new ArrayList<Integer>();	// ArrayList containing vertices for which the shortest path has already been calculated. ArrayList speeds up searches.
		D = new float[g.size];								// Initializing D to have a cell for each vertex in the graph
		currentMinimum = 0;
		
		S.add(new Integer(s));							// s is the first vertex in the array (shortest path from a vertex to itself is to stay there)
		
		int vertices = g.size - 1;						// Vertices are numbered 0 through |V| - 1
		
		// #2 and #3 in notes
		/*
		 * We must initialize all the cells in D to the shortest path from s to every vertex v in the Graph.
		 * Initially, this is just the direct path from s to v (which is found in the adjacency matrix).
		 */
		for (int v = 0; v <= vertices; v ++) {
			Node node = g.getNode(s, v);
			if (node != null) {
				float weight = node.getWeight();	 
				D[v] = weight;
				if (weight < D[currentMinimum]) currentMinimum = v;  // Records the index with the lowest cost
			}
			else D[v] = Integer.MAX_VALUE;								// MAXIMUM represents the fact that there is no edge from s to v 	
		}
		
		D[s] = 0;										// The shortest path from from a vertex to itself is 0
		
		
		// #4 in notes
		for (int n = 0; n <= vertices; n++) {
			int w = this.findMinimum(D, S);			// line 5 of algorithm
			if (w > 0) {
				S.add(new Integer(w));					// line 6 of algorithm
				for (int v = 0; v <= vertices; v++) {
					Node tmp = g.getNode(w,v);
					if (D[v] > 0 && tmp != null) {
						D[v] = Math.min(D[v], D[w] + tmp.getWeight());
					}
					else if (tmp != null) {
						D[v] = D[w] + tmp.getWeight();
					}
				}
			}
		}	
		return D;										// Returning the cost of the shortest path from s to every vertex in G
	
	} // End of Class
	
	public int findMinimum(float[] D, ArrayList<Integer> S) {
		float min = Integer.MAX_VALUE;
		int minIndex = -1;
		for (int i = 0; i < D.length; i++) {
			float tmp = D[i];
			if(!S.contains(new Integer(i)) && tmp < min) {
				min = tmp;
				minIndex = i;
			}
		}
		return minIndex;
	}
	
} // End of Main
