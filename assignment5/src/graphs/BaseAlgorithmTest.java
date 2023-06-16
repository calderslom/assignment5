package graphs;

public class BaseAlgorithmTest {

	public static void main(String[] args) {

		AdjMatrixGraph graph = new AdjMatrixGraph(5);
		
		
		Vertex zero = new Vertex(0);
		zero.setRec(new String("Zero"));
		
		Vertex one = new Vertex(1);
		one.setRec(new String("One"));
		
		Vertex two = new Vertex(2);
		two.setRec(new String("Two"));
		
		Vertex three = new Vertex(3);
		three.setRec(new String("Three"));
		
		Vertex four = new Vertex(4);
		three.setRec(new String("Four"));
		
		
		// Add all edges from zero
		graph.addNode(one, 10, 0, 1);
		graph.addNode(three, 30, 0, 3);
		graph.addNode(four, 100, 0, 4);
		
		// Add all edges from 1
		graph.addNode(two, 50, 1, 2);
		
		// Add all edges from 2
		graph.addNode(four, 10, 2, 4);
		
		// Add all edges from 3
		graph.addNode(two, 20, 3, 2);
		graph.addNode(four, 60, 3, 4);
		
		// Add all edges from 4
		// none

		graph.printGraph();
		
	
		DijkstraTest d = new DijkstraTest();

		
		float[] shortest = d.dijkstra(graph, 0);
		
		
		System.out.println("\n\t Dijkstras!");
		for (int i = 0; i < graph.size; i++) {
			shortest = d.dijkstra(graph, i);
			System.out.print("Vertex[" +i + "] = ");
			System.out.print("{");
			for (int j = 0; j < shortest.length;j++) {
				if (shortest[j] > 1000000) System.out.print("inf,");
				else System.out.print(shortest[j]+",");
			}
			System.out.print("}");
			System.out.println();
		}
		
		System.out.println("\n\tFloyds!");
		float[][] shortestPaths = FloydAlgorithm.floyd(graph);
		for (int j = 0; j < shortestPaths.length; j ++) {
			System.out.print("Vertex[" + j + "] = ");
			System.out.print("{");
			for (int i = 0; i < shortestPaths[j].length; i++) {
				if (shortestPaths[i][j] > 100000) System.out.print("inf,");
				else System.out.print(shortestPaths[i][j]+",");
			}
			System.out.print("}");
			System.out.println();
			
		}
		
	
		
	}

}
