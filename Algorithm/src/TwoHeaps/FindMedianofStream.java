package TwoHeaps;

import java.util.PriorityQueue;

public class FindMedianofStream {

  PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
  PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> a - b);

  public void insertNum(int num){
    if(maxHeap.isEmpty() || maxHeap.peek() >= num){
      maxHeap.add(num);
    }else{
      minHeap.add(num);
    }

    if(maxHeap.size() > minHeap.size() + 1){
      minHeap.add(maxHeap.poll());
    }else if(maxHeap.size() < minHeap.size()){
      maxHeap.add(minHeap.poll());
    }
  }

  public double findMedian(){
    if(maxHeap.size() == minHeap.size()){
      return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }else{
      return maxHeap.peek();
    }
  }


  //insert to heap time complexity is: O(logN)
  //space complexity is: O(N)
}
