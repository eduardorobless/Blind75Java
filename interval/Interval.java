package interval;


 class IntervalExtend extends Interval {
    IntervalExtend(int start, int end) {
        super(start, end);
    }
     public int getStart() {
         return start;
     }
     public int getEnd() {
        return end;
     }
 }                                              
public class Interval{
    int start, end; 
    Interval(int start, int end) {
        this.start = start; 
        this.end = end; 
    }
}   