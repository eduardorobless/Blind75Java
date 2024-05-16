
import static array.Easy.*; 
import static array.Medium.*;
import static binary.Easy.*;
import static binary.Medium.*;
import static dynamicprogramming.Easy.*; 
import static dynamicprogramming.Medium.*;
import static graph.Medium.*;
import static ll.Easy.*;
import static ll.Medium.*;
import static string.Easy.*;
import static string.Medium.*;

import  java.util.List; 
import java.util.ArrayList; 
import java.util.Arrays; 




class Main {
    static Object res;  
    public static void main(String[] args) {
        
        ////////////////////////////////////////////////////
        // ARRAYS //
        ///////////////////////////////////////////////////

        // res =twoSumBruteForce( new int[]{2 ,7,11,15}, 9);
        // if (res != null && res instanceof int[])   {
        //     int[] arrayResult = (int[]) res;
        //     for (int val : arrayResult) {
        //         System.out.println(val);
        //     }

        // }

        // res = twoSumOptimal(new int[]{2, 7, 11, 15}, 9); 
        // if (res != null && res instanceof int[]) {
        //     int[] arrayResult = (int[]) res; 
        //     for(int val : arrayResult) {
        //          System.out.println(val);
        //     }
        // }


        
        //res = bestTimeToBuySellStock(new int[]{7,1,5,3,6,4});
        // res = bestTimeToBuySellStock(new int[]{7,6,4,3,1});

        // if(res != null  && res instanceof Integer) {
        //     int intResult = (int) res; 
        //     System.out.println(intResult); 
        // }


        // res = containsDupicate(new int[]{1,2,3,1}); 
        // res = containsDupicate(new int[]{1,2,3,4});
        // if(res != null && res instanceof Boolean) {
        //     boolean boolResult = (boolean) res; 
        //     System.out.println(boolResult);
        // }

        // res = productOfArrayExceptSelf(new int[]{1, 2, 3, 4}); 
        //res = productOfArrayExceptSelf(new int[]{-1,1,0,-3,3}); 
        //res = maxSubArrayON(new int[]{-2,1,-3,4,-1,2,1,-5,4}); 
        //res = maxSubArrayON(new int[]{1});
        // res = maxSubArrayON(new int[]{5,4,-1,7,8});
        // printArrayRes(res); 

        // int maxValue = maxBinaryTree();
        // System.out.println("Maximu value in the binary tree " + maxValue);
        //int res = maxProductSubArray(new int[] {2, 3, -2, 4});
        // int res = maxProductSubArray(new int[] {-2, 0, -1});

        //int res = findMinimumInRotatedSortedArray(new int[]{3,4,5,1,2});      
        // int res = findMinimumInRotatedSortedArray(new int[]{3,1,2});      
        // if ( res != (MAX_VALUE_SORTED_ARRAY + 1) )
        //     printRes(res); 


        // int  res= searchInRotatedSortedArray(new int[]{4,5,6,7,0,1,2}, 2); 
        // printRes(res); 


        // int res = containerWithMostWater(new int[]{1,8,6,2,5,4,8,3,7});
        // int res = containerWithMostWater(new int[]{1,1});
        // printRes(res); 


        // int []res = twoSumII(new int[]{2,3,4}, 6);
        // printRes(res); 
        // int []res = twoSumII(new int[]{2,7,11,15}, 9);
        // printRes(res); 
        // int []res = twoSumII(new int[]{-1,0}, -1123);
        // printRes(res); 

        // List<List<Integer>> res = treeSum(new int[]{-1,0,1,2,-1,-4});        
        // printRes(res);


        //////////////////////////////////////////////////////////////////////
        //BINARY//
        //////////////////////////////////////////////////////////////////////

        // int res = sumOfTwoInteger(2, 3); 
        // printRes(res);

        // int res = numberOfOneBits(00000000000000000000000000001011); 
        // printRes(res);
        // int res = numberOfOneBits(0b11111111111111111111111111111101); 
        // printRes(res);

        // int[] res = countingBits(24); 
        // printRes(res);
        
        // int missingNumber = missingNumber(new int[] {3,0,1}); 
        // printRes(missingNumber);
        // int missingNumber = missingNumber(new int[] {0,1}); 

        // int missingNumber = missingNumber(new int[] {9,6,4,2,3,5,7,0,1} ); 
        // printRes(missingNumber);


        // int reversed = reverseBits(51); 
        // printRes(Integer.toBinaryString(reversed));
        
        //////////////////////////////////////////////////////////////////////
        //DYNAMIC PROGRAMMING//
        //////////////////////////////////////////////////////////////////////
        
        // int res = climbStairs(5); 
        // printRes(res);
        // int res = coinChange(new int[]{1,2,5}, 11); 
        // printRes(res);

        // int res = longestIncreasingSubsequence(new int[]{3, 4, -1, 0, 6, 2, 3}); 
        // printRes(res);


        // int res = longestCommonSubsequece("stone", "longest");
        // //int res = longestCommonSubsequece("bd", "abcd");
        // //int res = longestCommonSubsequece("abcde", "ace");
        // printRes(res);

        
        //boolean res = wordBreak("abcdefgh", new ArrayList<String>(Arrays.asList("ab", "cd", "abcd", "h"))); 
        // boolean res = wordBreak("abcdefg", new ArrayList<String>(Arrays.asList("ab", "cd", "efg")));
        // printRes(res);

        // List<List<Integer>> res = combinationSum(new int[]{2, 3, 6, 7}, 7); 
        // printRes(res);

        //int res = houseRobber(new int[]{1,2,3,1});
        //int res = houseRobber(new int[] {2,7,9,3,1});




        // int res = houseRobberII(new int[] {2,3,2});
        
        //int res = houseRobberII(new int[] {1,2,3,1});
        // int res = houseRobberII(new int[] {1,2,3});

        // int res = decodeWays("122016");
        //int res = decodeWays("06");
        //int res = decodeWays("10");

        // int res = uniquePaths(3, 7);
        // printRes(res);


        ////////////////////////////////////////////////////// GRAPHS ////////////////////////////////////////////////////////
        //cloneGraphSetup();
        
        // printRes(courseScheduleSetup());
        
        // printRes(numberOfConnectedComponentsUndirectedGraphSetup());
        
        // printRes(graphValidTreeSetup()); 


        /////////////////////////////////////////////////////// LINKED LIST //////////////////////////////////////////////////////

        //reverseLinkedList(); 
        //printRes(detectCycleLinkedList());
        //mergeTwoSortedLists(); 
        //removeNthNodeFromEndOfList();
        //reorderList();


        //////////////////////////////////////////////////////// STRINGS ////////////////////////////////////////////////////////////
        //printRes(validPalindrome());        
        //printRes(validParentheses()); 
        //printRes(validAnagram());
        printRes(longestSubstringWithoutRepeatingCharacters());
    }



    private static void printRes(Object res) {
        if (res != null && res instanceof int[]) {
            int[] arrayResult = (int[]) res; 
            for(int val : arrayResult) {
                 System.out.println(val);
            }
        } else if(res != null && res instanceof List<?>) {
            List<?> list = (List<?>) res; 

            for(Object obj: list) {
                if(obj instanceof List<?>) {
                    List<?> innerList = (List<?>) obj; 
                    for(Object innerObj : innerList) {
                        if (innerObj instanceof Integer) {
                            System.out.print(innerObj + " ");
                        }
           
                    }

                    System.out.println(); 
                }
            }
        

        }
        else if(res != null && res instanceof Integer) {
            System.out.println(res); 
        }
        else {
            System.out.println("Result is: " + res); 
        }
    } 
}