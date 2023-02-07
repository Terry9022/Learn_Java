package project4;

/**
 * Represents a binary search tree with additional operations:
	 * Search an element in this tree.
	 * Insert an element into this tree.
	 * Delete an element from this tree.
	 * Construct an iterator of this tree.
	 * Get a reference to the element of a node.
 * @author Chi Ting Lu
 * @version 1.0
 */

public class BinarySearchTree<E extends Comparable<E>> extends BaseBinaryTree<E> {

	  /**
	   * Creates an empty binary search tree.
	   */
	  public BinarySearchTree() {
		  super();  
	  }

	  /**
	   * Creates a one node binary search tree.
	   * @param rootItem The root of this tree
	   */
	  public BinarySearchTree(E rootItem) {
		  super(rootItem);
	  }

	 /**
	 * Replaces the data item in the root of a binary tree with new item, if the tree is not empty. If the
	 * tree is empty, creates a root node whose data item is newItem and inserts the new node into the tree.
	 * @param newItem A reference to a new root item
	 */
	  public void setRoot(E newItem) {
	    if (this.root != null) {
	       this.root.setElement(newItem);
	    }else {
	       this.root = new TreeNode<E>(newItem, null, null);
	    }
	  }
	  
	  /**
		 * Search an element in this binary search tree.
		 * @param item A item we want to search
		 * @return A value specifying if the binary search tree has this item or not
		 */
	  public boolean search(E item) {
		  boolean find = false;
		  TreeNode<E> current = this.root;
		  while(!find && current != null) {
			  int compare = item.compareTo(current.getElement());
			  if (compare == 0) {
	                find = true;
	            } else if (compare < 0) {
	                current = current.getLeft();
	            } else {
	                current = current.getRight();
	            }
		  }
		  return find;
	  }
	  
	  /**
		 * Insert an element into this binary search tree.
		 * @param item A reference to a new item
		 */
	  public void insert(E item) {
		 this.root = insert(this.root,item);
	  }
	  
	  /**
		 * Insert an element into this binary search tree.
		 * @param item A reference to a new item
		 * @param root A TreeNode which is the tree node we start to compare
		 * @return A TreeNode which is the new tree node we added to the tree
		 */
	  private TreeNode<E> insert(TreeNode<E> root, E item) {
		 if(root == null) {
			 return new TreeNode<E>(item);
		 }else if (item.compareTo(root.getElement())<0) { 
			 root.setLeft(insert(root.getLeft(), item)); 
		 }else if(item.compareTo(root.getElement()) > 0) {
			 root.setRight(insert(root.getRight(),item));
		 }else { 
			 ; // should not get here
		 }
				 
		 return root;
	  }
	  
	  
	  /**
		 * Get a reference to the element of a node.
		 * @param item A reference to the item we want to retrieve
		 * @return  A TreeNode which is the reference to the tree node we want to get
		 */
	  public TreeNode<E> retrieve(E item) {
		  boolean find = false;
		  TreeNode<E> current = this.root;
		  while(!find && current != null) {
			  int compare = item.compareTo(current.getElement());
			  if (compare == 0) {
	                find = true;
	            } else if (compare < 0) {
	                current = current.getLeft();
	            } else {
	                current = current.getRight();
	            }
		  }
		  if(find) {
			  return current;
		  }
		  else {
			  return null;
		  }
	  }
	  
	   
	  /**
		 * Delete an element from this binary search tree, if it exists.
		 * If the value is not contained in the tree, no change is made
		 * @param item A reference to an item we want to delete from the tree
		 * @throws TreeException if the tree is empty
		 */
	    public void delete(E item) throws TreeException {
	    	if(isEmpty()) {
	    		throw new TreeException("TreeException: Empty tree");
	    	}
	        this.root = delete(this.root, item);
	    }
	  
	    /**
		 * Delete an element from this binary search tree, if it exists.
		 * If the value is not contained in the tree, no change is made
		 * @param item A reference to an item we want to delete from the tree
		 * @param root A TreeNode which is the tree node we start to compare
		 * @return A TreeNode which is the tree node we are going to replace when deleting
		 */
	  private TreeNode<E> delete(TreeNode<E> root, E item) {
		  if(root==null) {
			  return null;
		  }
		  if(item.compareTo(root.getElement()) < 0) {
			  root.setLeft(delete(root.getLeft(),item));
		  }else if(item.compareTo(root.getElement()) > 0) {
			  root.setRight(delete(root.getRight(),item));
		  }else {
			  if(root.getLeft()==null && root.getRight()==null) { 
				  // N is a leaf
				  return null;
			  }
			  if(root.getLeft()!=null && root.getRight()==null) { 
				  // N has only one child, left child
				  return root.getLeft();
			  }else if(root.getLeft()==null && root.getRight()!=null) { 
				  // N has only one child, right child
				  return root.getRight();
			  }else {  
				  // N has two children
				  root.setElement(getMin(root.getRight()));
				  root.setRight(delete(root.getRight(),root.getElement()));
			  }
		  }
		  return root;
		  
	  }
	  
	  /**
		 * Recursive helper to search a subtree and return the minimum (leftmost) value.
		 * @param root A TreeNode which we are going to search for a minimum (leftmost) value.
		 * @return A value specifying the minimum value in this subtree
		 */
	    private E getMin(TreeNode<E> root) {
	        if (root.getLeft() == null) {
	            return root.getElement();
	        } else {
	            return getMin(root.getLeft());
	        }
	    }
	  
	  
	  /**
		 * Construct an iterator of this binary search tree in pre-order traversal.
		 * @return A TreeIterator of this binary search tree in pre-order traversal.
		 */
	  public TreeIterator<E> preorderTraversal() {
		  TreeIterator<E> iterator = new TreeIterator<E>(this);
		  iterator.setPreorder();
		
		  return iterator;
	  }
	  
	  /**
		 * Construct an iterator of this binary search tree in in-order traversal.
		 * @return A TreeIterator of this binary search tree in in-order traversal.
		 */
	  public TreeIterator<E> inorderTraversal() {
		  TreeIterator<E> iterator = new TreeIterator<E>(this);
		  iterator.setInorder();
		
		  return iterator;
	  }
	  
	  /**
		 * Construct an iterator of this binary search tree in post-order traversal.
		 * @return A TreeIterator of this binary search tree in post-order traversal.
		 */
	  public TreeIterator<E> postorderTraversal() {
		  TreeIterator<E> iterator = new TreeIterator<E>(this);
		  iterator.setPostorder();
		
		  return iterator;
	  }
	  
	  
		  
}
