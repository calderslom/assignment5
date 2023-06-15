package graphs;

import java.util.ArrayList;

public class DijkstraTest {
	
	private float[] D;										// Array containing the cost of shortest path that only goes through vertices in S
	private int currentMinimum;								// Contains the index of the vertex which represents the minimum cost to get out of s
	
	/**
	 * 
	 * @param g an adjacency matrix of Class type AdjListGraph
	 * @param s the starting Vertex, which must be an element in G
	 * @return
	 */
	public float[] dijkstra(AdjMatrixGraph g, int s) {
		ArrayList<Integer> S = new ArrayList<Integer>();
		//int[] S = new int[g.size];				        // Array containing vertices for which the shortest path has already been calculated
		D = new float[g.size];							// Initializing D to have a cell for each vertex in the graph
		currentMinimum = 0;
		
//		/*
//		 *  S tracks the vertices for which we have already calculated the shortest path
//		 *  we will set all cells in the array to -1 initially. S[i] = -1 represents and index
//		 *  i that has NOT had it's shortest path calculated.
//		 */
//		for (int i = 0; i < S.length; i ++) {
//			S[i] = -1;
//		}
		
		//S[0] = s;										// s is the first vertex in the array (shortest path from a vertex to itself is to stay there)
		
		S.add(new Integer(s));
		
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
		
		
		//System.out.println(" is zero in S? = " + S.contains(new Integer(7)));
		
		// #4 in notes
		for (int n = 0; n <= vertices; n++) {
			int w = this.findMinimum(D, S);			// line 5 of algorithm
			//System.out.println("Minimum =" + w);
			if (w > 0) {
				S.add(new Integer(w));					// line 6 of algorithm
				for (int v = 0; v <= vertices; v++) {
					Node tmp = g.getNode(w,v);
					if (D[v] > 0 && tmp != null) {
						D[v] = Math.min(D[v], D[w] + tmp.getWeight());
//						System.out.println("D[w] = " + D[w]);
//						System.out.println("tmp = " + tmp.getWeight());
						//System.out.println("v = " + v + "   D[v] = " + D[v]);
					}
					else if (tmp != null) {
//						System.out.println("D[w] = " + D[w]);
//						System.out.println("tmp = " + tmp.getWeight());
						D[v] = D[w] + tmp.getWeight();
					}
				}
			}
		}
		
		
//		// TEST to see shortest path costs
//		for (int v = 0; v <= vertices; v ++) {
//			System.out.println("Vertex " + v + ":\t" + D[v]);
//		}
		
//		// TEST to see vertices in S
//		for (int i = 0; i < S.length; i ++) {
//			System.out.println("Vertex " + i + " in S = " + S[i]);
//		}
		
		
		return D;										// Returning the cost of the shortest path from s to every vertex in G
	}
	
	public int findMinimum(float[] D, ArrayList<Integer> S){
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
	
}
