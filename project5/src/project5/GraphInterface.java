package project5;

/**
 * Specifications on the design of operations of a Graph. 
 * @author Chi Ting Lu
 * @version 1.0 
 */

public interface GraphInterface {
	
	  /**
	   * Retrieve the number of vertices.
	   * @return the number of vertices of the graph
	   */
	  public int retrieveNumVertices();
	  
	  /**
	   * Retrieve the number of edges.
	   * @return the number of edges of the graph
	   */
	  public int retrieveNumEdges();
	  
	  /**
	   * Determine and edit the edge weight between two given vertices.
	   * @param srcVertex The source vertex of the edge we want to edit
	   * @param destVertex The destination vertex of the edge we want to edit
	   * @param weight The weight number we want to edit and update to the edge between these two vertices
	   * @throws GraphException if any vertex is not in the graph
	   */
	  public void editEdgeWeight(Integer srcVertex, Integer destVertex, int weight ) throws GraphException;
	  
	  /**
	   * Add an edge given two vertices and a weight.
	   * @param srcVertex The source vertex of the edge we want to add
	   * @param destVertex The destination vertex of the edge we want to add
	   * @param weight The weight number of the edge we want to add
	   */
	  public void addEdge(Integer srcVertex, Integer destVertex, int weight);
	  
	  /**
	   * Add an edge given an edge.
	   * @param edge The edge we want to add to the graph
	   */
	  public void addEdge(Edge edge);
	  
	  /**
	   * Remove a given edge from this graph.
	   * @param edge The edge we want to remove from the graph
	   * @throws GraphException if there is no such edge in the graph
	   */
	  public void removeEdge(Edge edge) throws GraphException;
	  
	  /**
	   * Find the edge between two given vertices.
	   * @param srcVertex The source vertex of the edge we want to find
	   * @param destVertex The destination vertex of the edge we want to find
	   * @return the edge in this graph between two given vertices, and if there is no such edge, it returns null
	   */
	  public Edge findEdge(Integer srcVertex, Integer destVertex);
	  
	  /**
	   * Compare this graph with some other object.
	   * @param o The object we want to compare with
	   * @throws GraphException if that object is not the graph type
	   * @return an integer specifies whether the object o is bigger than the graph or not
	   */
	  public int compareTo(Object o) throws GraphException;
	  
	  /**
	   * Represent this graph as a string.
	   * @return the string which represents this graph
	   */
	  public String toString();
	  
	 

}
