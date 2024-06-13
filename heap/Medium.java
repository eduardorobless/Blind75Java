package heap; 
import java.util.*;


public class Medium {



    /** Top K frequent 
     *  Objective
     *      Determine the k frequent numbers in an array. 
     * 
     *  Strategy
     *      Bucket sort on  each number frequency. ( can also use heap-based structure when k is much smaller to n)
     *      
     * 
     *  Time Complexity
     *      O(N)
     *  Space Complexity 
     *      O(N)
     *      
     */
    private static int[] topFrequentFun(int[] nums, int k) {
        // TODO create list bucket as array of list of integers
       


        // TODO create frequency number 
        @SuppressWarnings({"rawtypes", "unchecked"})
        
        List<Integer>[] buckets  = new List[nums.length + 1];
        
        Map<Integer, Integer> frequencyMap = new HashMap<>();
    


        for(int n: nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        // store frequencies into buckets    
        for(int key: frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);

        

            if(buckets[frequency] == null) 
                buckets[frequency] = new ArrayList<>();

            buckets[frequency].add(key);

        }

        // TODO return most frequent k values

        int[] res = new int[k]; 
        int counter = 0;
        for(int i = buckets.length -1; i >= 0 && counter < k; i--) {
            List<Integer> currentBucket = buckets[i];

            if(currentBucket != null) {
                for(int num: currentBucket) {
                    res[counter++] = num;
                    if(counter == k) {
                        break;
                    }
                }
            }
        }

        return res;
         
    }

    public static int[] topFrequent() {
        int[] nums = {
            1, 1, 1, 2, 2, 3
        };
        int k = 2;
        return topFrequentFun(nums, k );
    }
}