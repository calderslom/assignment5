// CPSC 331
// Assignment 5
// Rezwan Ahmed, UCID:30134609
// Calder Sloman,UCID:30107102


package graphs;

import java.io.FileWriter;
import java.io.IOException;

public class FloydAlgorithm {
	public static float[][] floyd(AdjMatrixGraph graph) {
        int V = graph.size;													// storing size of graph in variable V
        float[][] D = new float[V][V];										// matrix called D which will store the shortest distances to reach vertices 


        // Copy adjacency matrix to D
        for (int i = 0; i < V; i++) {										// looping through adjacency matrix representation of the graph
            for (int j = 0; j < V; j++) {
            	Node node = graph.adjMatrix[i][j];
            	           	
            	
            	if((node != null)) {
            		
                	float weight = node.getWeight();						// if node is not null in the graph copy the weight into the D matrix in the same position
                	D[j][i] = weight;
                  											
                }
                else {	 
                	
                	
                	D[j][i] = Integer.MAX_VALUE;							// if node at j,i position in the graph is null assign infinity at that position in D matrix
            
                }
              
            }
        }
        

        // Initialize diagonal elements of D to 0
        for (int i = 0; i < V; i++) {
            D[i][i] = 0;
        }

        // Floyd's algorithm
        for (int k = 0; k < V; k++) {										// Iterate over all vertices as intermediate nodes
            for (int i = 0; i < V; i++) {									// Iterate over all source vertices
                for (int j = 0; j < V; j++) {								// Iterate over all destination vertices						
                    if (D[i][k] + D[k][j] < D[i][j]) {						// If the path through vertex k is shorter
                        D[i][j] =(D[i][k] + D[k][j]) ;
                        													// Update the shortest path distance
                    }
                }
            }
        }

        return D;															// Return the matrix containing the shortest path distances between all pairs of vertices
    }


public static void main(String[] args) throws IOException {
	

	int density = 5; 														// The density of the random graph
	long[] time_array = new long[500]; 										// array to store execution times
	FileWriter floyd_writer = new FileWriter("floyd.txt"); 					// FileWriter to write output to a file named "floyd.txt"

	for (int j = 500; j < 1000; j++) { 										// Iterate over a range of values for j where j represents the size of the graph
	    RandomAdjMatrixGraph graph = new RandomAdjMatrixGraph(j, density); 	// Create a random graph with j vertices and the given density

	    long start = System.nanoTime(); 									// Record the start time
	    float[][] shortestPaths = floyd(graph); 								// Compute the shortest paths using the Floyd's algorithm
	    long end = System.nanoTime(); 										// Record the end time
	    long time = end - start; 											// Calculate the execution time
	    time_array[j-500] = time; 											// Store the execution time in the array 
	}

	for (int i = 0; i < time_array.length; i++) { 							// Iterate over the time_array
	    String the_time = Long.toString(time_array[i]);						// Convert the execution time to a string
	    floyd_writer.write(the_time + "\n"); 								// Write the execution time to the file followed by a newline character
	}
	floyd_writer.close(); 													// Close the FileWriter
	System.out.println("Output written to file successfully."); 			// Print a success message to the console

  
	
	int size = 5000; 														// The number of vertices in the random graph
	long[] time_array1 = new long[10]; 										// array to store execution times
	FileWriter floyd_writer2 = new FileWriter("floyd2.txt"); 				// FileWriter to write output to a file named "floyd.txt"

	for (int i = 1; i < 10; i++) { 											// Iterate over a range of values for i where i represents the density of the graph
	    RandomAdjMatrixGraph graph = new RandomAdjMatrixGraph(size, i); 	// Create a random graph with i density and the given size

	    long start = System.nanoTime(); 									// Record the start time
	    float[][] shortestPaths = floyd(graph); 							// Compute the shortest paths using the Floyd's algorithm
	    long end = System.nanoTime(); 										// Record the end time
	    long time = end - start; 											// Calculate the execution time
	    time_array1[i-1] = time; 											// Store the execution time in the array 
	}

	for (int i = 0; i < time_array.length; i++) { 							// Iterate over the time_array
	    String the_time = Long.toString(time_array1[i]);					// Convert the execution time to a string
	    floyd_writer2.write(the_time + "\n"); 								// Write the execution time to the file followed by a newline character
	}
	floyd_writer2.close(); 													// Close the FileWriter
	System.out.println("Output written to file successfully."); 			// Print a success message to the console

  
	
	
}	

	
}
