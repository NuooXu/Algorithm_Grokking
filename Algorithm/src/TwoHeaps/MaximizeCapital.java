package TwoHeaps;

import java.util.PriorityQueue;

public class MaximizeCapital {
  public static int findMaxinumCaital(int[] capital, int[] profits, int projectsNum, int initCapital){
    PriorityQueue<Integer> minCapitalHeap = new PriorityQueue<>((a,b) -> capital[a] - capital[b]);
    PriorityQueue<Integer> maxProfitsHeap = new PriorityQueue<>((a,b) -> profits[b] - profits[a]);

    for(int i = 0; i < capital.length; i++){
      minCapitalHeap.offer(i);
    }

    int capitals = initCapital;
    for(int j = 0; j < projectsNum; j++){
      while(!minCapitalHeap.isEmpty() && capital[minCapitalHeap.peek()] <= capitals){
        maxProfitsHeap.offer(minCapitalHeap.poll());
      }
      if(maxProfitsHeap.isEmpty()){
        break;
      }
      capitals += capitals + profits[maxProfitsHeap.poll()];
    }

    return capitals;
  }
  
}
