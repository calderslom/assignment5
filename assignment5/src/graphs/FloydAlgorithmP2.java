// CPSC 331
// Assignment 5
// Rezwan Ahmed, UCID:30134609
// Calder Sloman,UCID:30107102



package graphs;

import java.io.FileWriter;
import java.io.IOException;

public class FloydAlgorithmP2 {

	public static void main (String[] args) throws IOException{
		
		
		int size = 5000; 														// The number of vertices in the random graph
		long[] time_array1 = new long[9]; 										// array to store execution times
		FileWriter floyd_writer2 = new FileWriter("floyd2.txt"); 				// FileWriter to write output to a file named "floyd.txt"

		for (int i = 1; i <= 9; i++) { 											// Iterate over a range of values for i where i represents the density of the graph
		    RandomAdjMatrixGraph graph = new RandomAdjMatrixGraph(size, i); 	// Create a random graph with i density and the given size

		    long start = System.nanoTime(); 									// Record the start time
		    float[][] shortestPaths = FloydAlgorithm.floyd(graph); 				// Compute the shortest paths using the Floyd's algorithm
		    long end = System.nanoTime(); 										// Record the end time
		    long time = end - start; 											// Calculate the execution time
		    time_array1[i-1] = time; 											// Store the execution time in the array 
		}

		for (int i = 0; i < time_array1.length; i++) { 							// Iterate over the time_array
		    String the_time = Long.toString(time_array1[i]);					// Convert the execution time to a string
		    floyd_writer2.write(the_time + "\n"); 								// Write the execution time to the file followed by a newline character
		}
		floyd_writer2.close(); 													// Close the FileWriter
		System.out.println("Output written to file successfully."); 			// Print a success message to the console

	  	
		
	}

}
