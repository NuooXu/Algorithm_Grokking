package twopointers.E4_SquaringSortedArray;

// Problem Statement #
// Given a sorted array, create a new array containing squares of all the number of the input array in the sorted order.

// Example 1:

// Input: [-2, -1, 0, 2, 3]
// Output: [0, 1, 4, 4, 9]
// Example 2:

// Input: [-3, -1, 0, 1, 2]
// Output: [0 1 1 4 9]

public class SquaringSortedArray_E {
  public static int[] squaring(int[] arr){
    int start = 0, end = arr.length - 1;
    int[] res = new int[arr.length];
    int cur = arr.length - 1;
    while(start <= end){
      int left = arr[start] * arr[start];
      int right = arr[end] * arr[end];
      if(left > right){
        res[cur] = left;
        start++;
      }else {
        res[cur] = right;
        end--;
      }
      cur--;
    }
    return res;
  }
  public static void main(String[] args) {
    int[] res = squaring(new int[]{-3, -1, 0, 1, 2});
    for (int i : res) {
      System.out.println(i);
    }
  }
}
