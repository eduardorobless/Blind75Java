package tree; 
import java.util.*; 


public class Medium {

    static TreeNode t1; 
    static TreeNode t2;
    static TreeNode t3; 
    static TreeNode t4;
    static TreeNode t5; 
    static TreeNode t6;
    static TreeNode t7; 
    static TreeNode t8;        
    static TreeNode t9; 
    static TreeNode t10;    




    static TreeNode bst1; 
    static TreeNode bst2; 
    static TreeNode bst3; 
    static TreeNode bst4;
    static TreeNode bst5; 
    static TreeNode bst6; 
    static TreeNode bst7; 
    static TreeNode bst8;
    static TreeNode bst9; 
    static TreeNode bst10;
    /**
     *                 10  
     *              /     \
     *             9       8
     *           /   \    /  \
     *          7    6    5   4
     *         / \   /
     *        3  2  1
     * 
     * 
     * 
     *  
     * 
     *                      6
     *                   /    \   
     *                  2       8
     *                /   \    / \
     *              0     4   7   9
     *                  /   \
     *                  3   5
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


    static {

        // binary tree (non search)
        t1 = new TreeNode(10); 
        t2 = new TreeNode(9);
        t3 = new TreeNode(8); 
        t4 = new TreeNode(7);  
        t5 = new TreeNode(6); 
        t6 = new TreeNode(5);
        t7 = new TreeNode(4); 
        t8 = new TreeNode(3); 
        t9 = new TreeNode(2); 
        t10 = new TreeNode(1); 

        t1.left = t2; 
        t1.right = t3;  

        t2.left = t4; 
        t2.right = t5; 

        t3.left = t6; 
        t3.right = t7;

        t4.left = t8; 
        t4.right = t9; 
        
        t5.left = t10;

        // binary search tree

        bst1 = new TreeNode(9); 
        bst2 = new TreeNode(8); 
        bst3 = new TreeNode(7); 
        bst4 = new TreeNode(6); 
        bst5 = new TreeNode(5); 
        bst6 = new TreeNode(4); 
        bst7 = new TreeNode(3); 
        bst8 = new TreeNode(2); 
        bst9 = new TreeNode(1); 
        bst10 = new TreeNode(0); 

        bst4.left = bst8;
        bst4.right = bst2; 

        bst8.left = bst10;
        bst8.right = bst6; 

        bst2.left = bst3;
        bst2.right = bst1;

        bst6.left = bst7;
        bst6.right = bst5;

    }


    public static List<List<Integer>> binaryTreeLevelOrderTraversalFun(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>(); 
      if(root == null) return res; // always check for edge cases, and remember that empty is different than nullchecking

        Queue<TreeNode> queue = new LinkedList<>(); 
        // add root
        queue.add(root); 


        while(!queue.isEmpty()) {
            int queueSize = queue.size(); //size of queue determine of many times do we iterate and add to list at the end
            List<Integer> innerLevel = new ArrayList<>();

            for(int i = 0; i < queueSize; i++) {
                // dequeue root and following nodes
                TreeNode current = queue.poll();
                innerLevel.add(current.val);
            
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


        return binaryTreeLevelOrderTraversalFun(Medium.t1);
    }


    /**
     * LCA 
     * Objective:
     * Determine the lowest common ancestor between two nodes p and q. 
     * 
     * Strategy: 
     *  Move cursor starting at root, along the tree according to: 
     *  1. If both node values are greater than current move to right. 
     *  2. If both node values are lower than current move left. 
     *  3. Otherwise return current.
     * 
     * Time Complexity: 
     *  O(H)
     * 
     * Space Complexity: 
     * O(1)
     */
    private static TreeNode lowestCommonAncestorBinaryTreeFun(TreeNode root, TreeNode  p, TreeNode q) {



        TreeNode cur = root; 

        while(cur != null) {
            // left side lookup 
            if (p.val < cur.val && q.val < cur.val) 
                cur = cur.left;
            // right side lookup 
            else if (p.val > cur.val && q.val > cur.val) 
                cur = cur.right; 
            
            else
                return cur;             
        }

        return null;        

    }


    public static TreeNode lowestCommonAncestorBinaryTree() {            
        return lowestCommonAncestorBinaryTreeFun(Medium.bst4, Medium.bst3, Medium.bst1);
    }




}