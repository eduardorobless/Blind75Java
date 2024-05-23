package string;
import java.util.*;


public class Medium {

    /**
     * Longest Substring Without Repeating Charactesr 
     * 
     * Strategy
     *  1 - Use a slidinig window to determine if character existing in substring is already being
     *  found, if that's the case then update left pointer accordingly. 
     *  2 - Store in a map last found index of character, if character is already found and pertains to substring, 
     *  update left pointer and map entry, otherwise move right pointer , add entry to map and increment max.
     * 
     * 
     *  Time Complexity
     *  O(N)
     * 
     *  Space Complexity
     * 
     *  O(1)
     *  
     */
    


    private static int longestSubstringWithoutRepeatingCharactersFun(String s) {
        if (s == null) return 0; 
        int maxLength = 0;
        Map<Character, Integer> lastFound = new HashMap<>();

        for(int right = 0, left = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            // case when repeating chars withing substring. 
            if(lastFound.containsKey(current) && lastFound.get(current) >= left) 
                // get index from map as you need to know where was its last index
                left = lastFound.get(current) + 1;     
            // add entry to map and update max length; 
            else                        
                maxLength = Math.max(maxLength, right - left  + 1);

            lastFound.put(current, right);
            
        }

        return maxLength;                
    }




    public static int longestSubstringWithoutRepeatingCharacters() {
        String a = "abcabcbb";
        
        return longestSubstringWithoutRepeatingCharactersFun(a);

    }



    /**
     * Longest Repaeting character replacement
     * 
     * 
     * 
     *  Strategy: 
     * 
     * 
     *  1 - Use two pointers and sliding window.
     *      Keep track of the character frequency; use a map , keys are the char, increment their count.
     *  2 - Determine if we are in a valid segment: we need to determine the character with higher frequnency in order to determine if
     *      we can have a valid segment which is said to be one when the lenght of substring - higher frequency of character in substring > k
     *  3 - if we are in valid segment then we can also update max length of substring , to determine if we are in valid segment: 
     *      substrating length  (right - left + 1) - higher frequency of character. update max length with length of valid sagment.
    * 
     *  4 - In other case we need to decrement left character from map, and inrement left pointer, and reset counter of higher frequency character.
     * 
     *  Time Complexity 
     *      O(N)
     * 
     *  Space Complexity 
     *      O(26)
     * 
     * **/


    private static int longestRepeatingCharacterReplacementFun(String s, int k) {
        int maxLenght = 0; 
        int [] count = new int[26];
        int maxCharacter = 0;    

        for(int r = 0, l = 0; r < s.length(); r++) {
            
            char currChar = s.charAt(r);
            count[currChar- 'A']++; // increment character count; 
            maxCharacter = Math.max(maxCharacter, count[currChar - 'A'] );  // max number of chracter 
            
            if ((r - l + 1)  - maxCharacter > k)  {
                count[s.charAt(l) - 'A']--; 
                l++;
            } 
            
            maxLenght =  Math.max(maxLenght, r - l + 1);  
        }

        return maxLenght;  

    } 
    public static int longestRepeatingCharacterReplacement() {
        String s = "ABAB";
        int k = 2; 
        return longestRepeatingCharacterReplacementFun(s, k);
    }




    /**
     * Group anagrams: 
     * 
     * 
     * Stategy wihtout sorting:
     * 
     * 
     * 1 - determine frequency of each string in the list
     * 2 - Add frequency string to hash map as key, and add string to value
     * 
     * Time Complexity: 
     * 
     * 
     * O(N * k)
     * 
     * Space Complexity:
     * 
     * 
     * O(N)
     * 
     * 
     * When to use it: 
     * 
     *  When k is much larger than N
     * 
     * 
     * 
     * Strategy with sorting: 
     * 
     * 
     * 1 - Sort strings, if they are anagram they would be at the same list
     * 
     * Time complexity:
     * 
     * Space complexity:
     * 
     * 
     * 
     * When to use it 
     * 
     */
    
    







    private static List<List<String>> groupAnagramsSortingFun(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map  = new HashMap<>(); 


        for(String s: strs) {
            char [] tempArray = s.toCharArray();
            Arrays.sort(tempArray);
            String sortedString = new String(tempArray); 



            if(map.containsKey(sortedString)) {
                map.get(sortedString).add(s); 
            } else {
                List<String> tmplist = new ArrayList<>();
                tmplist.add(s);
                map.put(sortedString, tmplist);
            }
        }


        for(Map.Entry<String, List<String>> entry: map.entrySet()) {
            result.add(entry.getValue());
        }
        
        // loop trough each string in input
        // sort the string 
        // insert into the hashmap 
        // itearte tro ugh the hashmap and put each value in our result array 
        // return result array



        return result; 

    }
    
