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
            if (s.startsWith(word)) { // instead of extracting prefix from string check directly is string match with word dictionary word
                if(wordBreakNoMemo(s.substring(word.length()), wordDict)) 
                return true;
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
        //Map<String, Boolean> memo = new HashMap<>();
        //return wordBreakMemo(s, wordDict, memo);
        //return wordBreakNoMemo(s, wordDict);
         return wordBreakDP(s, wordDict);
    }



    // Strategy
    // Use a DFS backtracking solution
    // keep track of current index being iterated
    // keeep track of current combination elements
    // kepp track of current combination array solution
    // STILL PENDING TIME AND SPACE COMPLEXITY
    // THIS IS MORE A BACKTRACKING PROBLEM RATHER THAN A DP ONE.
    public static List<List<Integer>> combinationSumDFS(int[] candidates, int target, int index, List<Integer> cur, List<List<Integer>> combinations){ 
        // set base case    
        // base case is when we return, we return when target condition is less or equal to zero 
        // also add to combinations when target is equal to 0 
        if (target <= 0) {
            if (target == 0) 
                combinations.add(new ArrayList<>(cur)); 
            return null;
        }

        // iterative calls within restriction of index in range
        if (index < candidates.length) {
            // recursive call substrating
            // pushing element 
            cur.add(candidates[index]);
            combinationSumDFS(candidates, target - candidates[index], index, cur, combinations);
            // popping element
            cur.remove(cur.size() - 1);  // remove last element
            // calling recursive without substracting
            combinationSumDFS(candidates, target, index + 1, cur, combinations); 
        }


        return combinations;
    }


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        int index = 0; 

        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> combinations= new ArrayList<>();

        return combinationSumDFS(candidates, target, 0, cur, combinations); 
    }

    
    // STRATEGY: 
    // DP APPROACH 
    // TIME COMPLEXITY: O(N)
    // SPACE COMPLEXITY: O(N)
    public static int houseRobber(int[] nums){
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int dp[] = new int[nums.length+1];

        dp[0]=0; 
        dp[1]= nums[0]; 

        for(int i = 1; i< nums.length; i++) {
            dp[i+1] = Math.max(dp[i], dp[i-1] + nums[i]);
        }

        return dp[nums.length];
    } 
    

    // STRATEGY: 
    // DP APPROACH 
    // REUSE HOUSE ROBBER TAKING INTO ACCOUNT: 
    // 1-If we pick the first house skip last one 
    // 2-If we pick the last house skp first one
    public static int houseRobberII(int[] nums){
        int max1 = houseRobber(Arrays.copyOfRange(nums, 0, nums.length - 1));
        int max2 = houseRobber(Arrays.copyOfRange(nums, 1, nums.length));


        return Math.max(max1, max2);

    }
    
    // STRATEGY: 
    // IN THIS CHALLENGE WE HAVE THE FOLLOWING POSSIBLE SCENARIOS: 
    // 1 - number of i and i -1 between 10 and 26
    // 2 - number of i and i - 1 larger than 26
    // 3 - number of i == 0 and i - 1 == 1 or i - 1 == 2 
    // 4 - number of i == 0 and i - 1 > 2



    // STRATEGY

    // BRUTE FORCE
    // RECURSIVELY DECODE ONE OR TWO CHRACTERS FROM STRINGS UNTIL ALL POSSIBLE WAYS ARE VISITED, DFS 
    // ADD +1 TO COUNT OF WAYS IF WE GET EMPTY STRING




    //memo will consist of hash like structure where key is the substring and the values are the number of ways
    public static int decodeWaysMemoHelper(String s, Map<String, Integer> memo ) {
    
        // check memo and return value from memo without re-doing process
        if (memo.containsKey(s)) {

            for(Map.Entry<String, Integer> entry: memo.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }

            return memo.get(s); 
        }

        if (s.isEmpty()) return 1;
        if (s.startsWith("0")) return 0;
        
        int ways = decodeWaysMemoHelper(s.substring(1), memo);
        // store number of ways into memo 
        if (s.length() >= 2 && Integer.parseInt(s.substring(0, 2)) <= 26) {
            ways += decodeWaysMemoHelper(s.substring(2), memo   );
        }

        memo.put(s, ways); 
        return ways;
    }

    public static int decodeWaysNoMemoHelper(String s) {
        if (s.isEmpty()) return 1;
        if (s.startsWith("0")) return 0;
        
        int ways = decodeWaysNoMemoHelper(s.substring(1));
        if (s.length() >= 2 && Integer.parseInt(s.substring(0, 2)) <= 26) {
            ways += decodeWaysNoMemoHelper(s.substring(2));
        }
        
        return ways;
    }

    public static int decodeWaysNoMemo(String s) {
        if (s.isEmpty()) return 0;
        return decodeWaysNoMemoHelper(s);
    }


    public static int decodeWaysMemo(String s) {
        if (s.isEmpty()) return 0; 

        Map<String, Integer> memo = new HashMap<>();
        return decodeWaysMemoHelper(s, memo);
    }



    // based on the induction proof we have that 
    // waysToDecode[i] = waysToDecode[i-1] (if new single digit is valid) + waysToDecode[i-2] (if last 2 digits are valid)
    public static int decodeWaysDPHelper(String s) {
        int n = s.length();
        // crate or dp array 
        int[] dp = new int[n+1]; 
        dp[0] = 1; // zeroth element is 1 , because if input string is empty you return 1
        dp[1] = s.charAt(0) == '0' ? 0 : 1; 

        for(int i=2; i <= n; i++) {

            int oneDigit = Integer.valueOf(s.substring(i-1, i));
            int twoDigit = Integer.valueOf(s.substring(i-2, i)); 

            // check if first digit is valid and add to the result 

            if(oneDigit >=1) 
                dp[i] += dp[i-1]; 

            // check if second digit is valid and add it to the result

            if (twoDigit >= 10 && twoDigit <= 26) 
                dp[i] += dp[i-2]; 

            
    
        }

        return dp[n];
    }

    public static int decodeWaysDP(String s) {
        if (s.isEmpty()) return 0; 

        return decodeWaysDPHelper(s);
    }

    public static int decodeWays(String s) {
        //return decodeWaysNoMemo(s);
        //return decodeWaysMemo(s);
        return decodeWaysDP(s);
    }

    // APPROACH 
    // We can make a recursive top bottom approach like this
    // recursive call result[i][j] = result[i][j+1] + result[i+1][j]
    public static int uniquePathsNoMemo(int i, int j, int m, int n) {
        // case base
        if(i == m - 1 && j == n - 1)  
            return 1;         
        else if(i == m || j == n) 
            return 0; 
        else {
            return uniquePathsNoMemo(i, j+1, m, n) +  uniquePathsNoMemo(i+1, j, m, n); 
        }
             
    }


    public static int uniquePathsMemo(int i, int j, int m, int n, Map<String, Integer> memo) {


        // case base
        if(i == m - 1 && j == n - 1)  
            return 1;         
        else if(i == m || j == n) 
            return 0; 
    
            String xKey = String.valueOf(i) + String.valueOf(j+1);
            String yKey = String.valueOf(i+1) + String.valueOf(j); 
            int x =   memo.containsKey(xKey) ? memo.get(xKey) : uniquePathsMemo(i, j+1, m, n, memo);
            memo.put(xKey, x);
            int y =  memo.containsKey(yKey) ? memo.get(yKey) : uniquePathsMemo(i+1, j, m, n, memo);
            memo.put(yKey, y);
        
            // check memo     


          
        return  x + y;           
    }

    // Approach, TOP DOWN DP
    // create matrix mxn
    // iterate from start to robot, so possible moves are only up and left
    // so first col and first row can only have one direction; to wach for boundaries 
    // other cells just sum the up and left
    // return last cell 
    // time complexity O(N)
    // space complexity O(MxN)
    public static int uniquePathsDP(int m, int n) {
        int dp[][] = new int[m][n];
        for(int i=0; i < m;  i++) {
            for(int j= 0; j < n; j++) {
                if (i == 0 || j == 0) 
                    dp[i][j] = 1; 
                else    
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];         
            }
        }
        return dp[m-1][n-1];
    }


    public static int uniquePaths(int m, int n){

        //return uniquePathsNoMemo(0, 0, m, n); 
        

        // create key pair structue for memo
        // Map<String,Integer> memo = new HashMap<>();
        // return uniquePathsMemo(0, 0, m, n, memo);


        return uniquePathsDP(m, n); 
    }




    public static boolean jumpGame(int[] nums){
        
    }
    
}


