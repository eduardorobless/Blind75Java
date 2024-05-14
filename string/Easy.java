package string; 



public class Easy {
    private static  boolean validParantheses() {
        return false;
    }



    /**
     * Valid Palindrome 
     * 
     * Strategy:
     * 
     * 1 - Two pointers , one at first, one at the end, 
     * 2 - Move two pointers accordingly left to right right to left until they are equal. 
     *      return true at the end. Return false if either by comparing left and right pointer,
     *       they are valid lower case alphanumeric characters, skipping non alphanumeric characters from left or right pointers.
     * 
     * Time Complexity: 
     * O(N)
     * Space Complexity:
     * O(1)
     *    
     *  
     */

    private static boolean validPalindromeSetup(String s) {
        int l = 0; 
        int r = s.length() - 1; 

        while(l  < r) {
            // skip non alphanumeric charactesrs from either pointer 
            // first left 
            if (!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }                  
            else if(!Character.isLetterOrDigit(s.charAt(r))) {
                r--; 
            }
            else if(Character.toLowerCase(s.charAt(l)) == Character.toLowerCase(s.charAt(r))) {
                l++; 
                r--;
            }
            else {
                return false;
            }
            
        }


        return true;


    }
    public static boolean validPalindrome() {
        String str1 = "anita lava la tina";


        return validPalindromeSetup(str1);


    }


    private static boolean validAnagram() {
        return false;
    }   
}