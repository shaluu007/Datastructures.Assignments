package DataStructures.Tree;
public class Main {
	 public static void main(String[] args) {
	     BinarySearchTree bst = new BinarySearchTree();
	     bst.insert(90);
	     bst.insert(55);
	     bst.insert(20);
	     bst.insert(40);
	     bst.insert(13);
	     bst.insert(60);
	     bst.insert(84);
	     System.out.println("Inorder traversal:");
	     bst.inorderTraversal();
	     System.out.println();
	     System.out.println("Preorder traversal:");
	     bst.preorderTraversal();
	     System.out.println();
	     System.out.println("Postorder traversal:");
	     bst.postorderTraversal();
	     System.out.println();
	     System.out.println("Deleting 20 from BinarySearchTree:");
	     bst.delete(20);
	     System.out.println("Inorder traversal after deletion:");
	     bst.inorderTraversal();
	 }
	}
