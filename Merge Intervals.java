/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
*/

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
        
        ArrayList<Interval> result= new ArrayList<Interval>();
        if(intervals.size()==0) return result;
        
        // Sorted the intervals by their start element
        Collections.sort(intervals, new Comparator<Interval>(){
        	public int compare(Interval a, Interval b) {
                return (a.start - b.start);
            }       	
        });
        
        Interval pre = new Interval(intervals.get(0).start, intervals.get(0).end);
        
        int index = 1;
        
        while(index<intervals.size()){
            if(pre.end < intervals.get(index).start){
                result.add(pre);
                pre = intervals.get(index);
            }
            else{
                pre.end = Math.max(pre.end, intervals.get(index).end);
            }
            ++index;
        }
        
        result.add(pre;)
        
        return result;
    }
}