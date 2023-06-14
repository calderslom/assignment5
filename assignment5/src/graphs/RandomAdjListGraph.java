package graphs;


/**
 * Generates a random graph using the adjacency list implementation
 *
 * @author Jalal Kawash
 * 
 */

import java.util.Random;
import java.util.ListIterator;

public class RandomAdjListGraph extends AdjListGraph
{   
    private int numEdges = 0;
    
    /**
     * Constructor for objects of class RandomAdjListGraph
     * 
     * @precond: density is between 0 and 10. A more dense graph will have more edges
     * 
     */
    public RandomAdjListGraph(int size, int density)
    {
        super(size);
        Random rnd = new Random();
        if (density <= 0) return;
        if (density >= 11) density = 10;
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) 
            {
                for (int k = 0; k < density; k++) // for higher densities more edges betwen i and j may be added
                {
                    if (rnd.nextInt(size)%(size*3) == 3)
                    {
                        this.addNode(new Vertex(j), rnd.nextFloat(size), i, j);
                        numEdges++;
                    }
                }
            }         
    }
    
    public int getNumEdges()
    {
        return numEdges;
    }
    
}
