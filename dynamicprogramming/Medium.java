package dynamicprogramming;
import java.util.Arrays;


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

    // public static int longestIncreasingSubsequence(int[] nums){

    // }

    // public static int longestCommonSubsequece(String text1, String text2){

    // }

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