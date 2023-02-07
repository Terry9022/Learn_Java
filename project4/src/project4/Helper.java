package project4;

/**
 * Tests the design of binary search tree. 
 * @author Chi Ting Lu
 * @version 1.0
 */

public class Helper {
	/**
	 * Tests the binary search tree. 
	 * Builds a sample binary search tree. 
	 * 
	 * 	   20
	 *    /  \
	 *  10    40
	 *       /  \    
	 * 	   30    50
	 * 
	 * @param args A reference to an command-line arguments
	 */
	public static void start() {
		 
		 BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		 
		//Fill the tree.
		 create(tree);
		 
		 //Display the tree.
		 display(tree);
		 
		}
	/**
	 * Creates a BinarySearchTree.
	 * @param tree A reference to a BinarySearchTree
	 */
	private static void create(BinarySearchTree<Integer> tree){
		 
		 tree.insert(20);
		 tree.insert(40);
		 tree.insert(10);
		 tree.insert(50);
		 tree.insert(30);
	}
	
	/**
	 * Display the BinarySearchTree and test methods of BinarySearchTree.
	 * @param tree A reference to a BinarySearchTree
	 */
	private static void display(BinarySearchTree<Integer> tree){
		
		 System.out.println("The tree is empty or not : "+tree.isEmpty());
			
		 TreeIterator<Integer> iterator = tree.inorderTraversal();
		  System.out.println("Inorder traversal");
		  while(iterator.hasNext()){
			  System.out.print(iterator.next() + " ");
		  }
		  System.out.println();
		 
		  
		  System.out.println("The tree has 20 or not : "+tree.search(20));
		  System.out.println("The tree has 44 or not : "+tree.search(44));
		  System.out.println("The tree has 30 or not : "+tree.search(30));
		  tree.delete(20);
		  System.out.println("After deleting 20, the tree has 20 or not : "+tree.search(20));
		  System.out.println("After deleting 20, the tree has 30 or not : "+tree.search(30));
		  
		  iterator = tree.inorderTraversal();
		  System.out.println("Inorder traversal");
		  while(iterator.hasNext()){
			  System.out.print(iterator.next() + " ");
		  }
		  System.out.println();
		  
		  tree.delete(30);
		  tree.delete(10);
		  tree.delete(40);
		  tree.delete(50);
		  System.out.println("After deleting everything, the tree is empty or not : "+tree.isEmpty());
		  
	}
	
}