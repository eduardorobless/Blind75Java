package binary;



public class Easy{
    public static int numberOfOneBits(int n){
        int res = 0; 
        while(n != 0 ){
            res += n & 1 ; // Add the least significant bit to the result
  //          System.out.println("res " + res + " n " + Integer.toBinaryString(n)); 
            n = n >>> 1; // Unsigned right shift to handle negative numbers properly
//            System.out.println("res " + res + " n " + Integer.toBinaryString(n));

        }
        return res; 
    }

    // public static int[] countingBits(int n){

    // }

    // public static int missingNumber(int[] nums){

    // }


    // public static int reverseBits(int n ){
        
    // }

}