    private static String  stringFrequency(String s) {        
        int [] freq = new int[26];

        // init freq array
        for(char myChar: s.toCharArray()) 
            freq[myChar - 'a'] ++;

        // retrieve sting 
        char myChar = 'a';
        StringBuilder frequencyString = new StringBuilder();

        for(int alpha: freq) { 
            frequencyString.append(myChar);
            frequencyString.append(alpha);
            myChar++;
        }

        return frequencyString.toString();

    }
    private static List<List<String>> groupAnagramsFun(String[] strs) {
        Map<String, List<String> > freq = new HashMap<>(); 

        if (strs == null || strs.length == 0) return new ArrayList<>();


        for(String s: strs) {
            // get frequency of the string as string frequency value, if present add it to map list 

            String frequencyString = stringFrequency(s); 
            // if not create list and add it

            if (freq.containsKey(frequencyString)) 
                freq.get(frequencyString).add(s);
            
             else {
                List<String> list = new ArrayList<>();
                list.add(s);
                freq.put(frequencyString, list);
            }
        }

        return new ArrayList<>(freq.values());     
    }
    public static List<List<String>> groupAnagrams() {
        String [] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        return groupAnagramsFun(strs);
    }




    /**
     * 
     * 
     *  Longest Palindromic substring
     * 
     *  Strategy: 
     * 
     *  To be able to solve this problem, note that you need to do: 
     *
     *  1 - Iterate trough string, starting from position 1 to end of string. Then look for odd and even palindromic substrings. 
     * 
     *  
     * 
     *  To look for odd position do: 
     *  Starting two pointers at same positon , afterwerds, to look for left and right positions
     *  until bound are met, our bounds are first and last index. 
     * 
     *  To lok for even position, do:
     * 
     *  Startig from left pointer one positionleft of right pointer, look for left and right positions 
     *  until bound positions are met, they are same as odd position. 
     * 
     *  2 - return longest palindromic substring
     * 2 - 
     */


    private static String expandAroundCenter(String s, int left, int right) {
        //what the fuck you gonnad do , you are gonna do expand around bounds and same characters return from left + 1 and right - 1 
        while(left >= 0 && right < s.length()  && s.charAt(left) == s.charAt(right))   {
            left--; 
            right++;
        }
        return s.substring(left + 1, right);
    }


    private static int countAroundCenter(String s, int left, int right, int count) {
        //what the fuck you gonnad do , you are gonna do expand around bounds and same characters return from left + 1 and right - 1 
        while(left >= 0 && right < s.length()  && s.charAt(left) == s.charAt(right))   {
            left--; 
            right++;
            count++;
        }
        return count;
    }
    private static String longestPalindromicSubstringFun(String s) {

        if(s == null || s.isEmpty()) return "";
        String lps = ""; 
        int sLength = s.length();
        if (s.length() == 1) return s;

        for(int i = 0 ; i < sLength;  i++) { 
            
            //odd 
            String oddPalindrome = expandAroundCenter(s, i, i); 
            System.out.println("ODD: " + oddPalindrome + ",  i: " + i);

            if(oddPalindrome.length() > lps.length()) 
                lps = oddPalindrome;



            //even 
            String evenPalindrome = expandAroundCenter(s, i, i+1);
            System.out.println("EVEN: " + evenPalindrome + ",  i: " + i);
            if(evenPalindrome.length() > lps.length())
                lps = evenPalindrome;
        }

        return lps;

        
    }   
    public static String longestPalindromicSubstring() {
        String s = "aaa";
        return longestPalindromicSubstringFun(s);
    }


    private static int palindromicSubstringsFun(String s) { 

        if(s == null || s.isEmpty()) return 0;
        if (s.length() == 1) return 1;
        
        int count = 0; 
        int sLength = s.length();

        for(int i = 0 ; i < sLength;  i++) {                     
            count = countAroundCenter(s, i, i, count); 
            count = countAroundCenter(s, i, i+1, count);                
        }

        return count;


    }
    public static int palindromicSubstrings() {

        String s = "aaa";
        return palindromicSubstringsFun(s);
    }

    private static String encodeDecodeStringS() {
        return  ""; 
    }
}