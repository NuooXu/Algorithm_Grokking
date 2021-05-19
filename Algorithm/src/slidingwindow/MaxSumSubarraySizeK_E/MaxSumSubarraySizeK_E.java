package slidingwindow.MaxSumSubarraySizeK_E;
// Problem Statement 
// Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.

// Example 1:

// Input: [2, 1, 5, 1, 3, 2], k=3 
// Output: 9
// Explanation: Subarray with maximum sum is [5, 1, 3].
// Example 2:

// Input: [2, 3, 4, 1, 5], k=2 
// Output: 7
// Explanation: Subarray with maximum sum is [3, 4].

public class MaxSumSubarraySizeK_E {

  public static int findMaxSumSubarray(int k, int[] arr){
    int max = 0, sum = 0, start = 0;
    for(int end = 0; end < arr.length; end ++){
      sum += arr[end];
      if(end >= k - 1){
        max = Math.max(max, sum);
        sum -= arr[start];
        start++;
      }
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println("Max sum of subarray of size K :" + findMaxSumSubarray(3, new int[] {2,1,5,1,3,2}));
  }
}
//Time: O(N) Space: O(1)