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

    public static int[] countingBits(int n){
        // use dp , we simply shift right and check if we have an odd or even number 
        int [] output = new int[n + 1]; 
        for(int i = 1; i <= n; i++) {
            output[i] = output[i >> 1]  + i % 2; 
        }

        return output;
    }

    public static int missingNumber(int[] nums){
        int missing = 0; 


        for(int i=0; i <= nums.length; i++) {
            missing = missing ^ i;
        }

        for(int num: nums){
            missing = missing ^ num;
        }

        return missing; 

    }


    // public static int reverseBits(int n ){
        
    // }

}