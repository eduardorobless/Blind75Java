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


    private static boolean isValidBSTFun(TreeNode node, Integer lower, Integer upper) {

        // case base
        if (node == null) 
            return true;

        int val = node.val;
        // checking 
        // check for valid lower value 
        if (lower != null && val <= lower ) 
            return false; 
        // check for valid upper value 
        if (upper != null && val >=  upper) 
            return false;


        // check for valid childs 
        // recursive all the way to right 

        if(!isValidBSTFun(node.right, val, upper) ) 
            return false;

        // recursive all the way to left
        if (!isValidBSTFun(node.left, lower, val)) 
            return false;


        return true;
    }





    /** 
     * Is valid Binary Search Tree 
     * 
     *  Objective:
     *      Determine if a binary tree is a valid binary search tree. 
     *  
     *  Strategy: 
     *      To determine such a task you need to account for accomplish certain conditions: 
     *          We first in a reverse preorder traversal (root, right, left) traverse the tree, looking for 
     *          valid node values. 
     *      Thus. valid node values, are the current.right value must be greather tan current, then check in left 
     *      recursion the following condition; node = left, lower (parent value), current value.
     * 
     *  Time Complexity: 
     *  O(N)
     *  Space Complexity: 
     *  O(H)     
     *      
     */
    public static boolean isValidBST(){
        return isValidBSTFun(Medium.bst1, null, null); // (infinity range)
    }


    
    private static TreeNode constructBinaryTreeFromPreOrderAndInOrdeTraversalFun(int[] preOrder, Map<Integer, Integer> inOrderMap, 
    int rootIndex, int left, int right) { 
        // steps to do... 

        // create root node 
        int rootValue = preOrder[rootIndex];
        TreeNode root = new TreeNode(rootValue);  
        // get mid (root)
        int mid = inOrderMap.get(rootValue);
        // assign left and rght nodes 
        // look for left up to mid -1 in the inorder map

        if(left < mid)

            root.left = constructBinaryTreeFromPreOrderAndInOrdeTraversalFun(preOrder, inOrderMap, rootIndex + 1, left, mid -1);


        if (right > mid)

            root.right = constructBinaryTreeFromPreOrderAndInOrdeTraversalFun(preOrder, inOrderMap, rootIndex +1 + mid - left, mid+1, right);
            

        return root;
    }
    /**
     * 
     * Construct Binary Tree
     * 
     *  Remember:
     *      Preorder: ROOT, LEFT, RIGHT
     *      Inorder: LEFT, ROOT, RIGHT
     * 
     *  Objective: 
     *      Base on preorder and inorder array construct binary tree
     * 
     *  Strategy: 
     *      Using preorder array determine root of binary tree, use inorder tree to get left and right subtree according to said root. 
     *      Having the left, and right subtree recursively repeat process till base conditions met: 
     *      mid being equal to left and equal to right. 
     *      return root. 
     * 
     *  Time Complexity: O(N) 
     *  Space Complexity; O(N)
     * 
     *      
     */

    public static TreeNode constructBinaryTreeFromPreOrderAndInOrdeTraversal() {        
        // we need hashmap to store index of inorder elements. 
        int [] preOrder = {3, 9, 20, 15, 7}; 
        int [] inOrder = {9, 3, 15, 20, 7};

        Map<Integer, Integer> inOrderMap = new HashMap<>(); 

        for(int i = 0; i < inOrder.length; i++) 
            inOrderMap.put(inOrder[i], i); 

    
        // we need to lookup for nodes at preorder array based on index
        // we need to lookup for nodes at preorder array based on index
        return constructBinaryTreeFromPreOrderAndInOrdeTraversalFun(preOrder, inOrderMap, 0, 0, preOrder.length - 1);
    }


    




    private  static Result kthSmallestElementInBSTFun(TreeNode  root, int k, int count)  {
        // case base if root null return a new result object with empty value; 
        if (root == null) {
            return new Result(count, null);
        } 

        // start the fun :) 
        // left traversal 
        Result leftResult = kthSmallestElementInBSTFun(root.left, k, count);


        // checking in root if we can exit 
        if(leftResult.value != null) 
            return leftResult;

        // continue incrementing count in recursion 

        
        count = leftResult.count + 1; 

        // right visit :)   


        // we need to return from recursion, the most important part lol 
        if(k == count) 
            return new Result(count, root.val); 

        return kthSmallestElementInBSTFun(root.right, k, count);

        
    }


    /** 
     *  Find the kth smallest element in a BST
     * 
     * Objective: 
     *      Given k int value determine k smallest integer (1st index based) in a BST.
     *  
     * Approach:
     *       inorder lookup incrementing counting when visitng root. 
     * 
     * Time Complexity:
     *      O(N)
     * 
     * Space Complexity: 
     *      O(H) 
     * 
     */

    public static int kthSmallestElementInBST() {

        Result result = kthSmallestElementInBSTFun(bst4, 1, 0);
     
        return result.value != null ? result.value : Integer.MIN_VALUE;
    }


    /**
     * Trie
     * 
     * Objective:
     *  Create a trie data structure and implement insert, serach and stringStartsWith method.
     * Strategy:  
     *  Create a data structure storing each lowercase english alphabet letter at each node. 
     * 
     *
     * To create a Trie, we need to first identy what are we going to store into it.
     *  We are gonna store the lowercase English letters alphabhet so we create a Trie
     *  array for each object, of size 26 and a flag to indicate that a character is
     *  the end of the word. 
     * 
     * 
     * Time Complexity: 
     *  For insert: 
     *      O(N) where is N is the world length
     *  For search:
     *      O(N); where N is the length of the word
     *  For prefix lookup: 
        *  O(N); where N is the length of the prefix
     * 
     * Space Complexity: 
     *  For insert: O(EN) where EN is the sum of lenghts of all inserted words.
     *  
     *   
     * 
     */
    public static void useTrie() {
        String word = "cartoon";
        String prefix = "car";
        Trie obj = new Trie();
        obj.insert(word);
        boolean param_2 = obj.search(word);
        boolean param_3 = obj.startsWith(prefix);        
        System.out.println("Is word: " + word + " in trie?: " + param_2 + "\nDoes string: " + word + " has prefix: " + prefix + "?: " + param_3);
    }



    /**
     * Design add search word
     *  Objetive: 
     *      Design a dataStructure to allow adding words to a dictionary, then searching by each character and also by wildcard '.'.
     *  Strategy:
     *      Design a trie when will store each character.
     *      We will lookup each char in the trie, perform recursive search in case of '.' is found.
     *  Time Complexiy:
     * 
     *  For Insert
     *      O(N) 
     *  For Search
     *      O(N) when there is no wild cards, when there is wildcard time can be upto O(26^2 * N) = O(N), where N is the length of the word.
     *  
     *  Space Complexity:
     *  For Insert: O(EN) where EN is the sum of lengths of all inseted words. 
     *      
     */

    public static void designingAddSearchWord() {
        String word = "cat"; 
        String searchWord = "ca.";
        Trie obj = new Trie(); 
        obj.insert(word); 
        
        boolean searchResult = obj.search(searchWord.toCharArray(), 0, obj.getRoot()); 
        System.out.println("Doe word: " + searchWord  +  " appears in trie? " + searchResult); 
         

    }

}


    class TrieNode {
        public boolean endOfWord;
        public TrieNode[] children; 
        
        public TrieNode() {
            children =  new TrieNode[26];
            endOfWord = false; 
        }
    }

    class Trie {
        private TrieNode root;

        public TrieNode getRoot() {    
            return root;
        }

        public Trie() {
            root = new TrieNode();                        
        }

        public void insert(String word) {
            //node points to root and will traverse
            TrieNode node = root;   
            for(char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (node.children[index] == null) {
                    // create new TrieNode 
                    node.children[index] = new TrieNode();                    
                }
                node = node.children[index];
            }

            node.endOfWord = true;
        }
    
        public boolean search(String word) {
            TrieNode node = root; 
            for(char ch: word.toCharArray()) {
                // case base node.children is null 
                node = node.children[ch - 'a'];
                if (node == null) 
                    return false; 
            }

            return node.endOfWord;
        }




        /** SEARCHIGN for including . char  overloading previous seach method */
        public boolean search(char[] chars, int start, TrieNode node) {
            // two main cases to handle, when getting dot, make recursive calls, otherwise do regular search
            for(int i = start; i < chars.length; i++ ) {
                char current = chars[i];

                if(current == '.') {
                    // check children of current node to see if they have a current value.
                    for(TrieNode children : node.children) {
                        if(children != null && search(chars, i + 1, children)) return  true;                         
                    }
                    return false;

                } else {
                    node = node.children[current - 'a'] ;
                    if(node == null) return false;
                }
            }

            return node.endOfWord;
        }


        public boolean startsWith(String prefix) {
            TrieNode node = root; 
            for(char ch: prefix.toCharArray()) {
                // case base node.children is null 
                node = node.children[ch - 'a'];
                if (node == null) 
                    return false; 
            }

            return true;                
        }

    }


     class Result  {
        int count; 
        Integer value; 

        Result(int count, Integer value) {
            this.count = count; 
            this.value = value;
        }
    }