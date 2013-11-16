/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
    	if(intervals.size() == 0 || intervals.size() == 1)
    		return intervals;
    	
    	ArrayList<Interval> ret = new ArrayList<Interval>();
    	Collections.sort(intervals, Int_compare);

    	Interval current = intervals.get(0);
    	Interval runner;
    	
    	for(int i = 1; i < intervals.size(); i++) {
    		runner = intervals.get(i);
    		
    		if(runner.start > current.end) {
    			ret.add(current);
    			current = runner;
    		} else if(runner.start <= current.end) {
    			//current = new Interval(current.start, runner.end);
    			current.start = current.start;
    			current.end = Math.max(current.end, runner.end);
    		}
    	}
    	
    	ret.add(current);
    	
    	return ret;
    }
    
    static Comparator<Interval> Int_compare = new Comparator<Interval>() {
    	public int compare(Interval i_1, Interval i_2) {
    		return (int) i_1.start - i_2.start;
    	}
    };    
}
