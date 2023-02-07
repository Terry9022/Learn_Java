package project5;

/**
 * Represents a node class contains a vertex and a weight, and it represents a node of adjacency list
 * @author Chi Ting Lu
 * @version 1.0
 */

public class Node {
	
	/**
	 * The vertex of the node, which represents destination vertex in an adjacency list
	 */
	public Integer vertex;

	/**
	 * The weight number of the node, which represents weight of edge in an adjacency list
	 */
	public int weight;

	/**
	 * Constructs a node class.
	 * @param vertex The vertex of the node of adjacency list
	 * @param weight The weight number of the node of adjacency list
	 */
	public Node(Integer vertex, int weight){
		this.vertex = vertex;
		this.weight = weight;
	}

}
