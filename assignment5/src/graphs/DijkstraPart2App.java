package graphs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/** 
 * This is the class that executes Dijkstra's algorithm on graphs with 5000 vertices and multiple densities. It outputs the runtime of 
 * the algorithm for each density to a text file in the working directory. The file is rewritten after every execution of the program.
 * 
 * 
 * @author Calder Sloman
 * 
 */
public class DijkstraPart2App {

	static final String OUTPUT_FILE = "a5_dijsktra_part2.txt";
	static final int MIN = 1;
	static final int MAX = 9;
	
	public static void main(String[] args) {
		int density = 5;
		RandomAdjMatrixGraph graph;
		long start, end, total;
		float[] shortest;	
		System.out.println("The results of Part 2: Dijkstra's Algorithm are stored in - " + OUTPUT_FILE + " - located in your working directory.\n");
		
		try {
            // Creating objects for output
			FileWriter fileWriter = new FileWriter(OUTPUT_FILE);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            System.out.print("The arrangement of data in the output file is as follows -");
            System.out.println(" Graph Density:\tAlgorithm Runtime in Nanoseconds:");
    			
         
            // Generating graphs that have vertices ranging from [500,1000]
    		for (int i = MIN; i <= MAX; i++) {
    			graph = new RandomAdjMatrixGraph(5000, i);
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
			System.out.println("\nDijkstra Part 2 Terminating\n");
		} catch (IOException e) {
            e.printStackTrace();
        }
		
	} // End of Main

} // End of Class
