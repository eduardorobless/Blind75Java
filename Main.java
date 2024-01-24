
import static string.Easy.*; 

class Main {
    static Object res;  
    public static void main(String[] args) {
        
        // res =twoSumBruteForce( new int[]{2 ,7,11,15}, 9);
        // if (res != null && res instanceof int[])   {
        //     int[] arrayResult = (int[]) res;
        //     for (int val : arrayResult) {
        //         System.out.println(val);
        //     }

        // }

        // res = twoSumOptimal(new int[]{2, 7, 11, 15}, 9); 
        // if (res != null && res instanceof int[]) {
        //     int[] arrayResult = (int[]) res; 
        //     for(int val : arrayResult) {
        //          System.out.println(val);
        //     }
        // }


        
        //res = bestTimeToBuySellStock(new int[]{7,1,5,3,6,4});
        // res = bestTimeToBuySellStock(new int[]{7,6,4,3,1});

        // if(res != null  && res instanceof Integer) {
        //     int intResult = (int) res; 
        //     System.out.println(intResult); 
        // }


        // res = containsDupicate(new int[]{1,2,3,1}); 
        // res = containsDupicate(new int[]{1,2,3,4});
        // if(res != null && res instanceof Boolean) {
        //     boolean boolResult = (boolean) res; 
        //     System.out.println(boolResult);
        // }

        // res = productOfArrayExceptSelf(new int[]{1, 2, 3, 4}); 
        res = productOfArrayExceptSelf(new int[]{-1,1,0,-3,3}); 
        printArrayRes(res); 


    }



    private static void printArrayRes(Object res) {
        if (res != null && res instanceof int[]) {
            int[] arrayResult = (int[]) res; 
            for(int val : arrayResult) {
                 System.out.println(val);
            }
        }
    }
}