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

    private static int longestRepeatingCharacterReplacement() {
        return 0;
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
    
    







    private static List<List<String> groupAnagramsSortingFun(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map  = new HashMap<>(); 


        for(String s: strs) {
            char [] tempArray = s.toCharArray();
            Arrays.sort(tempArray);
            String sortedString = new String(tempArray); 



            if(map.containsKey(sortedString)) {
                map.get(sortedString).add(s); 
            } else {
                List<String> tmplist = new ArrayList();
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