package array;
import java.util.Map; 
import java.util.HashMap; 

public class Easy {     
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

}