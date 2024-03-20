package dynamicprogramming;
import java.util.Arrays;
import java.util.Optional; 

public class Medium{
    public static int coinChange(int[] coins, int amount){
        int [] dp = new int[amount +1]; 
        Arrays.fill(dp, amount + 1); 

        dp[0] = 0; // base 
        for (int a=1; a <= amount; a++) {
            for(int coin: coins) {
                if (a - coin >= 0){
                    dp[a] = Math.min(dp[a], 1 + dp[a - coin]); 
                }
            }
        }

        if (dp[amount] != amount +1) {
            return dp[amount]; 
        } else {
            return -1;
        }

    }     


    public static int longestIncreasingSubsequence(int[] nums){
        // dp approach
        int[] res = new int[nums.length]; 
        Arrays.fill(res, 1);


        for (int i=1; i < nums.length; i++) {            
            for(int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    res[i] = Math.max(res[i], 1 + res[j]);
                }
            }
        }


        int max = 0;
        for(int i: res) {
            if (i > max) {
                max = i;
            }
        }

        return max;


        // // N ^ 2 solution looking for O logN 
        // int[] dp = new int[nums.length]; 
        // Arrays.fill(dp, 1); 

        // // iterating backwards to get subproblems solved if conditions met 
        // for(int i = nums.length - 1; i >= 0; i--) {
        //     for(int j = i + 1; j < nums.length; j++) {
        //         if (nums[i] < nums[j]) {
        //             dp[i] = Math.max(dp[i], 1 + dp[j]); 
        //         }
        //     }
        // }
        // return Arrays.stream(dp).max().orElse(0);
    }


    static int lcsNoMemoization(int i, int j, String A, String B) {
        if (i == A.length() || j == B.length())
            return 0;   
        else if (A.charAt(i) == B.charAt(j)) 
            return 1 + lcsNoMemoization(i +1, j + 1, A, B); 
        else
            return Math.max(lcsNoMemoization(i+1, j, A, B), lcsNoMemoization(i, j+1, A, B) ); 
    }

    static int lcsMemoization(int i, int j, String A, String B, Integer[][] memo) {
        System.out.printf("i:  %s, j: %s \n", i, j);
        System.out.printf("Memoization [i:%s, j:%s] = %d\n", i, j, memo[i][j]);

        if (memo[i][j] != null) {
            return memo[i][j];  // using memo
        }

        int result;

        // create matrix for memoization 
          if (i == A.length() || j == B.length()) {
            System.out.println("you are at null");
            result = 0;   
          }
        else if (A.charAt(i) == B.charAt(j))  {
            System.out.println("you are at equals");
            result = 1 + lcsMemoization(i +1, j + 1, A, B, memo); 
        }
        else {
            System.out.println("you are at non equals");
            result = Math.max(lcsMemoization(i+1, j, A, B, memo), lcsMemoization(i, j+1, A, B, memo) ); 
        }

        System.out.printf("result %d\n\n\n\n", result);


        memo[i][j] = result; // memoize the result 
        return result;
    }



    public static int longestCommonSubsequece(String text1, String text2){
        //return lcsNoMemoization(0, 0, text1, text2);
        Integer[][] memo = new Integer[text1.length() + 1][text2.length() + 1];

        
        return lcsMemoization(0, 0, text1, text2, memo);
    }

    // public static boolean wordBreak(String s, List<String> wordDict){

    // }

    // public static List<List<Integer>> combinationSum(int[] candidates, int target){

    // }
    
    // public static int houseRobber(int[] nums){

    // }
    
    // public static int houseRobberII(int[] nums){

    // }
    
    // public static int decodeWays(String s){

    // }

    // public static int uniquePaths(int m, int n){

    // }

    // public static boolean jumpGame(int[] nums){
        
    // }
    
}