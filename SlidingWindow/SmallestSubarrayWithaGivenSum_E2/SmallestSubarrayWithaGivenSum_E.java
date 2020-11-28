package slidingwindow.SmallestSubarrayWithaGivenSum_E2;

// Problem Statement #
// Given an array of positive numbers and a positive number ‘S’, find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.

// Example 1:

// Input: [2, 1, 5, 2, 3, 2], S=7 
// Output: 2
// Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2].
// Example 2:

// Input: [2, 1, 5, 2, 8], S=7 
// Output: 1
// Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].
// Example 3:

// Input: [3, 4, 1, 1, 6], S=8 
// Output: 3
// Explanation: Smallest subarrays with a sum greater than or equal to '8' are [3, 4, 1] or [1, 1, 6].

public class SmallestSubarrayWithaGivenSum_E {

  public static int findSmallestSubarray(int S, int[] arr){

    int sum = 0;
    int min = Integer.MAX_VALUE;
    int start = 0;

    for(int end = 0; end < arr.length; end++){
      sum += arr[end];

      while(sum >= S){
        int len = end - start + 1;
        min = Math.min(min, len);
        
        sum -= arr[start];
        start++;
      }
    }

    return min;
  }
  //Time: O(n), Space: O(1)

  public static void main(String[] args) {
    int result = findSmallestSubarray(8, new int[]{3,4,1,1,6});
    System.out.println("The result is " + result);
  }
}
