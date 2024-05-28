package tree; 
import java.util.*;


public class Review {

    /**
     *              10  
     *             /  \
     *            9    8
     *          /   \ /  \
     *          7   6 5   4
     *         / \  /
     *        3  2  1
     */


    public static void bfs() {

        TreeNode t1 = new TreeNode(10); 
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(8); 
        TreeNode t4 = new TreeNode(7);  
        TreeNode t5 = new TreeNode(6); 
        TreeNode t6 = new TreeNode(5);
        TreeNode t7 = new TreeNode(4); 
        TreeNode t8 = new TreeNode(3); 
        TreeNode t9 = new TreeNode(2); 
        TreeNode t10 = new TreeNode(1); 

        t1.left = t2; 
        t1.right = t3;  

        t2.left = t4; 
        t2.right = t5; 

        t3.left = t6; 
        t3.right = t7;

        t4.left = t8; 
        t4.right = t9; 
        
        t5.left = t10;




        Queue<TreeNode> queue = new LinkedList<>();
        
        // add root

        queue.add(t1); 


        while(!queue.isEmpty()) {
            // dequeue root and following nodes
            TreeNode current = queue.poll();
            System.out.println(current.val);

            if(current.left != null) 
                queue.add(current.left);
            
            if(current.right != null) 
                queue.add(current.right);        
        }

    }


    /**
     * POST ORDER BINARY TREE TRAVERSAL 
     */
    private static void postOrderBinaryTreeTraversal(TreeNode root) {

    }


    /**
     * IN ORDER BINARY TREE TRAVERSAL 
     * 
     * 
     */
    private static void inOrderBinaryTreeTraversal(TreeNode root) {

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
    private static void preorderBinaryTreeTraversal(TreeNode root) {
        if(root == null) 
            return;

        System.out.println(root.val);
        
        if(root.left != null) {

            preorderBinaryTreeTraversal(root.left);
        }

        if(root.right != null) { 
            preorderBinaryTreeTraversal(root.right);
        }
    }
    /**
     *              10  
     *             /  \
     *            9    8
     *          /   \ /  \
     *          7   6 5   4
     *         / \  /
     *        3  2  1
     */
    public static void binaryTreeTraversal() {
        TreeNode t1 = new TreeNode(10); 
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(8); 
        TreeNode t4 = new TreeNode(7);  
        TreeNode t5 = new TreeNode(6); 
        TreeNode t6 = new TreeNode(5);
        TreeNode t7 = new TreeNode(4); 
        TreeNode t8 = new TreeNode(3); 
        TreeNode t9 = new TreeNode(2); 
        TreeNode t10 = new TreeNode(1); 

        t1.left = t2; 
        t1.right = t3;  

        t2.left = t4; 
        t2.right = t5; 

        t3.left = t6; 
        t3.right = t7;

        t4.left = t8; 
        t4.right = t9; 
        
        t5.left = t10;


        preorderBinaryTreeTraversal(t1); 
    }
}