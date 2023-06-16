package graphs;

public class MainAppTester {

	public static void main(String[] args) {
	
		
		// PART 1
		
		int density = 5;
		
		RandomAdjMatrixGraph graph = new RandomAdjMatrixGraph(6, 7);
		
//		g.printGraph();
		
		float[] shortest;
		System.out.println("Dijkstras: \n");
		for (int j = 0; j < graph.size; j++) {
			//System.out.println(j);
			shortest = DijkstrasAPSP.dijkstra(graph, j);
			
			System.out.print("{");
			for (int i = 0; i < shortest.length; i++) {
				if (shortest[i] > 1000000) System.out.print("inf,");
				else System.out.print(shortest[i]+",");
			}
			System.out.print("}");
			System.out.println();
		}
		
		System.out.println("\nFloyds: \n");
		float[][] shortestPaths = FloydAlgorithm.floyd(graph);
		//System.out.println("Random index = " + shortestPaths[3][4]);
		for (int j = 0; j < shortestPaths.length; j ++) {
			System.out.print("{");
			for (int i = 0; i < shortestPaths[j].length; i++) {
				if (shortestPaths[i][j] > 100000) System.out.print("inf,");
				else System.out.print(shortestPaths[i][j]+",");
			}
			System.out.print("}");
			System.out.println();
			
		}
		
//		// Generating graphs that have vertices ranging from [500,1000]
//		for (int i = 500; i <= 1000; i++) {
//			
//		}
		
		System.out.println("Terminating");
	} // End of Main

} // End of Class
