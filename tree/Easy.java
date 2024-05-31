package tree; 
import java.util.*; 


public class Easy {

    /**
     *              10  
     *             /  \
     *            9     8
     *          /   \  /  \
     *          7   6  5   4
     *         / \  /
     *        3  2  1
     *             /
     *            0
     */
    /**
     * Is two tree same structurally and value wise ? 
     * 
     *  Objective: 
     *      Given the root of two trees, determine if they are the same, value and structurally wise.
     * 
     *  Strategy; 
     *      BFS on both trees and compare each element.
     *  Time Complexity: 
     *      O(N)
     *  Space Complexity:
     *      O(N)
     */ 
    private static boolean isSameTreeFun(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>(); 
        queue.add(p);
        queue.add(q);

    
        while(!queue.isEmpty()) {
            // deque first and second nodes
            TreeNode first = queue.poll(); 
            TreeNode second = queue.poll(); 

            // check if they are null, thus continue next iteration
            if(first == null && second == null) 
                continue; 
            
            // if they differ from value or reference wise return false immediatelly

            if(first == null || second == null || first.val != second.val ) 
                return false;



            // add left nodes 
            queue.add(first.left); 
            queue.add(second.left);
            // add right nodes
            queue.add(first.right); 
            queue.add(second.right);
        }

        
        return queue.isEmpty();
    }

    public static boolean isSameTree() {
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




        TreeNode p1 = new TreeNode(10); 
        TreeNode p2 = new TreeNode(9);
        TreeNode p3 = new TreeNode(8); 
        TreeNode p4 = new TreeNode(7);  
        TreeNode p5 = new TreeNode(6); 
        TreeNode p6 = new TreeNode(5);
        TreeNode p7 = new TreeNode(4); 
        TreeNode p8 = new TreeNode(3); 
        TreeNode p9 = new TreeNode(2); 
        TreeNode p10 = new TreeNode(1); 

        p1.left = p2; 
        p1.right = p3;  

        p2.left = p4; 
        p2.right = p5; 

        p3.left = p6; 
        p3.right = p7;

        p4.left = p8; 
        p4.right = p9; 
        


        return isSameTreeFun(t1, p1);
    }

    /**
     * Max Depth of binary tree
     * 
     *  Objective:
     *      Determine max depth of a binary tree. You can get it from the root to the downmost leaf node.
     *  Strategy:
     *      Recursively traverse the binary tree left and right branches comparing at each level the 
     *      left most depth value and the right value , adding one to it account for the current level.
     * 
     * Time Complexity: 
     * 
     *  O(N)
     * 
     * Space Complexity: 
     *  O(N) where h is the height of the tree.
     */
    private static int maxDepth(TreeNode root) {
        // Base case 

        if(root == null) 
            return 0; 

        int leftmost = maxDepth(root.left);
        int rightmost = maxDepth(root.right);

        return Math.max(leftmost, rightmost) + 1;

    }

    private static int maximumDepthBinaryTreeFun(TreeNode root) {
        return maxDepth(root);        
    }

    public static int maximumDepthBinaryTree() {


        TreeNode p1 = new TreeNode(10); 
        TreeNode p2 = new TreeNode(9);
        TreeNode p3 = new TreeNode(8); 
        TreeNode p4 = new TreeNode(7);  
        TreeNode p5 = new TreeNode(6); 
        TreeNode p6 = new TreeNode(5);
        TreeNode p7 = new TreeNode(4); 
        TreeNode p8 = new TreeNode(3); 
        TreeNode p9 = new TreeNode(2); 
        TreeNode p10 = new TreeNode(1); 

        p1.left = p2; 
        p1.right = p3;  

        p2.left = p4; 
        p2.right = p5; 

        p3.left = p6; 
        p3.right = p7;

        p4.left = p8; 
        p4.right = p9; 

        return maximumDepthBinaryTreeFun(p1);
    }


    /**
     * Invert Binary Tree 
     *  Objective:
     *      Invert all left and right subtrees of a binary tree. 
     * 
     * Strategy: 
     *  DFS while inverting left and right sub-branches.
     * 
     * Time Complexity: 
     *  O(N)
     * 
     * Space Complexity:
     * 
     * O(N)
     * 
     *      
     */

