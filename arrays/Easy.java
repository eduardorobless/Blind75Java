package arrays;
import java.util.Map; 
import java.util.HashMap; 



class TreeNode {
   
    int val; 
    TreeNode left, right; 

    TreeNode(int val) {
        this.val = val; 
        this.left = this.right = null;
    }
}

public class Easy {
     public static final int MAX_VALUE_SORTED_ARRAY = 5000;
    public static int findMaxValue(TreeNode root) {
        return findMaxValueHelper(root, Integer.MIN_VALUE); 
    }


    public static int findMaxValueHelper(TreeNode node, int maxValue) {
        if (node == null) {
            return maxValue; // maximum value encontered so far
        }

        // update maxmimum value encontered so far
        maxValue = Math.max(maxValue, node.val); 


        // recursievry transverse left and right subtreess 
        int leftMax = findMaxValueHelper(node.left, maxValue); 
        int rightMax = findMaxValueHelper(node.right, maxValue);


        // return maximum value from left and right subtress
        return Math.max(maxValue, Math.max(leftMax, rightMax));

    }



    public static void greet() {
        System.out.println("What up!"); 
    }

    public static int[] twoSumBruteForce(int[] nums, int target) { 
             for(int i = 0; i < nums.length; i++) {
                for (int j = 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) 
                    return new int[]{i, j}; 
                }
             }
             return null;            
    }

    public static int[] twoSumOptimal(int[] nums, int target) {
        // create empty key, value like data structure; using hashmap
        Map<Integer, Integer> integerMap = new HashMap<>(); 
        for(int  i=0; i < nums.length; i++) {
            int complement = target - nums[i]; 
            if (integerMap.containsKey(complement)) 
                return new int[]{i, integerMap.get(complement)}; 
                else
                    integerMap.put(nums[i], i);
        }
        return null; 
    }

    public static int bestTimeToBuySellStock(int[] prices) {
        int max_profit = 0; 
        int profit = 0; 
        int l = 0; 
        int r = l + 1; 
        // setting left and right pointer accordingly
        for (int x = 0; x < prices.length - 1; x++) {            
             if  (prices[r] > prices[l]) {
                  profit = prices[r] - prices[l];
                  if (profit > max_profit) 
                    max_profit = profit;                    
                }
            else {
                l = r;            
            }
            r++;                                 
        }
        return max_profit;               

    }


    public static boolean containsDupicate(int[] nums) {    
        HashMap<Integer,Integer> numbers = new HashMap<>(); 
        for(int i = 0; i < nums.length; i++) {
            if(numbers.containsKey(nums[i]))
                return true;  
            else 
                numbers.put(nums[i], i);             
        }

        return false; 
      
    }



    public static int[] productOfArrayExceptSelf(int[] nums)   { 
        int prefix = 1; 
        int postfix = 1; 
        int[] res = new int[nums.length];
        for (int i=0; i < nums.length; i++) {
                res[i] = prefix; 
                prefix *= nums[i];
        }
        for (int j= nums.length -1;  j > -1; j--) {
            res[j] *= postfix; 
            postfix *= nums[j];
        }   


        return res;
        
    }

    // search for divide and conquer solution
    public static int maxSubArrayON(int[] nums) { 
        int max = nums[0]; 
        int curSum = 0; 
        
        for(int n: nums) {
   
            if (curSum < 0) {
                curSum = 0; 
            }
            curSum += n;

            if(curSum > max) 
                max = curSum; 
        }   
        return max;
    }


    public static int maxBinaryTree() {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5); 
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(23); 
        root.left.right = new TreeNode(7); 
        root.right.right = new TreeNode(18);
        root.right.left = new TreeNode(49);

        return findMaxValue(root);
    }


    public static int maxProductSubArray(int[] nums) {
        // keep track that for each iteration we can have 
        // the following possible scenarios :
            // even negative numbers that get a positive result 
            // odd negative numbers that get a negative result 
            // two positive numbers that get a positive result
            // zero value which resets subarrays product sum 

            int curMax = 1; 
            int curMin = 1;
            // int res = nums[0]; 
            int res = nums[0];
 
        
            for(int n: nums) {
                int tempMax = curMax; // store precious max as we are gonna modify it
                // determine cur max  iow what is greater n * curMax , n * curMin, or n
                // asume n is max and update accordingly                 
                curMax = Math.max(n,  Math.max(n * curMax, n * curMin));
                curMin = Math.min(n, Math.min(n * tempMax, n * curMin));                 
                res = Math.max(res,curMax);
                // determine cur min iow what is greater n * curMax, n * curMin or n             
            }


            return res;
    }

    public static int findMinimumInRotatedSortedArray(int[] nums) {
        int left = 0, right = nums.length - 1;
        int l = 0; 
        int r = nums.length -1;
        int middle = l  + (r - 1) /2;
        while(l < r) {
       
            if (nums[middle] > nums[r]) // our search is at right side 
                l = middle + 1;
            else // our search is at left side  
                r = middle;            
            
            
            middle = l + (r - l) /2;  
        }
        
        return nums[middle];

    }

    public static int searchInRotatedSortedArray(int[] nums, int target) {
        int low = 0;
        int high = nums.length -1; 
        int first = nums[0]; 

        while(low <= high) {
            int mid = low + (high - low) / 2; 
            int value = nums[mid]; 
            if(value == target) {
                return mid;
            }
            boolean am_big = value >= first;
            boolean target_big = target >= first; 


            if(am_big == target_big) { // target and middle element are in the same area
                if(value < target) {
                    low = mid +1;
                }
                else {
                    high = mid -1;
                }
            } else {                // target and middl element are not in same area, thus moving accordingly 
                if (am_big) {       // if middle element is in the greater area move to the lesser area
                    low = mid + 1;  
                }   
                else {              //  if middle element is in the lower area move to the greater area.
                    high = mid -1;
                }
            }

       
        }


     return -1;


    }
    // public static int twoSum(int[] nums) {

    // }
    // public static int treeSum(int[] nums)
    //{

    // }
    // public statix int containerWithMostWater(int[] nums) {

    // }
}