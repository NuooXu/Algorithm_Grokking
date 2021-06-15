package MergeIntervals.M2_MergeIntervals;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class Interval {
  int start;
  int end;
  public Interval(int start, int end){
    this.start = start;
    this.end = end;
  }
}

public class M2_MergeIntervals {
  public static List<Interval> merge(List<Interval> intervals) {
    if(intervals.size() < 2) return intervals;

    List<Interval> mergedIntevals = new LinkedList<Interval>();
    Collection.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
    Iterator<Interval> iterator = intervals.iterator();
    Interval interval = iterator.next();
    int start = interval.start;
    int end = interval.end;

    while(iterator.hasNext()){
      Interval interv = iterator.next();
      if(interv.start <= end){
        end = Math.max(end, interv.end);
      }else{
        mergedIntevals.add(new Interval(start, end));
        start = interv.start;
        end = interv.end;
      }
      mergedIntevals.add(new Interval(start, end)); //这里要注意写在外面的
    }
    return mergedIntevals;
  }
}

// [1,3] [2,5] [7,8]