    private static TreeNode invertTree(TreeNode root) {
        if(root == null) 
            return null;
        
        // temp store left value 
        TreeNode temp = root.left; 
        root.left = root.right; 
        root.right = temp; 

        invertTree(root.left); 
        invertTree(root.right);
        return root;  
    }

    public static TreeNode invertTreeFun(TreeNode root) {
        return invertTree(root);
    }



    public static TreeNode invertBinaryTree() {
        TreeNode p1 = new TreeNode(10); 
        TreeNode p2 = new TreeNode(9);
        TreeNode p3 = new TreeNode(8); 
        TreeNode p4 = new TreeNode(7);  
        TreeNode p5 = new TreeNode(6); 
        TreeNode p6 = new TreeNode(5);
        TreeNode p7 = new TreeNode(4); 
        TreeNode p8 = new TreeNode(3); 
        TreeNode p9 = new TreeNode(2); 
        TreeNode p10 = new TreeNode(1); 

        p1.left = p2; 
        p1.right = p3;  

        p2.left = p4; 
        p2.right = p5; 

        p3.left = p6; 
        p3.right = p7;

        p4.left = p8; 
        p4.right = p9; 

        return invertTreeFun(p1);
    }


    /**
     * Is a tree subtree of another
     * 
     *  Objective: 
     *      Determine if A tree contains B tree. 
     *  Strategy:
     *      Use a traversal to check if A tree contains B tree.
     *  Time Complexity:
     * 
     *      O(N1 + N2 + M1 + M2); where N1 is the number of nodes in the A tree, N2 number of nodes in the B tree; M1 is the A string, M2 is the B string.
     * 
     *  Space Complexity:
     *      O(h1 + h2 + M1 + M2).; where h1 is the height of A tree, h2 is the height of B tree; M1 is the length of A tree string, M2 of B tree.
     * 
     * OPTIMAL
     * Time Complexity: 
     * 
     *  O(N1 * N2 )
     * 
     * Space Complexity: 
     * 
     *  O(H)
     * 
     * 
     *              1
     *             / \
     *            2   3
     *           / \ / \
     *          4  5 6  7 
     * 
     *             
     *             
     *            2   
     *           / \ 
     *          4  5  
     * 
     * 
     * 
     * 
     */
    private static boolean isSubtreeOfAnotherTreeFun(TreeNode root, TreeNode subroot) {        
        String aTree = TreeNode.preOrderBinaryTreeTraversal(root); 
        String bTree = TreeNode.preOrderBinaryTreeTraversal(subroot);
        System.out.println("a tree: " + aTree); 
        System.out.println("b tree: " + bTree);
        return aTree.contains(bTree);    
    }

    // to move trough root tree 
    private  static boolean isSubtreeOfAnotherTreeOptimal(TreeNode root, TreeNode subRoot) {
        if(root == null)
            return false; 
        return isIdentical(root, subRoot) || isSubtreeOfAnotherTreeOptimal(root.left, subRoot) ||
                 isSubtreeOfAnotherTreeOptimal(root.right, subRoot);
    }

    // to compare identity values

    private static boolean isIdentical(TreeNode s, TreeNode t) {
        // case base if both are null or one of em is null
        if(s == null && t == null) return true; 
        if(s == null || t == null) return false; 

        return s.val == t.val && isIdentical(s.left, t.left) && isIdentical(s.right, t.right);
    }

    public static boolean isSubtreeOfAnotherTree() {
        TreeNode p1 = new TreeNode(3);
        TreeNode p2 = new TreeNode(4); 
        TreeNode p3 = new TreeNode(5); 
        TreeNode p4 = new TreeNode(1); 
        TreeNode p5 = new TreeNode(2);
        TreeNode p6 = new TreeNode(0);


        TreeNode q1 = new TreeNode(4); 
        TreeNode q2 = new TreeNode(1); 
        TreeNode q3 = new TreeNode(2);

        p1.left = p2; 
        p1.right = p3; 

        p2.left = p4; 
        p2.right = p5;
        p5.left = p6;


        q1.left = q2;
        q1.right = q3;


        return isSubtreeOfAnotherTreeOptimal(p1, q1);
        
    }

    
}