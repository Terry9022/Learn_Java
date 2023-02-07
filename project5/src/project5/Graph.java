package project5;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementations of operations of a Graph. 
 * @author Chi Ting Lu
 * @version 1.0 
 */

public class Graph implements GraphInterface {
	
	
	  /**
	   * The adjacency list represents this graph
	   */
	  private List<List<Node>> adjList;
	  
	  /**
	   * The number of vertices in this graph
	   */
	  private int numVertices;
	  
	  /**
	   * The number of edges in this graph
	   */
	  private int numEdges;
	  
	  /**
	   * Constructs a Graph with a adjacency list and the number of vertices and edges
	   */
	  public Graph(int numVertices) {
		  this.numVertices = numVertices;
		  this.numEdges = 0;
		  adjList = new ArrayList<>(numVertices);
		  for (int i = 0; i < numVertices; i++) {
			  adjList.add(new ArrayList<>());
		  }
	  }
	
	  /**
	   * Retrieve the number of vertices.
	   * @return the number of vertices of the graph
	   */
	  public int retrieveNumVertices() {
		  return numVertices;
	  }
	  
	  /**
	   * Retrieve the number of edges.
	   * @return the number of edges of the graph
	   */
	  public int retrieveNumEdges() {
		  return numEdges;
	  }
	  
	  /**
	   * Retrieve the adjacency list of this graph
	   * @return the adjacency list represents this graph
	   */
	  public List<List<Node>> getAdjlist() {
		  return adjList;
	  }
	  
	  /**
	   * Determine and edit the edge weight between two given vertices.
	   * @param srcVertex The source vertex of the edge we want to edit
	   * @param destVertex The destination vertex of the edge we want to edit
	   * @param weight The weight number we want to edit and update to the edge between these two vertices
	   * @throws GraphException if any vertex is not in the graph
	   */
	  public void editEdgeWeight(Integer srcVertex, Integer destVertex, int weight ) throws GraphException{
		  
		  if(srcVertex > numVertices || destVertex > numVertices) {
			  throw new GraphException("It cannot edit the edge because there is no such vertex in the graph");
		  }
		  List<Node> srcVertexAdjlist = adjList.get(srcVertex);
		  for(int i = 0;i < srcVertexAdjlist.size();i++) {
			  Node currNode = srcVertexAdjlist.get(i);
			  if (currNode.vertex == destVertex) {
				  currNode.weight = weight;
			  }
		  }
		  
		  List<Node> destVertexAdjlist = adjList.get(destVertex);
		  for(int i = 0;i < destVertexAdjlist.size();i++) {
			  Node currNode = destVertexAdjlist.get(i);
			  if (currNode.vertex == srcVertex) {
				  currNode.weight = weight;
			  }
		  }
		  
	  }
	  
	  /**
	   * Add an edge given two vertices and a weight.
	   * @param srcVertex The source vertex of the edge we want to add
	   * @param destVertex The destination vertex of the edge we want to add
	   * @param weight The weight number of the edge we want to add
	   */
	  public void addEdge(Integer srcVertex, Integer destVertex, int weight) {
		  adjList.get(srcVertex).add(new Node(destVertex, weight));
		  adjList.get(destVertex).add(new Node(srcVertex, weight));
		  numEdges++;
	  }
	  
	  /**
	   * Add an edge given an edge.
	   * @param edge The edge we want to add to the graph
	   */
	  public void addEdge(Edge edge) {
		  adjList.get(edge.srcVertex).add(new Node(edge.destVertex, edge.weight));
		  adjList.get(edge.destVertex).add(new Node(edge.srcVertex, edge.weight));
		  numEdges++;
	  }
	  
	  /**
	   * Remove a given edge from this graph.
	   * @param edge The edge we want to remove from the graph
	   * @throws GraphException if there is no such edge in the graph
	   */
	  public void removeEdge(Edge edge) throws GraphException{
		  
		  int indexRemove = -1;
		  List<Node> srcVertexAdjlist = adjList.get(edge.srcVertex);
		  for(int i = 0;i < srcVertexAdjlist.size();i++) {
			  Node currNode = srcVertexAdjlist.get(i);
			  if (currNode.vertex == edge.destVertex &&  currNode.weight == edge.weight) {
				  indexRemove = i ;
			  }
		  }
		  if(indexRemove == -1) {
			  throw new GraphException("It cannot remove the edge because there is no such edge in the graph");
		  }
		  srcVertexAdjlist.remove(indexRemove);
		  indexRemove = -1;
		  
		  List<Node> destVertexAdjlist = adjList.get(edge.destVertex);
		  for(int i = 0;i < destVertexAdjlist.size();i++) {
			  Node currNode = destVertexAdjlist.get(i);
			  if (currNode.vertex == edge.srcVertex &&  currNode.weight == edge.weight) {
				  indexRemove = i ;
			  }
		  }
		  if(indexRemove == -1) {
			  throw new GraphException("It cannot remove the edge because there is no such edge in the graph");
		  }
		  destVertexAdjlist.remove(indexRemove);
		  
		  numEdges--;
		  
	  }
	  
	  /**
	   * Find the edge between two given vertices.
	   * @param srcVertex The source vertex of the edge we want to find
	   * @param destVertex The destination vertex of the edge we want to find
	   * @return the edge in this graph between two given vertices, and if there is no such edge, it returns null
	   */
	  public Edge findEdge(Integer srcVertex, Integer destVertex) {
		  
		  Edge edge = null;
		  List<Node> srcVertexAdjlist = adjList.get(srcVertex);
		  for(int i = 0;i < srcVertexAdjlist.size();i++) {
			  Node currNode = srcVertexAdjlist.get(i);
			  if (currNode.vertex == destVertex) {
				  int weight = currNode.weight;
				  edge = new Edge(srcVertex, destVertex, weight );
			  }
		  }
		  return edge;
	  }
	  
	  /**
	   * Compare this graph with some other object.
	   * @param o The object we want to compare with
	   * @throws GraphException if that object is not the graph type
	   * @return an integer specifies whether the object o is bigger than the graph or not
	   */
	  public int compareTo(Object o) throws GraphException{
		  if(!(o instanceof Graph)){
			  throw new GraphException("It cannot compare with the object.");
		  }else {
			  Graph otherGraph = (Graph) o;
			  if(this.numVertices > otherGraph.numVertices) {
				  return 1;
			  }else if(this.numVertices < otherGraph.numVertices) {
				  return -1;
			  }else {
				  return 0;
			  }
		  }
	  }
	  
	  /**
	   * Represent this graph as a string.
	   * @return the string which represents this graph
	   */
	  public String toString() {
		  
		  String string = "";
		  int srcVertex = 0;
		  string += "The contents of this Graph: \n";
		  while(srcVertex < this.numVertices) {
			  string+="Vertex"+  srcVertex + ":   ";
			  for (Node node: this.adjList.get(srcVertex)) {
				  string += ("Edge:" + srcVertex + " --> " + node.vertex +  " (" + node.weight + ")\t");
			  }
			  string+="\n";
			  srcVertex++;
		  }
		  return string;
	  }
	  
	 
}
