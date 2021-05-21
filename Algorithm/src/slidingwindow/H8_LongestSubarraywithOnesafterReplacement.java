package slidingwindow;

public class H8_LongestSubarraywithOnesafterReplacement {
  public static int find(int[] arr, int k){
    int start = 0, max = 0, zero = 0, one = 0;

    for(int end = 0; end < arr.length; end++){
      int cur = arr[end];
      if(cur == 0){
        zero++;
      }else{
        one++;
      }
      while(zero > k){
        int reduce = arr[start];
        if(reduce == 0){
          zero--;
        }else{
          one--;
        }
        start++;
      }
      max = Math.max(max, end - start + 1);
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println(find(new int[] {0,1,1,0,0,0,0,1,1,0,1,1}, 2));
    System.out.println(find(new int[] {0,1,0,0,1,1,0,1,1,0,0,1,1}, 3));
  }
}
