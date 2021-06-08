package twopointers.M5_TripletSumtoZero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Problem Statement #
// Given an array of unsorted numbers, find all unique triplets in it that add up to zero.

// Example 1:

// Input: [-3, 0, 1, 2, -1, 1, -2]
// Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
// Explanation: There are four unique triplets whose sum is equal to zero.
// Example 2:

// Input: [-5, 2, -1, -2, 3]
// Output: [[-5, 2, 3], [-2, -1, 3]]
// Explanation: There are two unique triplets whose sum is equal to zero.

public class TripletSumtoZero_M {
  public static List<List<Integer>> triplet(int[] arr){
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(arr);
    for(int i = 0; i < arr.length - 2; i++){ //注意这里的 -2
      if(i > 0 && arr[i] == arr[i -1]) continue; //跳过重复值
      int target = 0 - arr[i];
      findTarget(arr, target, i + 1, res);
    }
    return res;
  }

  public static void findTarget(int[] arr, int target, int left, List<List<Integer>> res){
    int right = arr.length - 1;
    while(left < right){
      int sum = arr[left] + arr[right];
      if(sum == target){
        res.add(Arrays.asList(-target, arr[left], arr[right])); // arrays.aslist用法
        left++;
        right--;
        //注意这里left和right改变后，都要while循环跳过重复的值
        while(left < right && arr[left] == arr[left - 1]){ 
          left++;
        }
        while(left < right && arr[right] == arr[right + 1]){
          right--;
        }
      }else if(sum > target){
        right--;
      }else if(sum < target){
        left++;
      }
    }
  }
  public static void main(String[] args) {
    System.out.println(triplet(new int[]{-3, 0, 1, 2, -1, 1, -2}));
    System.out.println(triplet(new int[]{-5, 2, -1, -2, 3}));
  }
  
}
