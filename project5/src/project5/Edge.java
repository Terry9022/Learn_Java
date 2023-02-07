package project5;

/**
 * Represents an edge class contains two vertices and a weight, and it represents an edge in the Graph
 * @author Chi Ting Lu
 * @version 1.0
 */

public class Edge {
	
	/**
	 * The source vertex of the edge
	 */
	public Integer srcVertex;
	
	/**
	 * The destination vertex of the edge
	 */
	public Integer destVertex;
	
	/**
	 * The weight number of the edge
	 */
	public int weight;

	/**
	 * Constructs an edge class.
	 * @param srcVertex The source vertex of the edge 
	 * @param destVertex The destination vertex of the edge 
	 * @param weight The weight number of the edge between these two vertices
	 */
	public Edge(Integer srcVertex, Integer destVertex, int weight){
		this.srcVertex = srcVertex;
		this.destVertex = destVertex;
		this.weight = weight;
	}


}
