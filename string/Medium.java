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
    


    private static int longestSubstringWithoutRepeatingCharactersSetup(String s) {
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
        
        return longestSubstringWithoutRepeatingCharactersSetup(a);

    }

    private static int longestRepeatingCharacterReplacement() {
        return 0;
    }


    private static List<List<String>> groupAnagrams() {
        return null;
    }

    private static String longestPalindromicSubstring() {
        return "";
    }

    private static int palindromicSubstrings() {
        return 0;
    }

    private static String encodeDecodeStringS() {
        return  ""; 
    }
}