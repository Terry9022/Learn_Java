package project5;

import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Helper class for the driver program. 
 * Tests the design of Graph.
 * @author Chi Ting Lu
 * @version 1.0
 */

public class Helper {
	/**
	 * Tests the Graph.
	 * @throws FileNotFoundException if there is no such file
	 */
	public static void start() throws FileNotFoundException{
		
		// Create an graph with 10 vertices without any edges and save its reference. 
		Graph graph = new Graph(10);
		// Pass the reference to create method.
		create(graph);		
		
		// Pass the reference to display method.
		System.out.println("We create a graph with 10 vertices here. After inserting 20 edges from test data:");
		System.out.println("The number of vertices: "+ graph.retrieveNumVertices());
		System.out.println("The number of edges: "+ graph.retrieveNumEdges());
		display(graph);
		System.out.println("---------------------------------------------");
		
		//	Find one edge, then edit the edge and display the graph again. 
		//  Delete that edge and check whether the number of edges changes accordingly.
		System.out.println("Find the edge from vertex 0 to 2:");
		Edge edge = graph.findEdge(0, 2);
		System.out.println("The weight of edge from vertex 0 to 2: " + edge.weight);
		System.out.println("Edit the weight(100) of edge from vertex 0 to 2:");
		graph.editEdgeWeight(0, 2, 100);
		display(graph);
		System.out.println("Delete the edge from vertex 0 to 2:");
		graph.removeEdge(new Edge(0,2,100));
		System.out.println("After deleting, the number of edges: "+ graph.retrieveNumEdges());
		display(graph);
		System.out.println("---------------------------------------------");
		
		// Test Graph Iterator using BFS search order
		// We use vertex 0 as the starting vertex of BFS
		GraphIterator iterator = new GraphIterator(graph);
		iterator.BFSsearch(0);
		 System.out.println("Breadth First Search order:");
		  while(iterator.hasNext()){
			  System.out.print(iterator.next() + " ");
		  }
		  System.out.println();
	}
	
	/**
	 * Creates the graph and read the test data to insert the edges into the Graph. 
	 * @param graoh A reference to the Graph.
	 * @throws FileNotFoundException if there is no such file
	 */
	private static void create(Graph graph) throws FileNotFoundException{
		
		Scanner input = new Scanner(new File("testdata.txt")).useDelimiter("\n");;
		
		input.next();  // skip row header
		while(input.hasNext()){
			String[] arr = input.next().split("\t");
			// Make Edge objects from the testing data in the file
			Edge edge = new Edge(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]),Integer.parseInt(arr[2]));
			// Insert the edges into the Graph
			graph.addEdge(edge);
	    }
		input.close();
	}
	
	/**
	 * Display the Graph
	 * @param graph A reference to a Graph
	 */
	private static void display(Graph graph){
		// Displays vertex and edge in the graph
		// Use the toString method in the graph class to print every vertex and edge in the graph
		System.out.print(graph);
	}
}
