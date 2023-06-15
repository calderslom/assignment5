package graphs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DijkstraPart1App {

	static final String OUTPUT_FILE = "a5_dijsktra_part1.txt";
	static final int MIN = 500;
	static final int MAX = 1000;
	
	public static void main(String[] args) {
		// PART 1
		int density = 5;
		RandomAdjMatrixGraph graph;
		long start, end, total;
		float[] shortest;
		
		try {
            // Creating objects for output
			FileWriter fileWriter = new FileWriter(OUTPUT_FILE);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            System.out.println("The arrangement of data in the output file is as follows -");
            System.out.println("\tGraph Size:\tAlgorithm Runtime in Nanoseconds");
    			
         
            // Generating graphs that have vertices ranging from [500,1000]
    		for (int i = MIN; i <= 502; i++) {
    			graph = new RandomAdjMatrixGraph(i, density);
    			/*
    			 *  Because Dijkstra's algorithm only returns the minimum cost for an individual vertex 
    			 *  we will call it with every vertex in the graph
    			 */
    			start = System.nanoTime();
    			for (int j = 0; j < graph.size; j++) {
    				shortest = DijkstrasAPSP.dijkstra(graph, j);
    			}
    			end = System.nanoTime();
    			total = end - start;
    			bufferedWriter.write(i + "\t" + total + "\n");
    		}
            
            bufferedWriter.flush(); 
			bufferedWriter.close();
			fileWriter.close();
			System.out.println("\nDijkstra Part 1 Terminating\n");
		} catch (IOException e) {
            e.printStackTrace();
        }

		System.out.println("Terminating");
	} // End of Main

} // End of Class
