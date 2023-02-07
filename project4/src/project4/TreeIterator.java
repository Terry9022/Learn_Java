package project4;

import java.util.LinkedList;
/**
 * An iterator over a binary search tree.
 * @author Chi Ting Lu
 * @version 1.0
 */

public class TreeIterator<T> implements java.util.Iterator<T> {
	
	  /**
	   * The collection traversed by this iterator
	   */
	  private BaseBinaryTree<T> tree;
	 
	  /**
	   * An ordered list of nodes traversed by this iterator. 
	   * Empty list indicates no traversal type currently selected or 
	   * end of current traversal has been reached
	   */
	  private LinkedList <TreeNode<T>> list;

	  /**
	   * Constructs an iterator over a binary tree. 
	   * @param tree A reference to a binary tree
	   */
	  public TreeIterator(BaseBinaryTree<T> tree) {
		  this.tree = tree;
		  this.list = new LinkedList<TreeNode<T>>();
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
	  public T next() throws java.util.NoSuchElementException {
	      return this.list.remove().getElement();
	  }

	  /**
	   * Removes from the underlying binary tree the last element returned by this iterator (optional operation). 
	   * @throws UnsupportedOperationException if the remove operation is not supported by this iterator
	   * @throws IllegalStateException if the next method has not yet been called, or the remove method has already been 
	   *                               called after the last call to the next method
	   */
	  public void remove() throws UnsupportedOperationException{

	      throw new UnsupportedOperationException();
	  }

	  /**
	   * Sets the traversal type to be preorder.
	   */
	  public void setPreorder() {
		  this.list.clear();
	      this.preorder(this.tree.root);
	  }

	  /**
	   * Sets the traversal type to be inorder.
	   */
	  public void setInorder() {
		  this.list.clear();
	      this.inorder(this.tree.root);
	  }

	  /**
	   * Sets the traversal type to be postorder.
	   */
	  public void setPostorder() {
		  this.list.clear();
	      this.postorder(this.tree.root);
	  }

	  /**
	   * Traverses in preorder. 
	   * @param treeNode A reference to a tree node
	   */
	  private void preorder(TreeNode<T> treeNode) {
	    if(treeNode != null){
	    	this.list.add(treeNode);
	    	preorder(treeNode.getLeft());
	    	preorder(treeNode.getRight());
	    	
	    }
	  }

	  /**
	   * Traverses in inorder. 
	   * @param treeNode A reference to a tree node
	   */
	  private void inorder(TreeNode<T> treeNode) {
		  if(treeNode != null){
		    	inorder(treeNode.getLeft());
		    	this.list.add(treeNode);
		    	inorder(treeNode.getRight());
		    	
		    }
	  }

	  /**
	   * Traverses in postorder. 
	   * @param treeNode A reference to a tree node
	   */
	  private void postorder(TreeNode<T> treeNode) {
		  if(treeNode != null){
			    postorder(treeNode.getLeft());
		    	postorder(treeNode.getRight());
		    	this.list.add(treeNode);
		    	
		    }
	  } 
	} 