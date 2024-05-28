package tree; 
import java.util.*; 


public class Medium {

    /**
     *              10  
     *             /  \
     *            9    8
     *          /   \ /  \
     *          7   6 5   4
     *         / \  /
     *        3  2  1
     */


    /**
     * Binary Tree Level Order Traversal 
     * 
     *  Objective:
     *      Store in a list of list a level resulting by a binary tree level order traversal. 
     * 
     *  Strategy: 
     *      Use BFS and create list appending them into a list of list accordingly.  
     *      You need a way to keep track of how many elements are currently in the queue.
     * 
     *  Time Complexity:
     *      O(N)
     * 
     *  Space Complexity: 
     *      O(N)
     */
    public static List<List<Integer>> binaryTreeLevelOrderTraversalFun(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>(); 

        Queue<TreeNode> queue = new LinkedList<>();


        if(root == null) return res;
         
        // add root
        queue.add(root); 


        while(!queue.isEmpty()) {
            int queueSize = queue.size(); //size of queue determine of many times do we iterate and add to list at the end
            List<Integer> innerLevel = new ArrayList<>();

            for(int i = 0; i < queueSize; i++) {
                // dequeue root and following nodes
                TreeNode current = queue.poll();
                innerLevel.add(current);
            
                if(current.left != null) 
                    queue.add(current.left);
                
                if(current.right != null) 
                    queue.add(current.right);     


            }

            res.add(innerLevel);
   
        }

        return res;
    }



    public static List<List<Integer>> binaryTreeLevelOrderTraversal(TreeNode root) {
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

        return binaryTreeLevelOrderTraversalFun(root);
    }
}