package tree;
import java.util.*;

  public class TreeNode {
      public int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
      private static StringBuilder traversal = new StringBuilder();

 

        public static String preOrderBinaryTreeTraversal(TreeNode root) {
            traversal.setLength(0);// clear before each traversal       
            preOrderBinaryTree(root);
            return traversal.toString();
        }

    public static String postOrderBinaryTreeTraversal(TreeNode root) {
        traversal.setLength(0); 
        postOrderBinaryTree(root);
        return traversal.toString();
    }


    public static String inOrderBinaryTreeTraversal(TreeNode root) {
        traversal.setLength(0); 
        inOrderBinaryTree(root);
        return traversal.toString();
    }

    public static String levelOrderBinaryTreeTraversal(TreeNode root) {
        traversal.setLength(0);
        levelOrderBinaryTree(root);
        return traversal.toString();
    }

    /**
     * POST ORDER BINARY TREE TRAVERSAL 
     * 
     *  In this type of binary tree traversal, each node is visited after its children
     * 
     *  Order  
     *      Left -> Right -> Root
     * 
     *  How it works
     * 
     *      1. Recursively traverse the left subtree. 
     *      2. Recursively traverse the right subtree. 
     *      3. Visit the root node.
     * 
     *  Uses
     *      Is often used in deleting or freeing nodes from memory, as it ensures that child nodes
     *      are processed before their parent.
     */

    private static String postOrderBinaryTree(TreeNode root) {
        if(root == null)  {
            traversal.append("null ");   
        }
        if (root != null) {
            postOrderBinaryTree(root.left);// recursive left subtree             
            postOrderBinaryTree(root.right);// recusrive right subtree
            traversal.append(root.val).append(" "); // visit root node
        }


        return traversal.toString();
    }


    /**
     * IN ORDER BINARY TREE TRAVERSAL 
     *
     *  In this type of binary tree traversal, each node is visited between the left and right children.
     * 
     *  Order
     *      Left -> Root -> Right
     * 
     *  How it works
     *      1. Recursively traverse the left subtree.
     *      2. Visit the root node. 
     *      3. Recursivelty traverse the right subtree.  
     * 
     *  Uses
     *      It is commonly used to retrieve elements of a binary search tree in sorted order.
     */

    private static String inOrderBinaryTree(TreeNode root) {
        if(root == null)  {
            traversal.append("null ");   
        }

        if(root != null ) {
            inOrderBinaryTree(root.left);// recursive left subtree 
            traversal.append(root.val).append(" "); // visit root node
            inOrderBinaryTree(root.right);// recusrive right subtree
        }

        return traversal.toString();
    }   



    /**  
     * PRE ORDER BINARY TREE TRAVERSAL  
     * 
     * In this type of binary tree traversal, each node is visited before its chilrdren. 
     * 
     *  Order
     *      Root -> Left -> Right 
     * 
     *  How it works
     *      1. Visit the root node. 
     *      2. Recursively traverse the left subtree. 
     *      3. Recursively traverse the right subtre.  
     *  Uses
     *      Is often used to create a copy of the tree, serialize the tree, or evaluate expressions in prefix notation, inverting tree, etc.
     */
    private static void preOrderBinaryTree(TreeNode root) {
        if(root == null)  {
            traversal.append("null ");   
        }
        
        traversal.append(root.val).append(" ");
    
        if(root.left != null) 
            preOrderBinaryTree(root.left);
        else if(root.left == null)  
            traversal.append("null ");

        if(root.right != null) 
            preOrderBinaryTree(root.right);
        else if(root.right == null) 
            traversal.append("null ");         
    }

    /**
     * LEVEL ORDER BINARY TREE TRAVERSAL 
     * 
     * In this type of binary tree traversal, each node is visited level by level. 
     * 
     *  Uses
     *     BFS; is helpful in finding the shortes path, finding maximum/minimum depth.
     *      
     */

    private static void levelOrderBinaryTree(TreeNode root) {
        if(root == null)  {
            traversal.append("null ");   
        }

        Queue<TreeNode> queue = new LinkedList<>();
        // add root
        queue.add(root);         
        

        while(!queue.isEmpty()) {
            // dequeue root and following nodes
            TreeNode current = queue.poll();
            traversal.append(current.val).append("");
            

            if(current.left != null) 
                queue.add(current.left);
            
            if(current.right != null) 
                queue.add(current.right);        
        }
    }    
  }
