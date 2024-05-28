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
}