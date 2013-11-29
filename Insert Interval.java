/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        
        
        /*To deal the the corners cases first:
          1) The input intervals is null
          2) newInterval will be inserted to the end of the intervals
          3) newInterval will be inserted at the beginneing of the intervals
        */  
        if(intervals.size()==0){
            result.add(newInterval);
            return result;
        }
        else if(intervals.get(intervals.size()-1).end < newInterval.start){
            intervals.add(newInterval);
            return intervals;
        }
        else if(intervals.get(0).start > newInterval.end){
            intervals.add(0, newInterval);
            return intervals;
        }
        
        
        
        Interval new_one = new Interval();
        
        //inserting is to indicate the beginning of the insertion
        //inserted is to indicated the end of the insertion
        boolean inserted =  false;
        boolean inserting = false;
        
        for(int i=0; i<intervals.size();++i){
            int cur_start = intervals.get(i).start;
            int cur_end   = intervals.get(i).end;
            
            if(cur_end < newInterval.start || inserted){
                result.add(intervals.get(i));
            }
            else{
                //To deal with the start of the newInterval
                if(!inserting){
                    inserting = true;
                    if(newInterval.start < cur_start){
                        new_one.start = newInterval.start;
                    }
                    else{
                        new_one.start = cur_start;
                    }
                } 
                
                //To deal with the end of the newInterval
                if(newInterval.end < cur_start){
                    new_one.end = newInterval.end;
                    result.add(new_one);
                    result.add(intervals.get(i));
                    inserted = true;
                    inserting = false;
                }
                else if(newInterval.end <= cur_end){
                    new_one.end = cur_end;
                    result.add(new_one);
                    inserted = true;
                    inserting = false;
                }
                else{
                    new_one.end = newInterval.end;
                }
                
            }
        }
        
        if(!inserted) result.add(new_one);
        
        return result;
    }
}