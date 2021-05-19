package slidingwindow.Introduction;

import java.util.Arrays;

class Introduction {
   public static double[] findAverages(int k, int[] arr){
    double[] result = new double[arr.length - k + 1];
    double sum = 0;
    int start = 0;
    for(int end = 0; end < arr.length; end++){
      sum += arr[end];
      if(end >= k - 1){
        result[start] = sum / k;
        sum -= arr[start];
        start++;
      }
    }
    return result;
   } 

  public static void main(String[] args){
    double[] result = Introduction.findAverages(5, new int[] {1,3,2,6,-1,4,1,8,2});
    System.out.println("average subarray of size k is:" + Arrays.toString(result));
  }
}

