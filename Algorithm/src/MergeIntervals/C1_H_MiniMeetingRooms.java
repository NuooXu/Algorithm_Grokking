package MergeIntervals;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Meeting {
  int start;
  int end;
  public Meeting(int start, int end){
    this.start = start;
    this.end = end;
  }
}

public class C1_H_MiniMeetingRooms {
  public static int findMiniRooms(List<Meeting> meetings){
    Collections.sort(meetings, (a,b) -> Integer.compare(a.start, b.start));
    int minRooms = 0;
    PriorityQueue minHeap = new PriorityQueue<>(meetings.size(), (a,b) -> Integer.compare(a.end, b.end));

    for(Meeting meeting : meetings){
      while(!minHeap.isEmpty() && meeting.start > minHeap.peek().end){
        minHeap.poll();
      }
      minHeap.offer(meeting);
      minRooms = Math.max(minRooms, minHeap.size());
    }
    return minRooms;
  }
}
