package MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Interval {
  int start;
  int end;
  public Interval(int start, int end){
    this.start = start;
    this.end = end;
  }
}

public class M4_IntervalsIntersection{
  public static Interval[] merge(Interval[] arr1, Interval[] arr2){
    List<Interval> res = new ArrayList<>();
    //1.find the overlap intervals
    int i = 0, j = 0;
    while(i < arr1.length && j < arr2.length){
      if(arr1[i].start >= arr2[j].start && arr1[i].start <= arr2[j].end || arr2[j].start >= arr1[i].start && arr2[j].start <= arr1[i].end){
        //2.add the overlap part
        res.add(new Interval(Math.max(arr1[i].start, arr2[j].start), Math.min(arr1[i].end, arr2[j].end)));
      }
      //  3.move to compare the next pair
      if(arr1[i].end < arr2[j].end){
        i++;
      }else{
        j++;
      }
    }
    return res.toArray(new Interval[res.size()]);
  }

  //solution for M5_ConflictingAppointments
  public static boolean check(Interval[] intervals){
    Arrays.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));

    for(int i = 0; i < intervals.length - 1; i++){
      if(intervals[i].end > intervals[i+1].start){
        return false;
      }
    }
    return true;
  }
  //Because of sort: TIME O(N * NLogN) SPACE: O(N)
}