package arrays;
import java.util.Map; 
import java.util.HashMap; 
import java.util.LinkedList; 
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class Medium{
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
   
            if (curSum < 0) { // in all negative cases current sum is restarted looking for positive subsums
                curSum = 0;   // consider that in case of negative sum they are accounted in for max too
            }
            curSum += n;

            if(curSum > max) 
                max = curSum; 
        }   
        return max;
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
                if (am_big) {       // if middle element is in the greater area move to the lesser area iow i wanna move to right
                    low = mid + 1;  
                }   
                else {              //  if middle element is in the lower area move to the greater area. iow i wanna move to left
                    high = mid -1;
                }
            }

       
        }        
     return -1;


    }
    public static int[] twoSumII(int[] nums, int target) {
        // keep two pointers, and move tose accordingly
        int l = 0; 
        int r = nums.length -1; 

        while (l < r) {
            int curSum = nums[l] + nums[r]; 
            if( curSum < target){
                l++;
            } 
            else if( curSum > target) {
                r--;
            }
            else {
                return new int[]{l + 1, r + 1}; 
            }            
        }

       throw new IllegalArgumentException("wrong args");

    }

    public static List<List<Integer>> treeSum(int[] nums)
    {
        Arrays.sort(nums);
        // iterate sorted array then do two sum accordingly 
        List<List<Integer>> output = new ArrayList<>(); 

        // sort 
        // iterate array
        // check for duplicates at zero greter indexes, if so skip loop  (increased vs before)
        // get left and right pointer 
        // get treesum and update pointers accodingly 
        // if found triplet add it, and increase left pointer 
        // check for  repeated left pointer ( increased vs berfore). if duplicate skip


        for (int i = 0; i < nums.length - 2; i++) {


            if(i == 0 || ! (nums[i] == nums[i -1])) {
                int left =  i + 1, right = nums.length - 1; 


                            // another loop to apply two sum II to the other two elements 
                while (left < right) {
                    int treeSum = nums[i] + nums[left] + nums[right]; 
                    if (treeSum < 0){
                        left++; 
                    }
                    else if (treeSum > 0){
                        right--;
                    }
                    else{
                        output.add(  Arrays.asList(nums[i], nums[left], nums[right])  ) ;                
                        while (left < right && nums[left] == nums[left+1]) left++;
                        while (left < right && nums[right] == nums[right-1]) right--;

                        left++; 
                        right--;
                    }
                }
            }
        }

    
        return output;
    }

    public static int containerWithMostWater(int[] nums) {
        int l = 0; 
        int r = nums.length -1; 
        int maxArea = 0;
        
        while(l < r) {
            // calculate max area 
            int area = (r-l) * Math.min(nums[l], nums[r]); 
            maxArea = Math.max(maxArea, area); 

            // add conditions to maximize water 
            if (nums[l] < nums[r]) {
                l++;
            }
            else {
                r--;
            }
        
        }

        return maxArea;
    }
}