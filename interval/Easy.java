package interval; 
import java.util.*;

public class Easy {
    /**
     * Can attends meetings? 
     *  Objective
     *      Determine if a person can attend meetigns based on a list of intervals 
     *  Strategy
     *      Sort all intervals by starting time
     *      Check last time of each interval to determine if the next interval's start time is less .
     *      If that's the case then that is an overlap interval return false
     *      Othewise iterate till end return true
     *  Time Complexity
     *      O(NlogN); 
     *  Space Complexity
     *      O(1)
     */
    private static boolean canAttendMeetingsFun(List<Interval> intervals) {
     Comparator<Interval> comparator = (interval1, interval2) -> {
            if (interval1 instanceof IntervalExtend && interval2 instanceof IntervalExtend) {
                IntervalExtend extend1 = (IntervalExtend) interval1; 
                IntervalExtend extend2 = (IntervalExtend) interval2;
                return Integer.compare(extend1.getStart(), extend2.getStart());
            } else {
                // Define fallback behavior for Interval objects
                // For example, consider them equal
                return 0;
            }
        };
        
        Collections.sort(intervals, comparator);

        for(int i = 1; i < intervals.size(); i++) {
            int end =  intervals.get(i - 1).end; 
            int start = intervals.get(i).start;
            if(start < end) 
                return false;
        }

        return true;
    }
    public static boolean canAttendMeetings() {
        List<Interval> intervals = List.of(new Interval(0, 30), new Interval(5, 10), new Interval(15, 20));
        List<Interval> intervals2 = List.of(new Interval(5, 8), new Interval(9, 15));

        List<Interval> mutableIntervals = new ArrayList<>(); 
        mutableIntervals.add(new  Interval(0, 30));
        mutableIntervals.add(new Interval(5, 10)); 
        mutableIntervals.add(new Interval(15, 20));


        List<Interval> mutableIntervals2 = new ArrayList<>();
        mutableIntervals2.add(new Interval(5, 8)); 
        mutableIntervals2.add(new Interval(9, 15));
        return canAttendMeetingsFun(mutableIntervals2); 
    }
}

//        


// class Interval implements Comparable<Interval>{
//     int start, end; 
//     Interval(int start, int end) {
//         this.start = start; 
//         this.end = end; 
//     }

//     @Override
//     public int compareTo(Interval other) {
//         return Integer.compare(this.start, other.start);
//     }
// }    
 class IntervalExtend extends Interval {
    IntervalExtend(int start, int end) {
        super(start, end);
    }
     public int getStart() {
         return start;
     }
 }                                              
class Interval{
    int start, end; 
    Interval(int start, int end) {
        this.start = start; 
        this.end = end; 
    }
}                                                  