package graphs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This is the main application for Assignment 5.
 * <p>
 * It executes multiple programs that correspond to each part of the assignment.
 * 
 * @author Calder Sloman
 * @author Rezwan Ahmed
 *
 */
public class MainApp {
	
	public static void main(String[] args) {
		
		new DijkstraPart1App();
		DijkstraPart1App.main(args);
		
		new FloydAlgorithm();
		try {
			FloydAlgorithm.main(args);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		new DijkstraPart2App();
		DijkstraPart2App.main(args);
		
		new FloydAlgorithmP2();
		
		try {
			FloydAlgorithmP2.main(args);
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
	} // End of Main

} // End of Class
