
import static arrays.Easy.*; 

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
        //res = productOfArrayExceptSelf(new int[]{-1,1,0,-3,3}); 
        //res = maxSubArrayON(new int[]{-2,1,-3,4,-1,2,1,-5,4}); 
        //res = maxSubArrayON(new int[]{1});
        // res = maxSubArrayON(new int[]{5,4,-1,7,8});
        // printArrayRes(res); 

        // int maxValue = maxBinaryTree();
        // System.out.println("Maximu value in the binary tree " + maxValue);
        //int res = maxProductSubArray(new int[] {2, 3, -2, 4});
        // int res = maxProductSubArray(new int[] {-2, 0, -1});

        //int res = findMinimumInRotatedSortedArray(new int[]{3,4,5,1,2});      
        // int res = findMinimumInRotatedSortedArray(new int[]{3,1,2});      
        // if ( res != (MAX_VALUE_SORTED_ARRAY + 1) )
        //     printRes(res); 


        // int  res= searchInRotatedSortedArray(new int[]{4,5,6,7,0,1,2}, 2); 
        // printRes(res); 


        // int res = containerWithMostWater(new int[]{1,8,6,2,5,4,8,3,7});
        int res = containerWithMostWater(new int[]{1,1});
        printRes(res); 

    }



    private static void printRes(Object res) {
        if (res != null && res instanceof int[]) {
            int[] arrayResult = (int[]) res; 
            for(int val : arrayResult) {
                 System.out.println(val);
            }
        }
        else if(res != null && res instanceof Integer) {
            System.out.println(res); 
        }
    } 
}