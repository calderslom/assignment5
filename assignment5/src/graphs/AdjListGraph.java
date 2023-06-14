package graphs;


/**
 * Implements a graph using an adjacency list
 * The graph is directed and weighed
 *
 * @author Jalal Kawash
 * 
 */

import java.util.Stack;
import java.util.LinkedList;
import java.util.ListIterator;

public class AdjListGraph<T>
{
    LinkedList<Node>[] adjList;
    int size;

    /**
     * Constructor for objects of class AdjListGraph
     */
    public AdjListGraph(int size)
    {
        adjList = new LinkedList[size];
        for (int i = 0; i < size; i++) adjList[i] = new LinkedList<Node>();
        this.size = size;
    }
    
    /**
     * Add a new node to the graph
     */
    public void addNode(Vertex v, float edgeWeight, int i, int j)
    {
        adjList[i].add(new Node(v,edgeWeight));
    }
    
    /**
     * Return a node
     */
    public Node getNode(int i, int j)
    {
        ListIterator<Node> list = adjList[i].listIterator(0);
        while (list.hasNext()) {
            Node n = list.next();
            if (n.getVertex().getId() == j) return n;
        }
        return null;
    }

    /**
     * returns a queue of DFS walk of vertices from startVertex
     */
    public LinkedQueue oneSourceDFS(int startVertex)
    {
        Stack<Integer> s = new Stack();
        LinkedQueue<Integer> w = new LinkedQueue();
        boolean[] visited = new boolean[size];
        for (int i = 0; i < size; i++) visited[i] = false;
        s.push(startVertex);
        visited[startVertex] = true;
        
        while (!s.isEmpty())
        {
            int currentVertex = s.pop();
            w.enqueue(currentVertex);
            
            ListIterator<Node> list = adjList[currentVertex].listIterator(0);
            while(list.hasNext())
            {
                Node n = list.next();
                int i = n.getVertex().getId();
                if (!visited[i] && n.getVertex().getId() == i) 
                {
                    s.push(i);
                    visited[i] = true;
                }
            }
        }
        return w;
    }
    
    /**
     * returns a queue of BFS walk of vertices from startVertex
     */
    public LinkedQueue oneSourceBFS(int startVertex)
    {
        LinkedQueue<Integer> q = new LinkedQueue();
        LinkedQueue<Integer> w = new LinkedQueue();
        boolean[] visited = new boolean[size];
        for (int i = 0; i < size; i++) visited[i] = false;
        q.enqueue(startVertex);
        visited[startVertex] = true;
        
        while (!q.isEmpty())
        {
            int currentVertex = q.dequeue();
            w.enqueue(currentVertex);
            
            ListIterator<Node> list = adjList[currentVertex].listIterator(0);
            while(list.hasNext())
            {
                Node n = list.next();
                int i = n.getVertex().getId();
                if (!visited[i] && n.getVertex().getId() == i) 
                {
                    q.enqueue(i);
                    visited[i] = true;
                }
            }
        }
        return w;
    }
    
    /**
     * returns a 2D array representing the reachability of vertices from each other
     */
    public boolean[][] getReachMatrix()
    {
        boolean[][] reachMatrix = new boolean[size][size];
        
        LinkedQueue<Integer>[] allQs = new LinkedQueue[size];
        for (int i = 0; i < size; i++) 
        {   
            allQs[i] = new LinkedQueue<Integer>();
            allQs[i] = oneSourceDFS(i);

            for (int j = 0; j < size; j++) {
                if (i == j) reachMatrix[i][j] = true;
                else reachMatrix[i][j] = false;
            }
        }
        
        for (int i = 0; i < size; i++)
        {
            while (!allQs[i].isEmpty()) 
            {
                int k = (Integer) allQs[i].dequeue();
                reachMatrix[i][k] = true;
            }
        }
        
        return reachMatrix;
    }
    
    public boolean isStronglyConnected() 
    {
        boolean[][] rm = getReachMatrix();
        int[] reachableCount = new int[size];
        for (int i = 0; i < size; i++) 
            reachableCount[i]= 0;
        
        for (int i = 0; i < size; i++) 
            for(int j = 0; j < size; j++) 
                if (rm[i][j]) reachableCount[i]++;
                
        for (int i = 0; i < size; i++) 
            if (reachableCount[i] != size) return false;
        
            return true;
    }
    
    public void printGraph()
    {
        System.out.println("Graph Adjacency List");
        for (int i = 0; i < size; i++) 
        {
            System.out.printf("[%d]", i);
            ListIterator<Node> list = adjList[i].listIterator(0);
            while (list.hasNext())
            {
                Node n = list.next();
                System.out.printf("(%d,%.2f) ", n.getVertex().getId(), n.getWeight());
            }
             System.out.println();
        }   
    
    }
}
