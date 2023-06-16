package graphs;

/**
 * This is a container class for the output of Dijkstra's Algorithm.
 * It contains an array showing the shortest path costs for a vertex and an array showing the shortest path to a vertex.
 * 
 * @author Calder Sloman
 *
 */
public class DijkstraOutput {

	private float[] D;								// Array containing the cost of shortest path that only goes through vertices in S
	private int[] P;								// Array containing the indices indicating the shortest path
	
	/**
	 * 
	 * @param cost an array of floats containing the cost of each path
	 * @param path an array if integers showing the path for the lowest cost
	 */
	public DijkstraOutput(float[] cost, int[] path) {
		D = cost;
		P = path;
	}

	public float[] getD() {
		return D;
	}

	public int[] getP() {
		return P;
	}
	
}
