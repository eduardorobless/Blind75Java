package dynamicprogramming;
import java.util.Arrays;
import java.util.Optional; 
import java.util.List;
import java.util.ArrayList; 
import java.util.HashMap;
import java.util.Map;
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


    static int lcsBottomUpDP(String A, String B, int[][] memo) {
        int m = A.length(); 
        int n = B.length(); 
        // do not change data
        // use i, j for dp and do not change it
        // choose simple of course is easier to just modify string indexes 
        // substracting one to them.
        
        for(int i = 1; i <= m; i++) {
            for(int j= 1; j <= n; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) // if they are equal then get 1 plus diagonal 
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                else 
                    memo[i][j]= Math.max(memo[i - 1][j], memo[i][j-1] ); 
                }
        }   




      for (int k = 0; k < memo.length; k++) {
            for (int l = 0; l < memo[k].length; l++) {
                System.out.print(memo[k][l] + " ");
            }
            System.out.println(); // Move to the next line for the next row
        }



        System.out.printf("m: %d, n: %d\n", m, n);

                
        return memo[m][n];
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
        //Integer[][] memo = new int[text1.length() + 1][text2.length() + 1];
        //return lcsMemoization(0, 0, text1, text2, memo);
        int[][] memo = new int[text1.length() + 1][text2.length() + 1];        
        return lcsBottomUpDP(text1, text2, memo); 
    }

    

    /*
    1, Loop trough the dictionary and check if we can match a word from the dictionary with s
        1. If we can, we splice off the word from the beginning of s and make a recursive call with the shortened s.
        2. If not, we move onto the next word.
    2. If we make it trough the dictionary and cannot match a word, we return false. But if at any time a recursive call returned true, we return true.
    3. Base case is if the string is empty in which case, we return true.
    */
     // time complexity O(2^N)
    // space complexity O(M) where M is the length of the string; as we are using recursion we need to take into account the depth.
    public static boolean wordBreakNoMemo(String s, List<String> wordDict) {
        
        if (s.length() == 0)
            return true;              
        for (String word: wordDict) {
   
            try {
                String prefix = s.substring(0, word.length()); // get substring to match in string based on dictionary entry
                boolean result = false; 

                if (prefix.equals(word)) 
                    result = wordBreakNoMemo(s.substring(word.length()), wordDict); 
                if (result) 
                    return true;  
            } catch(StringIndexOutOfBoundsException e) {
                continue;
            } finally{
                System.out.printf(" entering  \n");
                continue;
            }

        }

        return false;

    }



    // Adding memo to the word break problem allows us to decresae 

    //  TIME COMPLEXITY O(N^2 * N) ;recursion subproblems, N substring complexity
    //  SPACE COMPLEXITY (2^M); where m is the length of the input string s, taking into consideration other factors 
    //  such as the space took by the recursive stack being m and the dictionary being n, the memoization table is
    // the one that has more weight
    public static boolean wordBreakMemo(String s, List<String> wordDict, Map<String, Boolean> memo) {
        System.out.println(s);
           // Print keys and values
        for (Map.Entry<String, Boolean> entry : memo.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        if (s.length() == 0) {
            return true;
        }
        else if (memo.containsKey(s)) {
            return memo.get(s);
        }
     
        for (String word: wordDict) {
        
            if (word.length() > s.length()) 
                continue;
                
    
            if (s.substring(0, word.length()).equals(word) && wordBreakMemo(s.substring(word.length()), wordDict, memo)) {
                memo.put(s, true);
               
                return true;         
            }

           
        }

        //before returning false
        memo.put(s, false);
        return false;
    }




    // Now, using DP Bottom up strategy; or to the friends using solution of smaller problems to solve larger problemss 

    // Strategy: 
    // Allocate an array (dp table) for each character in string plus one, as each location indicates: 
    // Can you form the string ending in that position with the words in the dictionary? 
    // intiate the first position with true, as per default we can always form the empty string
    // iterate: 
        // use two pointers; one point er starting from 1 up to string length  + 1, this is to check new substrings 
        // and anoter pointer (for checking previous solutions) starting one position before up to zero position, when you find a match for both expressions return and set it to true
    // las position of the dp table represent if we can form the string using the dictionary, so we return it to the end  


    // TIME COMPLEXITY O(N^2)
    // SPACE COMPLEXITY O(N)
    public static boolean wordBreakDP(String s, List<String> wordDict) {
        int sLen = s.length();
        boolean[] dpTable = new boolean[sLen + 1];
        dpTable[0] = true;



        for(int i = 1; i <= sLen; i++) {
            for (int j = i-1 ; j > -1; j--) {
                if(dpTable[j] && wordDict.contains(s.substring(j, i))) {
                    dpTable[i]= true;
                    break;
                } 
            }
        }


        System.out.println("DP TABLE");
        for(boolean val: dpTable) 
            System.out.println(val);
        System.out.println("DP TABLE");
        return dpTable[sLen];
    }

    public static boolean wordBreak(String s, List<String> wordDict){
        // create memo using a hashmap data structure 
        Map<String, Boolean> memo = new HashMap<>();
        return wordBreakMemo(s, wordDict, memo);
        //return wordBreakNoMemo(s, wordDict);
    }

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