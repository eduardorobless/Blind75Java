package string; 



public class Easy {


    /**
     * Valid parantheses
     * 
     * Strategy: 
     * 
     *  Push opening brace on stack, pop if matching close brace, at end if stac empty, return true;
     * 
     * 
     * 
     * Time Complexity: 
     * 
     * O(N)
     * 
     *
     * Space Complexity: 
     * 
     * O(N)
     */




    private static  boolean validParanthesesSetup(String valid) {
        
        Stack<Character> stack = new Stack<>();


        // if is open push it if not check it, remember edge cases for when stack is empty!
        for(Character c: valid.toCharArray()) {
            if(c == '(' || c == '[' || c == '{') stack.push(c); 

            else {
                if(stack.isEmpty()) return false;

                // check for mistmatching with top and new closing char
                char top = stack.pop();

                if(    (c == ')' && top != '(') || 
                        (c == ']' && top != '[' ) ||
                        (c == '}' && top != '{')  ) 
                    return false;
                        
            }
        }

        return stack.isEmpty();

    }


    
    public static boolean validParentheses() { 
        String valid = "()[]{}";
        return validParanthesesSetup(valid); 
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