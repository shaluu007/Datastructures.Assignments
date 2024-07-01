package DataStructures.Tree;
class TreeNode {
 int key;
 TreeNode left, right;

 public TreeNode(int item) {
     key = item;
     left = right = null;
 }
}
class BinarySearchTree {
 private TreeNode root;

 public BinarySearchTree() {
     root = null;
 }

 public void insert(int key) {
     root = insertRec(root, key);
 }

 private TreeNode insertRec(TreeNode root, int key) {
     if (root == null) {
         root = new TreeNode(key);
         return root;
     }

     if (key < root.key)
         root.left = insertRec(root.left, key);
     else if (key > root.key)
         root.right = insertRec(root.right, key);

     return root;
 }

 public void inorderTraversal() {
     inorderTraversalRec(root);
 }

 private void inorderTraversalRec(TreeNode root) {
     if (root != null) {
         inorderTraversalRec(root.left);
         System.out.print(root.key + " ");
         inorderTraversalRec(root.right);
     }
 }

 public void preorderTraversal() {
     preorderTraversalRec(root);
 }
 private void preorderTraversalRec(TreeNode root) {
     if (root != null) {
         System.out.print(root.key + " ");
         preorderTraversalRec(root.left);
         preorderTraversalRec(root.right);
     }
 }
 public void postorderTraversal() {
     postorderTraversalRec(root);
 }

 private void postorderTraversalRec(TreeNode root) {
     if (root != null) {
         postorderTraversalRec(root.left);
         postorderTraversalRec(root.right);
         System.out.print(root.key + " ");
     }
 }
 public void delete(int key) {
     root = deleteRec(root, key);
 }

 private TreeNode deleteRec(TreeNode root, int key) {
     if (root == null) return root;
     if (key < root.key)
         root.left = deleteRec(root.left, key);
     else if (key > root.key)
         root.right = deleteRec(root.right, key);
     else {
         if (root.left == null)
             return root.right;
         else if (root.right == null)
             return root.left;
         root.key = minValue(root.right);
         root.right = deleteRec(root.right, root.key);
     }

     return root;
 }
 private int minValue(TreeNode root) {
     int minv = root.key;
     while (root.left != null) {
         minv = root.left.key;
         root = root.left;
     }
     return minv;
 }
}
