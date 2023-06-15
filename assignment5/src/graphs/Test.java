package graphs;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
//		AdjMatrixGraph graph = new AdjMatrixGraph(4);
//		
//		
//		Vertex zero = new Vertex(0);
//		zero.setRec(new String("Zero"));
//		
//		Vertex one = new Vertex(1);
//		one.setRec(new String("One"));
//		
//		Vertex two = new Vertex(2);
//		two.setRec(new String("Two"));
//		
//		Vertex three = new Vertex(3);
//		three.setRec(new String("Three"));
//		
//		
//		// Add all edges from zero
//		graph.addNode(one, 3, 0, 1);
//		
//		// Add all edges from 1
//		graph.addNode(two, 1, 1, 2);
//		graph.addNode(three, 4, 1, 3);
//		
//		// Add all edges from 2
//		graph.addNode(three, 2, 2, 3);
//		
//		// Add all edges from 3
//		graph.addNode(three, 2, 3, 1);
		
		//graph.printGraph();
		
		
		//System.out.println(one.getrec());
		
		
		
		//System.out.println(graph.getNode(0, 1).getVertex().getId());
	
		
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
		
//		RandomAdjMatrixGraph g = new RandomAdjMatrixGraph(4, 4);
//		
//		g.printGraph();
//		
		DijkstraTest d = new DijkstraTest();

		
		float[] shortest = d.dijkstra(graph, 0);
		
		System.out.print("{");
		for (int i = 0; i < shortest.length; i++) {
			if (shortest[i] > 1000000) System.out.print("inf,");
			else System.out.print(shortest[i]+",");
		}
		System.out.print("}");
		System.out.println();
		
		
	
		shortest = d.dijkstra(graph, 1);
		
		System.out.print("{");
		for (int i = 0; i < shortest.length; i++) {
			if (shortest[i] > 1000000) System.out.print("inf,");
			else System.out.print(shortest[i]+",");
		}
		System.out.print("}");
		System.out.println();
		
		shortest = d.dijkstra(graph, 2);
		
		System.out.print("{");
		for (int i = 0; i < shortest.length; i++) {
			if (shortest[i] > 1000000) System.out.print("inf,");
			else System.out.print(shortest[i]+",");
		}
		System.out.print("}");
		System.out.println();
		
		
		shortest = d.dijkstra(graph, 3);
		
		System.out.print("{");
		for (int i = 0; i < shortest.length; i++) {
			if (shortest[i] > 1000000) System.out.print("inf,");
			else System.out.print(shortest[i]+",");
		}
		System.out.print("}");
		System.out.println();
		
		shortest = d.dijkstra(graph, 4);
		
		System.out.print("{");
		for (int i = 0; i < shortest.length; i++) {
			if (shortest[i] > 1000000) System.out.print("inf,");
			else System.out.print(shortest[i]+",");
		}
		System.out.print("}");
		System.out.println();
		
		System.out.println("\n\t LOOP!");
		for (int i = 0; i < graph.size; i++) {
			shortest = d.dijkstra(graph, i);
			
			System.out.print("{");
			for (int j = 0; j < shortest.length;j++) {
				if (shortest[j] > 1000000) System.out.print("inf,");
				else System.out.print(shortest[j]+",");
			}
			System.out.print("}");
			System.out.println();
		}
		
	
		
		System.out.println("RANDOM\n");
		RandomAdjMatrixGraph g = new RandomAdjMatrixGraph(4, 4);
		
		g.printGraph();
		
//		Dijkstras rd = new Dijkstras();
//		
//		shortest = rd.dijkstra(g, 0);
//		
//		System.out.print("{");
//		for (int i = 0; i < shortest.length; i++) {
//			if (shortest[i] > 1000000) System.out.print("inf,");
//			else System.out.print(shortest[i]+",");
//		}
//		System.out.print("}");
//		System.out.println();
		
		for (int j = 0; j < g.size; j++) {
			shortest = DijkstrasAPSP.dijkstra(g, j);
			
			System.out.print("{");
			for (int i = 0; i < shortest.length; i++) {
				if (shortest[i] > 1000000) System.out.print("inf,");
				else System.out.print(shortest[i]+",");
			}
			System.out.print("}");
			System.out.println();
		}

	}

}
