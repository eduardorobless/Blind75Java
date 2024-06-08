package interval;
import java.util.*;

public class Medium {
    /** Meeting Rooms II
     *  Objective  
     *      Determine the minimum number of rooms need to attend possible meetings , based on a list of intervals. 
     *  Strategy.  Note that each start time is always leess than each end time.  
     * 
     *      Sort start , and end arrays.
     *      Increment count to 1. 
     *      Store last end
     *      Move next start, and check if inside  last interval, if it is increment count to 1; 
     *      when it is finished decrease by 1. (when last interval is finished decreased too). 
     *      move next start and next end and repeat process
     *     
     *      If we ever have a tie between end and start , keep going. 
     *      
     *      If not, decrease by one,  keep going; 
     *      move to next start and next end.
     *  
     * 
     *      retur minimum number of rooms required.
     * 
     *  Time Complexity: O(N lg(N))
     *  Space Complexity: O(N)
     */
    private static int meetingRoomsIIFun(List<Interval> intervals) { 
        int[] startValues = intervals.stream()
                            .filter(interval -> interval instanceof Interval)
                            .mapToInt(interval -> ( (IntervalExtend) interval).getStart()  )                              
                            .toArray(); 

        int[] endValues = intervals.stream()
                            .filter(interval -> interval instanceof IntervalExtend)
                            .mapToInt(interval -> ( (IntervalExtend) interval).getEnd()  )  
                            .toArray();                             

        Arrays.sort(startValues); 
        Arrays.sort(endValues);

        int count = 0; 
        int res = 0;
        int s = 0;
        int e = 0;


        while (s < intervals.size() ) {
            if(startValues[s] < endValues[e] ) {
                count++;
                s++;
            }
            else {
                count--; 
                e++;
            }

            res = Math.max(res, count);
        }
        return res;
    }

    public static int meetingRoomsII() {

        List<Interval> mutableIntervals = new ArrayList<>(); 
        mutableIntervals.add(new  IntervalExtend(0, 30));
        mutableIntervals.add(new IntervalExtend(5, 10)); 
        mutableIntervals.add(new IntervalExtend(15, 20));
        return meetingRoomsIIFun(mutableIntervals);
    }
}