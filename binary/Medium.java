package binary;



public class Medium{
    public static int sumOfTwoInteger(int a, int b){
        // use the power of xor and and logic baby 

        while(b != 0){
            int temp = (a & b) << 1; // carry part 
            a = a ^ b; // sum part
            b = temp; // again sum 
        }

        return a;

    }



}