package MergeIntervals.M3_InsertInterval;

import java.util.ArrayList;
import java.util.List;

class Interval {
  int start;
  int end;
  public Interval(int start, int end){
    this.start = start;
    this.end = end;
  }
}

public class M3_InsertInterval {
  public static List<Interval> insert(List<Interval> intervals, Interval newInterval){
    List<Interval> mergedIntervals = new ArrayList<>();
    //1.skip all intervals end < new.start
    int i = 0;
    while(i < intervals.size() && intervals.get(i).end < newInterval.start){
      mergedIntervals.add(intervals.get(i++));
    }
    //2.merge all overlap intervals
    while(i < intervals.size() && intervals.get(i).start <= newInterval.end){
      newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
      newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
      i++;
    }
    mergedIntervals.add(newInterval);
    //3.add all left intervals in
    while(i < intervals.size()){
      mergedIntervals.add(intervals.get(i++));
    }
    return mergedIntervals;
  }
}
