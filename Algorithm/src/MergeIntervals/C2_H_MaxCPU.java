package MergeIntervals;

import java.util.List;
import java.util.PriorityQueue;

class Job {
  int start;
  int end;
  int cpu;

  public Job(int start, int end, int cpu){
    this.start = start;
    this.end = end;
    this.cpu = cpu;
  }
}

public class C2_H_MaxCPU {
  public static int findMaxCpu(List<Job> jobs){
    Collections.sort(jobs, (a,b) -> Integer.compare(a.start, b.start));
    PrioriryQueue<Job> minHeap = new PriorityQueue<>(jobs.size(), (a,b) -> Integer.compare(a.end, b.end));
    int curcpu = 0;
    int maxcpu = 0;

    for(Job job : jobs){
      while(!minHeap.isEmpty() && minHeap.peek().end < job.start) {
        curcpu -= minHeap.poll().cpu;
      }
      curcpu += job.cpu;
      minHeap.offer(job);
      maxcpu = Math.max(maxcpu, curcpu);
    }
    return maxcpu;
  }
}
