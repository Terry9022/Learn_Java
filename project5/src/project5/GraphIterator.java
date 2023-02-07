package project5;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;


/**
 * An iterator over a graph
 * @author Chi Ting Lu
 * @version 1.0
 */

public class GraphIterator implements java.util.Iterator<Integer>{
	
	  /**
	   * The collection traversed by this iterator
	   */
	  private Graph graph;
	 
	  /**
	   * An ordered list of nodes traversed by this iterator. 
	   * Empty list indicates no traversal type currently selected or 
	   * end of current traversal has been reached
	   */
	  private LinkedList<Integer> list;

	  /**
	   * Constructs an iterator over a graph. 
	   * @param graph A reference to a graph
	   */
	  public GraphIterator(Graph graph) {
		  this.graph = graph;
		  this.list = new LinkedList<Integer>();
	  }

	  /**
	   * Returns true if the iteration has more elements. 
	   * @return A boolean value specifying if there is an element to be returned
	   */
	  public boolean hasNext() {
	     return !this.list.isEmpty();
	  }

	  /**
	   * Returns the next element in the iteration.
	   * @return the next element in the iteration
	   * @throws NoSuchElementException if the iteration has no more elements
	   */
	  public Integer next() throws java.util.NoSuchElementException {
		  if (hasNext())
			  return this.list.remove();
	      throw new NoSuchElementException();
	  }

	  /**
	   * Removes from the underlying graph the last element returned by this iterator (optional operation). 
	   * @throws UnsupportedOperationException if the remove operation is not supported by this iterator
	   */
	  public void remove() throws UnsupportedOperationException{
	      throw new UnsupportedOperationException();
	  }
	  
	  /**
	   * Sets the traversal type to be Breadth First Search order.
	   * @param rootVertex A reference to a rootVertex as the starting vertex of BFS
	   */
	  public void BFSsearch(Integer rootVertex) {
		  
		this.list.clear();
	    final int WHITE = 0, GARY = 1, BLACK = 2;
	    int[] color = new int[graph.retrieveNumVertices()];
	    Deque<Integer> queue = new ArrayDeque<>();
	    queue.offer(rootVertex);
	    
	    while(!queue.isEmpty()) {
	    	Integer currVertex =queue.poll();
	    	if(color[currVertex] == WHITE) {
	    		color[currVertex] = GARY;
	    		list.add(currVertex);
	    		
	    		for(Node node: graph.getAdjlist().get(currVertex)) {
	    			queue.offer(node.vertex);
	    		}
	    		color[currVertex] = BLACK;
	    	}
	    }
	  }
	  
}
